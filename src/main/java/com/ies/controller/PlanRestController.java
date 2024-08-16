package com.ies.controller;

import com.ies.binding.PlanForm;
import com.ies.entity.PlanEntity;
import com.ies.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plans")
public class PlanRestController {

    @Autowired
    private PlanService planService;

//    @PostMapping("/savePlan")
//    public PlanEntity createPlan(@RequestBody PlanForm planForm) {
//        return planService.createPlan(planForm);
//    }
    @PostMapping("/createPlan")
    public ResponseEntity<String> createPlan(@RequestBody PlanForm planForm) {
        PlanEntity createdPlan = planService.createPlan(planForm);
        return ResponseEntity.ok("Plan '" + createdPlan.getPlanName() + "' has been created successfully.");
    }

//    @PutMapping("/updatePlan")
//    public PlanEntity updatePlan(@RequestBody PlanForm planForm) {
//        return planService.updatePlan(planForm);
//    }
    
    @PutMapping("/{planId}")
    public ResponseEntity<String> updatePlan( @RequestBody PlanForm planForm) {
        Optional<PlanEntity> updatedPlan = Optional.of(planService.updatePlan( planForm));
        if (updatedPlan.isPresent()) {
            return ResponseEntity.ok("Plan '" + updatedPlan.get().getPlanName() + "' has been updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/{planId}")
//    public PlanEntity getPlan(@PathVariable Long planId) {
//        return planService.getPlan(planId);
//    }
    
    @GetMapping("/{planId}")
    public ResponseEntity<?> getPlanById(@PathVariable Long planId) {
        Optional<PlanEntity> plan = planService.getPlanById(planId);
        if (plan.isPresent()) {
            return ResponseEntity.ok("Plan found: " + plan.get().getPlanName());
        } else {
            return ResponseEntity.status(404).body("Plan with ID " + planId + " not found.");
        }
    }

//    @DeleteMapping("/{planId}")
//    public void deletePlan(@PathVariable Long planId) {
//        planService.deletePlan(planId);
//    }
    
    @DeleteMapping("/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable Long planId) {
        Optional<PlanEntity> plan = planService.deletePlan(planId);
        if (plan.isPresent()) {
            return ResponseEntity.ok("Plan '" + plan.get().getPlanName() + "' has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("allPlan")
//    public List<PlanEntity> getAllPlans() {
//        return planService.getAllPlans();
//    }
    
    @GetMapping("getAllPlans")
    public ResponseEntity<?> getAllPlans() {
        List<PlanEntity> plans = planService.getAllPlans();
        if (!plans.isEmpty()) {
            return ResponseEntity.ok(plans);
        } else {
            return ResponseEntity.status(404).body("No plans available.");
        }
    }
}
