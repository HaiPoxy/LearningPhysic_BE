package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String email ;

    private String password ;

    private Role role ;

    public enum Role {
        ADMIN,
        MANAGER,
        USER
    }
    private String status;

    @OneToMany(mappedBy = "account")
    private List<Post> posts ;
}
