package com.ies.binding;

import lombok.Data;

@Data
public class UnlockAccForm {
    private String email;
    private String tempPwd;
    private String newPwd;
    private String confirmPwd;
}
