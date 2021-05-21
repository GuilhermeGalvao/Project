package com.example.projectspendingcontrol.controller;

import com.example.projectspendingcontrol.controller.form.CardForm;
import com.example.projectspendingcontrol.dto.CardDto;
import com.example.projectspendingcontrol.entity.Card;
import com.example.projectspendingcontrol.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(cardService.getAll());
    }

    @PostMapping
    public ResponseEntity createCard(@RequestBody CardForm cardForm){
        cardService.createCard(cardForm);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity getCard(@PathVariable Long id){
        Card card = cardService.getCard(id);
        if(card != null){
            return ResponseEntity.ok().body(new CardDto().convert(card));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCard(@PathVariable Long id){
        if(cardService.deleteCard(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
