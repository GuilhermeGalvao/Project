package com.example.projectspendingcontrol.entity;

import com.example.projectspendingcontrol.enums.TypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String balance;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    public Card(){}

    public Card(Long id, String number, String balance, TypeEnum type) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.type = type;
    }

    public Card(String number, String balance, TypeEnum type) {
        this.number = number;
        this.balance = balance;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
