package com.example.projectspendingcontrol.dto;

import com.example.projectspendingcontrol.entity.Card;

public class CardDto {

    private Long id;
    private String numero;
    private String saldo;

    public CardDto(Card card){
        this.id = card.getId();
        this.numero = card.getBalance();
        this.saldo = card.getBalance();
    }

    public CardDto(Long id, String numero, String saldo) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
    }

    public CardDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public CardDto convert(Card card){
        return new CardDto(card);
    }

}
