package com.example.projectspendingcontrol.service;

import com.example.projectspendingcontrol.controller.form.CardForm;
import com.example.projectspendingcontrol.dto.CardDto;
import com.example.projectspendingcontrol.entity.Card;
import com.example.projectspendingcontrol.enums.TypeEnum;
import com.example.projectspendingcontrol.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private AccountService accountService;

    public List<CardDto> getAll() {
        List<CardDto> accountDtos = cardRepo.findAll().stream().map(CardDto::new).collect(Collectors.toList());
        return accountDtos ;
    }

    public void createCard(CardForm cardForm) {
        Card card;
        if(cardForm.getCard_id() == null) {
            card = new Card(cardForm.getCard_id(), cardForm.getNumber(), cardForm.getBalance(), cardForm.getType());
            card = cardRepo.saveAndFlush(card);
            accountService.addCardToAccount(card, cardForm.getId_account());
            return;
        }
        card = cardRepo.findById(cardForm.getCard_id()).get();
        accountService.addCardToAccount(card, cardForm.getId_account());

    }

    public Card getCard(Long id) {
        return cardRepo.findById(id).get();
    }

    public boolean deleteCard(Long id) {
        try{
            cardRepo.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean cardValidation(Long card_id, TypeEnum type) {
        Card card = cardRepo.findById(card_id).get();
        if(card != null){
            if(card.getType().equals(type)){
                return true;
            }
        }
        return false;

    }
}
