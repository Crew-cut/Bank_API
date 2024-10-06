package com.bank.controller;

import com.bank.domain.TransactionHistory;
import com.bank.repositories.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.*;

import java.util.List;
import java.util.Map;

@Controller
public class TransactionController {
    @Autowired
    private TransactionHistoryRepository transactionHistory;

    @GetMapping ("transaction")
    public String transaction (Map<String, Object> model){
        return "transaction";
    }

    @PostMapping ("transaction")
    public  String addTransaction (@RequestParam String history, @RequestParam String userName, Map<String, Object> model){
        transactionHistory.save(new TransactionHistory(history,userName));

        return "transaction";
    }

}
