package com.example.projectspendingcontrol.service;

import com.example.projectspendingcontrol.controller.form.AccountForm;
import com.example.projectspendingcontrol.dto.AccountDto;
import com.example.projectspendingcontrol.entity.*;
import com.example.projectspendingcontrol.repository.AccountRepo;
import com.example.projectspendingcontrol.repository.PerfilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private PerfilRepo perfilRepo;

    @Autowired
    private UserService userService;

    public List<AccountDto> getAll() {
        List<AccountDto> accountDtos = accountRepo.findAll().stream().map(AccountDto::new).collect(Collectors.toList());
        return accountDtos ;
    }

    public void createAccount(AccountForm accountForm) {
        User user = userService.getUser(accountForm.getUser_id());
        Account account = new Account(accountForm.getAgency(), accountForm.getNumber(), accountForm.getName());
        if(user != null){
            account.setUser(user);
        }
        account = accountRepo.saveAndFlush(account);

        userService.addAccountToUser(accountForm.getUser_id(), account.getId());

    }

    public Account getAccount(Long id) {
        try {
            return accountRepo.findById(id).get();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public boolean deleteAccount(Long id) {
        try{
            accountRepo.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    public void addCardToAccount(Card card, Long id_account){
        Account account = accountRepo.findById(id_account).get();
        if(account != null){
            List<Card> cards = account.getCards();
            cards.add(card);
            account.setCards(cards);
            accountRepo.saveAndFlush(account);
        }
    }

    public boolean verifyCardIsFromUser(Long id_card, Long id_account){
        Account account = accountRepo.findById(id_account).get();
        if(account != null){
            return account.getCards().stream().anyMatch(c -> c.getId().equals(id_card));
        }
        return false;
    }

    public void addPaymentToAccount(Payments payment, Long id_account){
        Account account = accountRepo.findById(id_account).get();
        if(account != null){
            List<Payments> payments = account.getPayments();
            payments.add(payment);
            account.setPayments(payments);
            accountRepo.saveAndFlush(account);
        }
    }

}
