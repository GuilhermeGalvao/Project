package com.example.projectspendingcontrol.controller;

import com.example.projectspendingcontrol.controller.form.PaymentForm;
import com.example.projectspendingcontrol.dto.ErrorDto;
import com.example.projectspendingcontrol.dto.PaymentDto;
import com.example.projectspendingcontrol.entity.Payments;
import com.example.projectspendingcontrol.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(paymentService.getAll());
    }

    @PostMapping(produces = { "application/json" })
    public ResponseEntity createPayment(@RequestBody PaymentForm paymentForm){
        PaymentDto payment = paymentService.createPayment(paymentForm);
        if(payment.getId() != null && payment.getId() > 0){
            return ResponseEntity.ok().body(payment);
        }

        return ResponseEntity.badRequest().body(new ErrorDto().convertPaymentInError(payment.getId()));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity getPayment(@PathVariable Long id){
        Payments payment = paymentService.getPayment(id);
        if(payment != null){
            return ResponseEntity.ok().body(new PaymentDto().convert(payment));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePayment(@PathVariable Long id){
        if(paymentService.deletePayment(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/{id}/{date}")
    public ResponseEntity getPaymentByDate(@PathVariable Long id, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return ResponseEntity.ok().body(paymentService.getPaymentByDate(id, date));
    }


}
