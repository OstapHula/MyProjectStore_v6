package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.QuantityProductsEntity;

@Repository
public interface QuantityRepository extends JpaRepository<QuantityProductsEntity, Integer>{
    
//    QuantityProductsEntity findQuantityByOrderId(int id);
    
}
