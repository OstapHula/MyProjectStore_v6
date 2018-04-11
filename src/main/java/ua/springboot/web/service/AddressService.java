package ua.springboot.web.service;

import ua.springboot.web.entity.AddresEntity;

public interface AddressService {
    
    void saveAddress(AddresEntity address);
    
    void deleteAdderssById(int id);
    
}
