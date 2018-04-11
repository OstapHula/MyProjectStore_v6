package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.OrderEntity;
import ua.springboot.web.entity.enumeration.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
    
    @Query("SELECT o FROM OrderEntity o WHERE o.status = :status AND o.user.id = :id")
    OrderEntity findOrderByStatus(@Param("status") OrderStatus status, @Param("id") Integer id);
    
}
