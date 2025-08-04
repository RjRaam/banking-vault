package com.bankingvault.backend.controller;

import com.bankingvault.backend.model.BankAccount;
import com.bankingvault.backend.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountRepository repository;

    @GetMapping
    public List<BankAccount> listAll() {
        return repository.findAll();
    }
}

