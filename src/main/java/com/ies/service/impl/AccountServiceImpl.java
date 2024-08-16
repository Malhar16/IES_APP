package com.ies.service.impl;

import com.ies.binding.UserAccountForm;
import com.ies.entity.UserEntity;
import com.ies.repository.UserRepo;
import com.ies.service.AccountService;
import com.ies.util.AppConstants;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity createAccount(UserAccountForm form) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(form, entity);
        entity.setAccStatus(AppConstants.ACCOUNT_LOCKED);
        return userRepo.save(entity);
    }

    @Override
    public UserEntity updateAccount(UserAccountForm form) {
        UserEntity entity = userRepo.findById(form.getUserId()).orElse(null);
        if (entity != null) {
            BeanUtils.copyProperties(form, entity);
            return userRepo.save(entity);
        }
        return null;
    }

    @Override
    public UserEntity getAccount(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public void deleteAccount(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<UserEntity> getAllAccounts() {
        return userRepo.findAll();
    }
}
