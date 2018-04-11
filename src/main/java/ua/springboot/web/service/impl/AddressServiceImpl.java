package ua.springboot.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.AddresEntity;
import ua.springboot.web.repository.AddressRepository;
import ua.springboot.web.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
    
    @Autowired private AddressRepository addressRepository;
    
    @Override
    public void saveAddress(AddresEntity address) {
	addressRepository.save(address);
    }

    @Override
    public void deleteAdderssById(int id) {
	addressRepository.delete(id);
    }
    
}
