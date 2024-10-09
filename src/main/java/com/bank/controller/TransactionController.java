package com.bank.controller;

import com.bank.domain.BankAccount;
import com.bank.domain.TransactionHistory;
import com.bank.domain.Users;
import com.bank.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {
    @Autowired
    private TransactionHistoryRepository transactionHistory;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private UserRepo userRepo;

    @GetMapping ("transaction")
    public String transaction (){
        return "transaction";
    }

    @PostMapping ("transaction")
    public  int transfer (@RequestParam Integer amount,
                              @RequestParam String recipient,
                              @RequestParam String sender,
                              @RequestParam Integer pinCode){
        Long senderId = getUserId (sender);
        Long recipientId = getUserId(recipient);
        long senderBalance =  getBalance(senderId);
        long recipientBalance = getBalance(recipientId);
        if (senderBalance < 0 || recipientBalance < 0) return 1;
        if (senderBalance < amount || amount <= 0) return 2;
        if (getPinCode(senderId) != pinCode) return 3;
        String history = "user " + recipient + " get from " + sender + " - " + amount + "$";
        bankAccountRepository.updateBalanceBy(recipientBalance + amount);
        transactionHistory.save(new TransactionHistory(history,recipientId,senderId));
        return 0;
    }

    private Long getUserId(String user) {
        Users idBySurname = userRepo.findFirstBySurname(user);
        return idBySurname.getId();
    }
    private long getBalance (Long userId){
        BankAccount byUserId = bankAccountRepository.findFirstByUserId(userId);
        if (byUserId !=null) {
            return byUserId.getBalance();
        }else return -1L;
    }
    private int getPinCode (Long userId){
        BankAccount pinByUserId = bankAccountRepository.findFirstByUserId(userId);
            return pinByUserId.getPinCode();
    }

}
