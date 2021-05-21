package com.example.projectspendingcontrol.controller;

import com.example.projectspendingcontrol.controller.form.UserForm;
import com.example.projectspendingcontrol.dto.UserDto;
import com.example.projectspendingcontrol.entity.User;
import com.example.projectspendingcontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> listAllUsers(){
        return ResponseEntity.ok().body(userService.listAllUsers());
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserForm userForm) throws NoSuchAlgorithmException {
        UserDto user = userService.createUser(userForm);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable String id){
        User user = userService.getUser(id);
        if(user != null){
            return ResponseEntity.ok().body(new UserDto().convert(user));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        if(userService.deleteUser(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
