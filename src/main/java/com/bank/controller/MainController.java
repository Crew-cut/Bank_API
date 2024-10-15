package com.bank.controller;

import com.bank.domain.Users;
import com.bank.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public String main (Map<String,Object> model){
        List<Users> users =  userRepo.findAll();
        model.put("users", users);
        return "main";
    }
    @PostMapping
    public String add (@RequestParam String name, @RequestParam String surname, Map<String,Object> model){
        userRepo.save(new Users(name, surname));
        List<Users> users = userRepo.findAll();
        model.put("users",users);
        return "main";
    }

    @PostMapping ("filter")
    public String filter (@RequestParam String filter,Map<String, Object> model){
        List<Users> users;
        if (filter !=null && !filter.isEmpty()){
            users = userRepo.findBySurnameIgnoreCase(filter);
        }else{
            users = userRepo.findAll();
        }
        model.put("users", users);
        return "/";
    }
}
