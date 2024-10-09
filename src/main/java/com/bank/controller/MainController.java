package com.bank.controller;

import com.bank.domain.Users;
import com.bank.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public Iterable<Users> main (){
        return userRepo.findAll();
    }
    @PostMapping
    public Iterable<Users> add (@RequestParam String name, @RequestParam String surname){
        userRepo.save(new Users(name, surname));
        return userRepo.findAll();
    }

    @PostMapping ("filter")
    public List<Users> filter (@RequestParam String filter){
        List<Users> users;
        if (filter !=null && !filter.isEmpty()){
            users = userRepo.findByNameIgnoreCase(filter);
        }else{
            users = userRepo.findAll();
        }
        return users;
    }
}
