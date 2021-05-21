package com.example.projectspendingcontrol.entity;


import com.example.projectspendingcontrol.enums.TypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private Double value_payment;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    private Integer plots;

    private String plots_per_total;
    @OneToOne
    private Card card;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payments payment_father;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Payments() {
    }

    public Payments(LocalDate date, Double value_payment, TypeEnum type, Card card, Integer plots, Account account) {
        this.date = date;
        this.value_payment = value_payment;
        this.type = type;
        this.card = card;
        this.plots = plots;
        this.account = account;
    }

    public Payments(LocalDate date, Double value_payment, TypeEnum type, Card card, Integer plots, String plots_per_total, Account account, Payments payments) {
        this.date = date;
        this.value_payment = value_payment;
        this.type = type;
        this.card = card;
        this.plots = plots;
        this.plots_per_total = plots_per_total;
        this.account = account;
        this.payment_father = payments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue_payment() {
        return value_payment;
    }

    public void setValue_payment(Double value_payment) {
        this.value_payment = value_payment;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getPlots_per_total() {
        return plots_per_total;
    }

    public void setPlots_per_total(String plots_per_total) {
        this.plots_per_total = plots_per_total;
    }

    public Integer getPlots() {
        return plots;
    }

    public void setPlots(Integer plots) {
        this.plots = plots;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Payments getPayment_father() {
        return payment_father;
    }

    public void setPayment_father(Payments payment_father) {
        this.payment_father = payment_father;
    }

    public Payments clone(Payments payments){
        Payments r_payments = new Payments();
        r_payments.setId(payments.getId());
        r_payments.setDate(payments.getDate());
        r_payments.setValue_payment(payments.getValue_payment());
        r_payments.setType(payments.getType());
        r_payments.setCard(payments.getCard());
        r_payments.setPlots(payments.getPlots());
        r_payments.setPlots_per_total(payments.getPlots_per_total());
        return r_payments;
    }
}
