package com.ies.repository;

import com.ies.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepo extends JpaRepository<PlanEntity, Long> {
}
