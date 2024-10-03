package controller;

import domain.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repositories.BankAccountRepository;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String home (Map<String,Object> model){
        return "home";
    }
    @PostMapping("/cab")
    public String bankAccount(@RequestParam String userName, @RequestParam Integer pinCode, Map <String, Object> model){
        BankAccount bankAccount = new BankAccount(userName,pinCode);
//        BankAccountRepository.save(bankAccount);
        return "cab";
    }

}
