package com.example.projectspendingcontrol.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String number;
    private String agency;

    @OneToMany
    private List<Payments> payments;

    @ManyToMany
    private List<Card> cards;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account(){}
    public Account(String numero, String agency, String name) {
        this.number = numero;
        this.agency = agency;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
