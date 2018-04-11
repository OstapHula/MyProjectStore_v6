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
import ua.springboot.web.entity.QuantityProductsEntity;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.entity.enumeration.OrderStatus;
import ua.springboot.web.service.OrderService;
import ua.springboot.web.service.ProductService;
import ua.springboot.web.service.QuantityService;
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
    @Autowired
    private QuantityService quantityService;

    @GetMapping("/add-to-cart")
    public String addToCartProduct(@RequestParam("id") int id, Principal principal) {
	if(principal == null) return "redirect:/login";
	UserEntity user = userService.findUserByEmail(principal.getName());
	ProductEntity product = productService.findProductById(id);
	
	if(product.getInStock() > 0){
	    product.setInStock(product.getInStock() - 1);
	}
	OrderEntity order = new OrderEntity();
	QuantityProductsEntity quantity = new QuantityProductsEntity();
	
	if(!user.getOrders().isEmpty()){
	    for(OrderEntity oEntity : user.getOrders()){
		if(oEntity.getStatus().equals(OrderStatus.CART)){
		    order = oEntity;
		    for(QuantityProductsEntity qEntity : order.getQuantitys()){
			if(qEntity.getProduct().getId() == product.getId()){
                            quantity = qEntity;
                            quantity.setQuantity(quantity.getQuantity()+1);
                            break;
                        }
		    }
		    for(QuantityProductsEntity qEntity : order.getQuantitys()){
			if(qEntity.getProduct().getId() != product.getId()){
                            quantity.setProduct(product);
                            quantity.setOrder(order);
                            order.getQuantitys().add(quantity);
                            break;
                        }
		    }
		    break;
		 }
	    }
	    for(OrderEntity oEntity : user.getOrders()){
		if(!oEntity.getStatus().equals(OrderStatus.CART)){
		    quantity.setProduct(product);
		    quantity.setOrder(order);
		    order.setStatus(OrderStatus.CART);
		    order.getQuantitys().add(quantity);
		    break;
		}
	    }
	}else{
	    quantity.setProduct(product);
	    quantity.setOrder(order);
	    order.setStatus(OrderStatus.CART);
	    order.getQuantitys().add(quantity);
	    order.setUser(user);
	}	
	
	productService.saveProduct(product);
	quantityService.saveQuantity(quantity);
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
