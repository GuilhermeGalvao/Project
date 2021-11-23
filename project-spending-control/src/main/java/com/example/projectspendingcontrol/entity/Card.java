package com.example.projectspendingcontrol.entity;

import com.example.projectspendingcontrol.enums.TypeEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
