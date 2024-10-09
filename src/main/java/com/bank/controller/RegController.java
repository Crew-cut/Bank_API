package com.bank.controller;

import com.bank.domain.BankAccount;
import com.bank.domain.Users;
import com.bank.repositories.BankAccountRepository;
import com.bank.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RegController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("reg")
    public List<BankAccount> accountList (){
        List<BankAccount> users = bankAccountRepository.findAll();
        return users;
    }
    @PostMapping("reg")
    public String addUser(@RequestParam String name, @RequestParam int pin, Map <String, Object> model){
        Users user;
        List<Users> users = userRepo.findByNameIgnoreCase(name);
        if (users.size() != 0){
            user = users.get(0);
        }else return "user Not Exist";
        bankAccountRepository.save(new BankAccount(user,pin));
        return "Account created";
    }
}
