package ua.springboot.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addres")
@NoArgsConstructor
@Getter
@Setter
public class CardEntity extends BaseEntity {
    
    @Column(name = "card_number")
    private long cardNumber;
    
    @Column(name = "validity_period_mm")
    private int validityPeriodMM;
    
    @Column(name = "validity_period_yy")
    private int validityPeriodYYs;
    
    @Column(name = "security_code")
    private int securityCode;
    
    @Column(name = "cardowner_first_name")
    private String cardownerFirstName;
    
    @Column(name = "cardowner_last_name")
    private String cardownerLastName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}