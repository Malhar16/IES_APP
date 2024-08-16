package com.ies.service;

import com.ies.binding.PlanForm;
import com.ies.entity.PlanEntity;

import java.util.List;
import java.util.Optional;

public interface PlanService {
    PlanEntity createPlan(PlanForm form);
    PlanEntity updatePlan(PlanForm form);
    PlanEntity getPlan(Long planId);
    Optional<PlanEntity> deletePlan(Long planId);
    List<PlanEntity> getAllPlans();
    int countByActiveSw(String activeSw);
	Optional<PlanEntity> getPlanById(Long planId);
}
