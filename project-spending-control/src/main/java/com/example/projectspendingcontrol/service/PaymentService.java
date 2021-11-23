package com.example.projectspendingcontrol.service;

import com.example.projectspendingcontrol.controller.form.PaymentForm;
import com.example.projectspendingcontrol.dto.PaymentDto;
import com.example.projectspendingcontrol.entity.Account;
import com.example.projectspendingcontrol.entity.Payments;
import com.example.projectspendingcontrol.enums.TypeEnum;
import com.example.projectspendingcontrol.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private CardService cardService;

    public List<PaymentDto> getAll() {
        List<PaymentDto> accountDtos = paymentRepo.findAll().stream().map(PaymentDto::new).collect(Collectors.toList());
        return accountDtos ;
    }

    public PaymentDto createPayment(PaymentForm paymentForm) {
        Account account = accountService.getAccount(paymentForm.getAccount_id());
        if(account == null){
            return  new PaymentDto(-4L);
        }
        Payments payment = new Payments(paymentForm.getDate(), paymentForm.getValue_payment(), paymentForm.getType(), cardService.getCard(paymentForm.getCard_id()), paymentForm.getPlots(), account);
        if(paymentForm.getType().equals(TypeEnum.DEBIT) && paymentForm.getPlots() > 1){
            return new PaymentDto(-3L);
        }
        if(accountService.verifyCardIsFromUser(paymentForm.getCard_id(), paymentForm.getAccount_id())){
            if(cardService.cardValidation(paymentForm.getCard_id(), paymentForm.getType())) {
                double value_plots = paymentForm.getValue_payment() / paymentForm.getPlots();
                int plot = 1;
                payment.setValue_payment(value_plots);
                payment.setPlots_per_total(plot + "/" + paymentForm.getPlots());
                Payments returned_payment = new Payments();
                while(plot <= paymentForm.getPlots()){
                    payment = paymentRepo.saveAndFlush(payment);
                    accountService.addPaymentToAccount(payment, paymentForm.getAccount_id());
                    if(plot == 1)
                        returned_payment = returned_payment.clone(payment);
                    plot ++;
                    payment = new Payments(payment.getDate().plusMonths(1), value_plots, paymentForm.getType(), cardService.getCard(paymentForm.getCard_id()), paymentForm.getPlots(), plot + "/" + paymentForm.getPlots(),account, payment);

                }
                return new PaymentDto(returned_payment);
            }
            return new PaymentDto(-2L);
        }
        return new PaymentDto(-1L);
    }

    public Payments getPayment(Long id) {
        return paymentRepo.findById(id).get();
    }

    public boolean deletePayment(Long id) {
        try{
            paymentRepo.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    public List<PaymentDto> getPaymentByDate(Long id, LocalDate dateInit) {
        LocalDate dateFinal = dateInit.plusMonths(1).withDayOfMonth(1);
        List<Payments> payments = paymentRepo.findByAccountIdAndDateBetween(id, dateInit, dateFinal);

        return payments.stream().map(PaymentDto::new).collect(Collectors.toList());
    }

    public List<PaymentDto> getPaymentById(Long id) {
        List<Payments> payments = paymentRepo.findByAccountId(id);

        return payments.stream().map(PaymentDto::new).collect(Collectors.toList());
    }
}
