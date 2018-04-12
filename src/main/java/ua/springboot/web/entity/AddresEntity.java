package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addres")
@NoArgsConstructor
@Getter
@Setter
public class AddresEntity extends BaseEntity{
    
    private String country;
    private String city;
    private String street;
    
    @Column(name = "house_number")
    private String houseNumber;
    
    @Column(name = "apartmen_number")
    private String apartmenNumbert;
    
    @Column(name = "postal_code")
    private int postalCode;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @OneToMany(mappedBy = "addres")
    private List<OrderEntity> orders = new ArrayList<>();
}
