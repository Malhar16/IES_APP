package com.ies.service.impl;

import com.ies.binding.LoginForm;
import com.ies.binding.UnlockAccForm;
import com.ies.binding.UserAccountForm;
import com.ies.binding.DashboardCards;
import com.ies.entity.UserEntity;
import com.ies.repository.PlanRepo;
import com.ies.repository.UserRepo;
import com.ies.service.UserService;
import com.ies.util.AppConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PlanRepo planRepo;

    

    @Override
    public UserEntity login(LoginForm loginForm) {
        UserEntity user = userRepo.findByUserEmail(loginForm.getUserEmail());
        if (user != null && user.getUserPwd().equals(loginForm.getUserPwd()) && user.getAccStatus().equals(AppConstants.ACCOUNT_UNLOCKED)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean unlockAccount(UnlockAccForm unlockAccForm) {
        UserEntity user = userRepo.findByUserEmail(unlockAccForm.getEmail());
        if (user != null && user.getUserPwd().equals(unlockAccForm.getTempPwd())) {
            user.setUserPwd(unlockAccForm.getNewPwd());
            user.setAccStatus(AppConstants.ACCOUNT_UNLOCKED);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public DashboardCards getDashboardData(Long userId) {
        DashboardCards dashboard = new DashboardCards();
        // Logic to calculate totalUsers, activePlans, pendingApplications
        int totalUsers = (int) userRepo.count();

        // Logic to calculate active plans
//        int activePlans = planRepo.countByActiveSw(AppConstants.ACTIVE_STATUS);

        // Logic to calculate pending applications
//        int pendingApplications = appsRepo.countByStatus("PENDING");

        dashboard.setTotalUsers(totalUsers);
//        dashboard.setActivePlans(activePlans);
//        dashboard.setPendingApplications(pendingApplications);
        return dashboard;
    }

    @Override
    public UserEntity editProfile(UserAccountForm userForm) {
        UserEntity user = userRepo.findById(userForm.getUserId()).orElse(null);
        if (user != null) {
            BeanUtils.copyProperties(userForm, user);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public boolean forgotPassword(String email) {
        UserEntity user = userRepo.findByUserEmail(email);
        if (user != null) {
            // Logic to send a reset password link
            return true;
        }
        return false;
    }
}

