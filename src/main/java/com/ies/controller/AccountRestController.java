package com.ies.controller;

import com.ies.binding.UserAccountForm;
import com.ies.entity.UserEntity;
import com.ies.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/save")
    public UserEntity createAccount(@RequestBody UserAccountForm form) {
        return accountService.createAccount(form);
    }

    @PutMapping("/{id}")
    public UserEntity updateAccount(@PathVariable Long id, @RequestBody UserAccountForm form) {
        form.setUserId(id);
        return accountService.updateAccount(form);
    }

    @GetMapping("/{id}")
    public UserEntity getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @GetMapping
    public List<UserEntity> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
