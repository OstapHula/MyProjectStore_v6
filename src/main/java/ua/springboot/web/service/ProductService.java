package ua.springboot.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.springboot.web.domain.ProductNameFilter;
import ua.springboot.web.entity.ProductEntity;

public interface ProductService {
    
    void saveProduct(ProductEntity entity);
    
    void delProductById(int id);
    
    ProductEntity findProductById(int id);
    
//    ProductEntity findProductByName(String name);
//    
//    ProductEntity findProductByPrice(BigDecimal price);
    
    List<ProductEntity> findAllProducts();
    
    Page<ProductEntity> findAllProductsByPage(Pageable pageable);
    
    Page<ProductEntity> findProductByName(Pageable pageable,ProductNameFilter filter);
    
}
