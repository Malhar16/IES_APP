package com.ies.service.impl;

import com.ies.binding.PlanForm;
import com.ies.entity.PlanEntity;
import com.ies.repository.PlanRepo;
import com.ies.service.PlanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepo planRepo;

    @Override
    public PlanEntity createPlan(PlanForm form) {
        PlanEntity entity = new PlanEntity();
        BeanUtils.copyProperties(form, entity);
        return planRepo.save(entity);
    }

    @Override
    public PlanEntity updatePlan(PlanForm form) {
        PlanEntity entity = planRepo.findById(form.getPlanId()).orElse(null);
        if (entity != null) {
            BeanUtils.copyProperties(form, entity);
            return planRepo.save(entity);
        }
        return null;
    }

    @Override
    public PlanEntity getPlan(Long planId) {
        return planRepo.findById(planId).orElse(null);
    }

//    @Override
//    public Optional<PlanEntity> deletePlan(Long planId) {
//        planRepo.deleteById(planId);
//		return null;
//    }
    
    @Override
    public Optional<PlanEntity> deletePlan(Long planId) {
        Optional<PlanEntity> plan = planRepo.findById(planId);
        if (plan.isPresent()) {
            planRepo.delete(plan.get());
        }
        return plan;
    }

    @Override
    public List<PlanEntity> getAllPlans() {
        return planRepo.findAll();
    }

	@Override
	public int countByActiveSw(String activeSw) {
		// TODO Auto-generated method stub
		return 0;//logic pending..
	}

	@Override
	public Optional<PlanEntity> getPlanById(Long planId) {
		 return planRepo.findById(planId);
		
	}
}

