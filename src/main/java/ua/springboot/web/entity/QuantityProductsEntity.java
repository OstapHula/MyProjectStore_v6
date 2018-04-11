package ua.springboot.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quantity")
@NoArgsConstructor
@Getter
@Setter
public class QuantityProductsEntity extends BaseEntity{
    
    	private int quantity = 1;
    
    	@ManyToOne
        @JoinColumn(name = "product_id")
        private ProductEntity product;
   
        @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
        @JoinColumn(name = "order_id")
        private OrderEntity order;
    
}