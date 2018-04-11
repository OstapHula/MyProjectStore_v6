package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.AddresEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddresEntity, Integer>{

}
