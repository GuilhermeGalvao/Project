package com.example.projectspendingcontrol.controller;

import com.example.projectspendingcontrol.controller.form.AccountForm;
import com.example.projectspendingcontrol.dto.AccountDto;
import com.example.projectspendingcontrol.entity.Account;
import com.example.projectspendingcontrol.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(accountService.getAll());
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody AccountForm accountForm){
        accountService.createAccount(accountForm);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity getAccount(@PathVariable Long id){
        Account account = accountService.getAccount(id);
        if(account != null){
            return ResponseEntity.ok().body(new AccountDto().convert(account));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id){
        if(accountService.deleteAccount(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


}
