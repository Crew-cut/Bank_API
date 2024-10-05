package com.bank.controller;

import com.bank.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bank.repositories.UserRepo;

import java.util.Map;

@RestController
public class RegController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/reg")
    public String home (Map<String,Object> model){
        return "home";
    }
    @PostMapping("/reg")
    public String addUser(@RequestParam User user, Map <String, Object> model){
        User userByName = userRepo.findByName(user.getName());
        if (userByName != null){
            model.put("message","User exists");
            return "reg";
        }
        userRepo.save(user);
        return "redirect:/login";
    }

}
