package ua.springboot.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.OrderEntity;
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

}
