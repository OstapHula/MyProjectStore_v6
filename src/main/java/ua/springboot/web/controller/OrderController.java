package ua.springboot.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.springboot.web.entity.OrderEntity;
import ua.springboot.web.entity.ProductEntity;
import ua.springboot.web.entity.QuantityEntity;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.entity.enumeration.OrderStatus;
import ua.springboot.web.service.OrderService;
import ua.springboot.web.service.ProductService;
import ua.springboot.web.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/add-to-cart")
    public String addToCartProduct(@RequestParam("id") int id, Principal principal) {
	UserEntity user = userService.findUserByEmail(principal.getName());
	ProductEntity product = productService.findProductById(id);
	OrderEntity order = new OrderEntity();
	
	if (!user.getOrders().isEmpty()) {
	    for (OrderEntity cart : user.getOrders()) {
		if (cart.getStatus() == OrderStatus.CART) {
		    order = cart;
		}
	    }
	}else{
	    order.setStatus(OrderStatus.CART);
	    order.setUser(user);
	}
	
	QuantityEntity quantity = new QuantityEntity();
	quantity.setCount(1);
//	quantity.getProducts().add(product);
	order.getQuantitys().add(quantity);

	// user.getOrders().add(order);
	// user.getProducts().add(product);
	// product.getOrders().add(order);
	// product.getUsers().add(user);

	// userService.updateUser(user);
	// productService.saveProduct(product);
	orderService.saveOrder(order);
	return "redirect:/product/product/" + id;
    }

    @GetMapping("/orders")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showAllOrders(Model model) {
	model.addAttribute("title", "List orders page");
	model.addAttribute("listOrders", orderService.findAllOreders());
	return "order/orders";
    }

}
