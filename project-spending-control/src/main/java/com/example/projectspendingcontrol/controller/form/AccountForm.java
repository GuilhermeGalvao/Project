package com.example.projectspendingcontrol.controller.form;

public class AccountForm {

    private String agency;
    private String number;
    private String user_id;
    private String name;



    public AccountForm( String agency, String number,  String user_id, String name) {
        this.agency = agency;
        this.number = number;
        this.user_id = user_id;
        this.name = name;
    }


    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
