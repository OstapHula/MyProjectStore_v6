package ua.springboot.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.CardEntity;
import ua.springboot.web.repository.CardRepository;
import ua.springboot.web.service.CardService;

@Service
public class CardServiceImpl implements CardService {

    @Autowired private CardRepository cardRepository;
    
    @Override
    public void saveCard(CardEntity card) {
	cardRepository.save(card);
    }

    @Override
    public void deleteCardById(int id) {
	cardRepository.delete(id);
    }

}
