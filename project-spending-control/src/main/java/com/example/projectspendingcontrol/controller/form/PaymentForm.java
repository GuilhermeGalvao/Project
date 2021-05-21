package com.example.projectspendingcontrol.controller.form;

import com.example.projectspendingcontrol.enums.TypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class PaymentForm {

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private Double value_payment;
    private TypeEnum type;
    private Long card_id;
    private Long account_id;
    private int plots;

    public PaymentForm() {
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

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }

    public int getPlots() {
        return plots;
    }

    public void setPlots(int plots) {
        this.plots = plots;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
}
