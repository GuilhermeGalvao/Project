package com.example.projectspendingcontrol.service;

import com.example.projectspendingcontrol.controller.form.UserForm;
import com.example.projectspendingcontrol.dto.UserDto;
import com.example.projectspendingcontrol.entity.Account;
import com.example.projectspendingcontrol.entity.Perfil;
import com.example.projectspendingcontrol.entity.User;
import com.example.projectspendingcontrol.repository.PerfilRepo;
import com.example.projectspendingcontrol.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PerfilRepo perfilRepo;

    @Autowired
    private AccountService accountService;




    public List<UserDto> listAllUsers(){
        List<UserDto> userDtos = userRepo.findAll().stream().map(UserDto::new).collect(Collectors.toList());
        return userDtos ;
    }

    public UserDto createUser(UserForm userForm) throws NoSuchAlgorithmException {
        Perfil perfil = perfilRepo.findByName(userForm.getRole());
        User user = new User(userForm.getName(), userForm.getCpf(), userForm.getPhone(), userForm.getEmail());

        user.setPassword(BCrypt.hashpw(userForm.getPassword(), BCrypt.gensalt()));
        List<Perfil> perfils = new ArrayList<>();
        perfils.add(perfil);
        user.setPerfis(perfils);
        userRepo.saveAndFlush(user);
        return new UserDto(user);
    }

    public User getUser(String id) {
        return userRepo.findById(id).get();
    }

    public boolean deleteUser(String id) {
        try{
            userRepo.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    public void addAccountToUser(String id_user, Long id_account){
        User user = userRepo.findById(id_user).get();
        if(user != null){
            Account account = new Account();
            account = accountService.getAccount(id_account);
            List<Account> accounts = user.getAccount();
            accounts.add(account);
            user.setAccount(accounts);
            userRepo.saveAndFlush(user);
        }

    }

}
