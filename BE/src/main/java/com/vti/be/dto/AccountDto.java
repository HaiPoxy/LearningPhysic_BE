package com.vti.be.dto;

import com.vti.be.entity.Account;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AccountDto {
    private Integer id ;

    private String email ;
    private String fullName;
    private String password ;
    private String avatarLink ;
    private String role ;

}
