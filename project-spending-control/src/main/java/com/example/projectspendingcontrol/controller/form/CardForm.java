package com.example.projectspendingcontrol.controller.form;

import com.example.projectspendingcontrol.enums.TypeEnum;

public class CardForm {

    private Long card_id;
    private String number;
    private String balance;
    private TypeEnum type;
    private Long id_account;

    public CardForm() {
    }

    public CardForm(Long card_id, String number, String balance, TypeEnum type, Long id_account) {
        this.card_id = card_id;
        this.number = number;
        this.balance = balance;
        this.type = type;
        this.id_account = id_account;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Long getId_account() {
        return id_account;
    }

    public void setId_account(Long id_account) {
        this.id_account = id_account;
    }

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }
}
