package ua.springboot.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.QuantityProductsEntity;
import ua.springboot.web.repository.QuantityRepository;
import ua.springboot.web.service.QuantityService;

@Service
public class QuantityServiceImpl implements QuantityService{
    
    @Autowired private QuantityRepository quantityRepository;
    
    @Override
    public void saveQuantity(QuantityProductsEntity quantity) {
	quantityRepository.save(quantity);
    }

    @Override
    public void deleteQuantityById(int id) {
	quantityRepository.delete(id);
    }

}
