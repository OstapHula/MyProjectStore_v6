package ua.springboot.web.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product", indexes = @Index(columnList = "name"))
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity extends BaseEntity{
	
	private String name;
	
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;
	
	@Column(name = "description", nullable = false, length = 512)
	private String description;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "in_stock")
	private int inStock;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "parameters_product_id", nullable = true)
	private ParametersProductEntity parameters;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<QuantityProductsEntity> quantitys = new ArrayList<>();
	
	@Column(name = "users_like")
	@ManyToMany
	@JoinTable(
		name = "user_product",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private Set<UserEntity> usersLike = new HashSet<>();
	
}
