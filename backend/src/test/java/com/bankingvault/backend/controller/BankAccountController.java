package com.bankingvault.backend.controller;

import com.bankingvault.backend.model.BankAccount;
import com.bankingvault.backend.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<BankAccount> getAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<BankAccount> getById(@PathVariable Long id) {
        return bankAccountService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public BankAccount create(@RequestBody BankAccount account) {
        return bankAccountService.save(account);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<BankAccount> update(@PathVariable Long id, @RequestBody BankAccount account) {
        return bankAccountService.findById(id)
                .map(existing -> {
                    account.setId(id); // ensure ID stays same
                    return ResponseEntity.ok(bankAccountService.save(account));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return bankAccountService.findById(id)
                .map(existing -> {
                    bankAccountService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
