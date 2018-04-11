package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.CardEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Integer>{

}
