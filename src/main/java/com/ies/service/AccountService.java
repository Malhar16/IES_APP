package com.ies.service;

import com.ies.binding.UserAccountForm;
import com.ies.entity.UserEntity;

import java.util.List;

public interface AccountService {
    UserEntity createAccount(UserAccountForm form);
    UserEntity updateAccount(UserAccountForm form);
    UserEntity getAccount(Long userId);
    void deleteAccount(Long userId);
    List<UserEntity> getAllAccounts();
}
