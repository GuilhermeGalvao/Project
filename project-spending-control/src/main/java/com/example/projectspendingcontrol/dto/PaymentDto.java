package com.example.projectspendingcontrol.dto;

import com.example.projectspendingcontrol.entity.Card;
import com.example.projectspendingcontrol.entity.Payments;
import com.example.projectspendingcontrol.enums.TypeEnum;

import java.time.LocalDate;

public class PaymentDto {

    private Long id;
    private LocalDate date;
    private TypeEnum type;
    private Long card_id;
    private Double value;
    private String plot_per_total;

    public PaymentDto() {
    }

    public PaymentDto(Long id) {
        this.id = id;
    }

    public PaymentDto(Long id, LocalDate date, TypeEnum type, Long card_id, Double value) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.card_id = card_id;
        this.value = value;
    }

    public PaymentDto(Payments payment) {
        this.id = payment.getId();;
        this.date = payment.getDate();
        this.type = payment.getType();
        this.card_id = payment.getCard().getId();
        this.value = payment.getValue_payment();
        this.plot_per_total = payment.getPlots_per_total();
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getPlot_per_total() {
        return plot_per_total;
    }

    public void setPlot_per_total(String plot_per_total) {
        this.plot_per_total = plot_per_total;
    }

    public PaymentDto convert(Payments payments){
        return new PaymentDto(payments);
    }

}
