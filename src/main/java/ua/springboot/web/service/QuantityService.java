package ua.springboot.web.service;

import ua.springboot.web.entity.QuantityProductsEntity;

public interface QuantityService {
    
    void saveQuantity(QuantityProductsEntity quantity);
    
    void deleteQuantityById(int id);
    
}
