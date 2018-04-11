package ua.springboot.web.service;

import ua.springboot.web.entity.CardEntity;

public interface CardService {
    
    void saveCard(CardEntity card);
    
    void deleteCardById(int id);
    
}
