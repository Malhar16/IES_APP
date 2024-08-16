package com.ies.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "IES_PLANS")
@Data
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    private String planName;
    private Date planStartDate;
    private Date planEndDate;
    private String planCategory;
    private String activeSw;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private Long createdBy;
    private Long updatedBy;

    // Getters and Setters
}
