package ua.springboot.web.controller;


import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ua.springboot.web.domain.ChangePasswordRequest;
import ua.springboot.web.domain.EditUserRequest;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.UserService;
import ua.springboot.web.service.utils.CustomFileUtils;

@Controller
@RequestMapping({"/user", "/admin"})
@SessionAttributes("editUserModel")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String showUserProfile(Model model, Principal principal) throws IOException{
	UserEntity entity = userService.findUserByEmail(principal.getName());
	if(entity == null) return "redirect:/";
	
	entity.setImagePath(CustomFileUtils.getImage("user_" + entity.getId(), entity.getImagePath()));
	
	model.addAttribute("title", entity.getRole().getRole() + " profile");
	model.addAttribute("userProfile", UserMapper.entityUserToUserRequest(entity));
	return "user/profile";
    }
        
    @GetMapping("/edit")
    public String editUserProfile(Model model, Principal principal){
	UserEntity entity = userService.findUserByEmail(principal.getName());	
	EditUserRequest request = UserMapper.entityUserToEditRequest(entity);

	model.addAttribute("title", "Edit profile page");
	model.addAttribute("editUserModel", request);
	return "user/edit";
    }
    
    @PostMapping("/edit")
    public String saveEditedProfile(@ModelAttribute ("editUserModel") EditUserRequest request) throws IOException{
	UserEntity entity = UserMapper.editRequestToUserEntity(request);
	userService.updateUser(entity);
	
	CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
	return "redirect:/user";
    }
    
    @GetMapping("/change-pass")
    public String showChangePass(Model model, Principal principal){
	UserEntity entity = userService.findUserByEmail(principal.getName());	
	ChangePasswordRequest request = UserMapper.entityUserToChangePasswordRequest(entity);
	
	model.addAttribute("title", "Change password page");
	model.addAttribute("changePassModel", request);
	return "user/change-pass";
    }
    
    @PostMapping("/change-pass")
    public ModelAndView saveChangePass(
	    @ModelAttribute ("changePassModel") @Valid ChangePasswordRequest request,
	    BindingResult result,
	    Principal principal){
	if(result.hasErrors()) return new ModelAndView("user/change-pass");
	UserEntity user = userService.findUserByEmail(principal.getName());
	
	if(!request.getPassword().equals(user.getPassword())) return new ModelAndView("user/change-pass", "error", "Old password entered incorrectly");
	UserEntity entity = UserMapper.changePasswordRequestToUserEntity(request);
	userService.updateUser(entity);
	return new ModelAndView("redirect:/user/edit");
    }
    
    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showListUsers(Model model) throws IOException{
	model.addAttribute("title", "List users page");
	List<UserEntity> users = userService.findAllUsers();
	for(UserEntity user : users){
	    user.setImagePath(CustomFileUtils.getImage("user_" + user.getId(), user.getImagePath()));
	}
	model.addAttribute("userListModel", users);
	return "user/users";
    } 
    
    @GetMapping("/cart")
    public String showUserCart(Model model, Principal principal){
	UserEntity user = userService.findUserByEmail(principal.getName());
	model.addAttribute("title", "Cart page");
	model.addAttribute("cartList", user.getOrders());
	return "user/cart";
    }
    
    @GetMapping("/delete")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showDelUser(@RequestParam("id") int id){
	if(id != 1) userService.deleteUserById(id);
	return "redirect:/user/users";
    }
 
}
