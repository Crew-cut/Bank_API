package controller;

import domain.BankAccount;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repositories.BankAccountRepository;
import repositories.UserRepo;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/reg")
    public String home (Map<String,Object> model){
        return "home";
    }
    @PostMapping("/reg")
    public String addBankAccount(@RequestParam User user, Map <String, Object> model){
        User userByName = userRepo.findByName(user.getName());
        if (userByName != null){
            model.put("message","User exists");
            return "reg";
        }
        userRepo.save(user);
        return "redirect:/login";
    }

}
