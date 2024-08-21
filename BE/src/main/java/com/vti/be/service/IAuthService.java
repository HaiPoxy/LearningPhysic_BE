package com.vti.be.service;

import com.vti.be.form.AuthRegisterForm;
import com.vti.be.form.ChangePasswordForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IAuthService {
    void create(AuthRegisterForm form);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
     void resetPassword(ChangePasswordForm form);
     ResponseEntity<String> sendToEmail(String email);
}
