package ua.springboot.web.controller;

import static ua.springboot.web.mapper.UserMapper.registerRequestToUserEntity;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.springboot.web.domain.base.LoginRequest;
import ua.springboot.web.domain.base.RegisterRequest;
import ua.springboot.web.entity.ProductEntity;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.service.ProductService;
import ua.springboot.web.service.UserService;

@Controller
public class BaseController {
	
	@Autowired private UserService userService;
	@Autowired private ProductService productService;
	
	@GetMapping({"/", "/home"})
	public String showHome(Model model) {
	    model.addAttribute("title", "Home page");
	    return "home";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
	    	model.addAttribute("title", "Login page");
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
		
	@GetMapping("/register")
	public String showRegister(Model model) {
	    	model.addAttribute("title", "Register page");
		model.addAttribute("registerModel", new RegisterRequest());
		return "register";
	}
	
	@PostMapping("/register")
	public ModelAndView saveUser(@ModelAttribute("registerModel") @Valid RegisterRequest registerRequest, BindingResult result){
		if(result.hasErrors()) return new ModelAndView("register");
		
		try {
		    userService.saveUser(registerRequestToUserEntity(registerRequest));
		} catch (Exception e) {
		    return new ModelAndView("register", "error", "Opps.. Can't save user.");
		}
		
		return new ModelAndView("redirect:/user");
	}
	
	@GetMapping("/verify")
	public String verifyUser(
		@RequestParam("token") String token,
		@RequestParam("userid") String userIdStr,
		Model model
		){
	    
	    try {
		int userId = Integer.valueOf(userIdStr);
		UserEntity entity = userService.findUserById(userId);
		
		if(entity != null){
		    if(entity.getToken().equals(token)){
			entity.setToken("");
			entity.setIsActivated("1");
			
			userService.updateUser(entity);
		    }
		}
	    } catch (Exception e) {
		model.addAttribute("error", "Opps.. Verify error");
		return "verify/verify-error";
	    }
	    
	    return "verify/verify-success";
	}
	
	@GetMapping("/like")
	public String likeProducts(@RequestParam("id") int id, Principal principal){
	   if(principal == null) return "redirect:/login";
    	   UserEntity user = userService.findUserByEmail(principal.getName());
    	   ProductEntity product = productService.findProductById(id);
    	   
    	   user.getFavoriteProducts().add(product);
    	   
    	   userService.updateUser(user);
    	   return "redirect:/product/catalog";
	}
	
	@GetMapping("/dislike")
	public String dislikeProducts(@RequestParam("id") int id, Principal principal){
	    if(principal == null) return "redirect:/login";
	    UserEntity user = userService.findUserByEmail(principal.getName());
	    ProductEntity product = productService.findProductById(id);
	    
	    user.getFavoriteProducts().remove(product);
	    
	    userService.updateUser(user);
	    return "redirect:/product/catalog";
	}
}


