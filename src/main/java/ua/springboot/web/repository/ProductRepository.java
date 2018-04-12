package ua.springboot.web.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.ProductEntity;

@Repository
public interface ProductRepository extends 
			JpaRepository<ProductEntity, Integer>,
			JpaSpecificationExecutor<ProductEntity>{
    
    @Query("SELECT p FROM ProductEntity p WHERE p.name LIKE '%:name%'")
    List<ProductEntity> findAllProductsByName(@Param("name") String name);
    
    @Query("SELECT p FROM ProductEntity p WHERE p.price = :price")
    ProductEntity findProductByPrice(@Param("price") BigDecimal price);
}
