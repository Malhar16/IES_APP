package com.ies.service;

import com.ies.binding.LoginForm;
import com.ies.binding.UnlockAccForm;
import com.ies.binding.UserAccountForm;
import com.ies.binding.DashboardCards;
import com.ies.entity.UserEntity;

public interface UserService {
    UserEntity login(LoginForm loginForm);
    boolean unlockAccount(UnlockAccForm unlockAccForm);
    DashboardCards getDashboardData(Long userId);
    UserEntity editProfile(UserAccountForm userForm);
    boolean forgotPassword(String email);
}

