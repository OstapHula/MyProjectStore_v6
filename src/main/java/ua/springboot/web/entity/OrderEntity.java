package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.OrderStatus;

@Entity
@Table(name = "order_entity")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity extends BaseEntity{
    
    	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<QuantityProductsEntity> quantitys = new ArrayList<>();
	
}
