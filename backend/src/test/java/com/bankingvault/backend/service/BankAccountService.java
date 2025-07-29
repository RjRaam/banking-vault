package com.bankingvault.backend.service;

import com.bankingvault.backend.model.BankAccount;
import com.bankingvault.backend.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> findById(Long id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount save(BankAccount account) {
        return bankAccountRepository.save(account);
    }

    public void deleteById(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
