package com.ies.binding;

import lombok.Data;

import java.util.Date;

@Data
public class PlanForm {
	private Long planId;
    private String planName;
    private Date planStartDate;
    private Date planEndDate;
    private String planCategory;
}
