package ua.springboot.web.controller;


import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Set;

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

import ua.springboot.web.domain.base.ChangePasswordRequest;
import ua.springboot.web.domain.user.EditUserRequest;
import ua.springboot.web.entity.OrderEntity;
import ua.springboot.web.entity.ProductEntity;
import ua.springboot.web.entity.QuantityProductsEntity;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.entity.enumeration.OrderStatus;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.OrderService;
import ua.springboot.web.service.ProductService;
import ua.springboot.web.service.QuantityService;
import ua.springboot.web.service.UserService;
import ua.springboot.web.service.utils.CustomFileUtils;

@Controller
@RequestMapping({"/user", "/admin"})
@SessionAttributes("editUserModel")
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private QuantityService quantityService;
    @Autowired
    private ProductService productService;
    
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
    public String showUserCart(Model model, Principal principal) throws IOException{
	UserEntity user = userService.findUserByEmail(principal.getName());
	OrderEntity order = new OrderEntity();
	if (!user.getOrders().isEmpty()) {
	    order = orderService.findOrderByStatus(OrderStatus.CART, user.getId());
	}
	
	for(QuantityProductsEntity entity : order.getQuantitys()) {
	  ProductEntity product = entity.getProduct();
	  product.setImagePath(CustomFileUtils.getImage("product_" + product.getId(), product.getImagePath()));
	}
	
	model.addAttribute("title", "My cart page");
	model.addAttribute("cartList", order.getQuantitys());
	return "user/cart";
    }
    
    @GetMapping("/cart/increment")
    public String incrementQuantity(@RequestParam("quantity") int quantity, @RequestParam("id") int id){
	QuantityProductsEntity qEntity = quantityService.findQuantityById(id);
	ProductEntity product = qEntity.getProduct();
	if(product.getInStock() >= 1) {
	    product.setInStock(product.getInStock() - 1);
	    qEntity.setQuantity(quantity + 1);
	}
	
	productService.saveProduct(product);
	quantityService.saveQuantity(qEntity);
	return "redirect:/user/cart";
    }
    
    @GetMapping("/cart/decrement")
    public String decrementQuantity(@RequestParam("quantity") int quantity, @RequestParam("id") int id){
	QuantityProductsEntity qEntity = quantityService.findQuantityById(id);
	ProductEntity product = qEntity.getProduct();
	if(quantity > 1){
	    product.setInStock(product.getInStock() + 1);
	    qEntity.setQuantity(quantity - 1);
	}
	
	productService.saveProduct(product);
	quantityService.saveQuantity(qEntity);
	return "redirect:/user/cart";
    }
    
    @GetMapping("/favorite")
    public String showFavorite(Model model, Principal principal) throws IOException{
	UserEntity user = userService.findUserByEmail(principal.getName());
	Set<ProductEntity> products = user.getFavoriteProducts();
	for(ProductEntity product : products){
	    product.setImagePath(CustomFileUtils.getImage("product_"  + product.getId(), product.getImagePath()));
	}
	
	model.addAttribute("title", "Favorite products page");
	model.addAttribute("productsModel", products);
	return "user/favorite";
    }
    
    @GetMapping("/delete/user")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showDelUser(@RequestParam("id") int id){
	if(id != 1) userService.deleteUserById(id);
	return "redirect:/user/users";
    }
    
    @GetMapping("/delete/quantity")
    public String showDelQuantity(@RequestParam("id") int id, Principal principal){
	quantityService.deleteQuantityById(id);
	
	UserEntity user = userService.findUserByEmail(principal.getName());
	OrderEntity order = orderService.findOrderByStatus(OrderStatus.CART, user.getId());	
	if(order.getQuantitys().isEmpty()) orderService.deleteOrderById(order.getId());

	return "redirect:/user/cart";
    }
 
}
