package com.ies.binding;

import lombok.Data;

@Data
public class UserAccountForm {
	private Long userId;//added externally
    private String fullName;
    private String userEmail;
    private String userPhno;
    private String userGender;
    private String userDob;
    private String userSsn;
    private Integer roleId;
}
