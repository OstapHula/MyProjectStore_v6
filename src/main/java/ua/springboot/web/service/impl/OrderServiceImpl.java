package ua.springboot.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.OrderEntity;
import ua.springboot.web.entity.enumeration.OrderStatus;
import ua.springboot.web.repository.OrderRepository;
import ua.springboot.web.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired private OrderRepository orderRepository;
    
    @Override
    public void saveOrder(OrderEntity entity) {
	orderRepository.save(entity);
    }

    @Override
    public OrderEntity findOrderById(int id) {
	return orderRepository.findOne(id);
    }

    @Override
    public List<OrderEntity> findAllOreders() {
	return orderRepository.findAll();
    }

    @Override
    public OrderEntity findOrderByStatus(OrderStatus status, Integer id) {
	return orderRepository.findOrderByStatus(status, id);
    }

    @Override
    public void deleteOrderById(int id) {
	orderRepository.delete(id);
    }

}
