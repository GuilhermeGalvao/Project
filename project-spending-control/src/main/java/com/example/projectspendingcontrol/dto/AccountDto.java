package com.example.projectspendingcontrol.dto;

import com.example.projectspendingcontrol.entity.Account;

public class AccountDto {
    private Long id;
    private String agencia;
    private String conta;

    public AccountDto(){}


    public AccountDto(Account account) {
        this.id =  account.getId();
        this.agencia = account.getAgency();
        this.conta = account.getNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                '}';
    }

    public AccountDto convert(Account account){
        return new AccountDto(account);
    }
}
