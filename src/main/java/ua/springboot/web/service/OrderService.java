package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.OrderEntity;
import ua.springboot.web.entity.enumeration.OrderStatus;

public interface OrderService {
    
    void saveOrder(OrderEntity entity);
    
    OrderEntity findOrderById(int id);
    
    List<OrderEntity> findAllOreders();
    
    OrderEntity findOrderByStatus(OrderStatus status, Integer id);
    
    void deleteOrderById(int id);
}
