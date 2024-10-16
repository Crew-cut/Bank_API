package com.bank.controller;

import com.bank.domain.BankAccount;
import com.bank.domain.Users;
import com.bank.repositories.BankAccountRepository;
import com.bank.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class RegController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("reg")
    public String accountList (Map<String, Object> model){
        List<Users> accounts = userRepo.findAll();
        model.put("accounts", accounts);
        return "reg";
    }
    @PostMapping("reg")
    public String addUser(@RequestParam String surname, @RequestParam @NonNull Integer pin, Map <String, Object> model){
        Users user;
        List<Users> users = userRepo.findBySurnameIgnoreCase(surname);
        if (users.size() != 0){
            user = users.get(0);
        }else return "userNotExist";
        bankAccountRepository.save(new BankAccount(user,pin));
        model.put("user",user);
        return "AccountCreated";
    }
}
