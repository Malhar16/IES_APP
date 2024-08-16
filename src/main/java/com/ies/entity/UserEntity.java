package com.ies.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "IES_USERS")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String fullName;
    private String userEmail;
    private String userPwd;
    private String userPhno;
    private String userGender;
    private Date userDob;
    private String userSsn;
    private String activeSw;
    private String accStatus;
    private Integer roleId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    private Long createdBy;
    private Long updatedBy;

    // Getters and Setters
}
