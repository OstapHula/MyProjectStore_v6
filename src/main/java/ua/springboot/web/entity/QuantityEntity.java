package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quantity")
@NoArgsConstructor
@Getter
@Setter
public class QuantityEntity extends BaseEntity{
    
    private int count;
    
/*    @OneToMany(mappedBy = "quantity")
    private List<ProductEntity> products = new ArrayList<>();
    */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    
}
