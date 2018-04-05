package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.OrderEntity;

public interface OrderService {
    
    void saveOrder(OrderEntity entity);
    
    OrderEntity findOrderById(int id);
    
    List<OrderEntity> findAllOreders();
    
}
