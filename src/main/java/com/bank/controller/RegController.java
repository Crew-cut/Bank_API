package com.bank.controller;

import com.bank.domain.BankAccount;
import com.bank.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RegController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @GetMapping("reg")
    public String home (Map<String,Object> model){

        return "reg";
    }
    @PostMapping("reg")
    public String addUser(@RequestParam String name, @RequestParam int pin, Map <String, Object> model){
        bankAccountRepository.save(new BankAccount(name,pin));
        return "redirect:/";
    }

}
