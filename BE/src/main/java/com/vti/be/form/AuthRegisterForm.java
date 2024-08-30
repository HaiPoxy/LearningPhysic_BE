package com.vti.be.form;

import com.vti.be.entity.Account;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthRegisterForm {
    private String email;
    private String fullName;
    private String password;
    private Account.Role role;
}
