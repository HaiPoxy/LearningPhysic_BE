package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column
    private String email ;

    @Column
    private String password ;

    @Column
    private Role role ;

    public enum Role {
        ADMIN,
        MANAGER,
        USER
    }
    @Column
    private String status;
}
