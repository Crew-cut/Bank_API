package com.bank.controller;

import com.bank.domain.User;
import com.bank.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public String main (Map<String,Object> model){
        Iterable<User> users = userRepo.findAll();
        model.put("users",users);
        return "main";
    }
    @PostMapping
    public @ResponseBody String add (@RequestParam String name, @RequestParam String surname, Map<String , Object> model){
        userRepo.save(new User (name, surname));
        Iterable<User> users = userRepo.findAll();
        model.put("users",users);
        return "main";
    }
}
