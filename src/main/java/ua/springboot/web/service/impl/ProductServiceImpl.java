package ua.springboot.web.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.springboot.web.domain.ProductNameFilter;
import ua.springboot.web.entity.ProductEntity;
import ua.springboot.web.repository.ProductRepository;
import ua.springboot.web.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public void saveProduct(ProductEntity entity) {
	productRepository.save(entity);
    }

    @Override
    public ProductEntity findProductById(int id) {
	return productRepository.findOne(id);
    }

    @Override
    public ProductEntity findProductByName(String name) {
	return productRepository.findProductByName(name);
    }

    @Override
    public ProductEntity findProductByPrice(BigDecimal price) {
	return productRepository.findProductByPrice(price);
    }
    
    @Override
    public void delProductById(int id) {
	productRepository.delete(id);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
	return productRepository.findAll();
    }

    @Override
    public Page<ProductEntity> findAllProductsByPage(Pageable pageable) {
	PageRequest request = new PageRequest(
		pageable.getPageNumber(),
		pageable.getPageSize(),
		pageable.getSort()
		);
	return productRepository.findAll(request);
    }

    @Override
    public Page<ProductEntity> findProductByName(Pageable pageable, ProductNameFilter filter) {
	return productRepository.findAll(getSpecification(filter), pageable);
    }
    
    private Specification<ProductEntity> getSpecification(ProductNameFilter filter){
	return new Specification<ProductEntity>(){

	    @Override
	    public Predicate toPredicate(Root<ProductEntity> root,
		    CriteriaQuery<?> guery, CriteriaBuilder builder) {
		if(filter.getSearch().isEmpty()) return null;
		
		return builder.like(root.get("name"), "%" + filter.getSearch() + "%");
	    }
	};
    }

}
