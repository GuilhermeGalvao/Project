package com.example.projectspendingcontrol.dto;

import com.example.projectspendingcontrol.entity.User;

public class UserDto {




    private String id;
    private String name;
    private String cpf;
    private String phone;

    public UserDto(){}

    public UserDto(String id, String name, String cpf, String phone){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
    }

    public UserDto(User user) {
        this.id= user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.phone = user.getPhone();
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public UserDto convert(User user){
        return new UserDto(user.getId(), user.getName(), user.getCpf(), user.getPhone());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
