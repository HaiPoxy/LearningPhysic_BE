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

    private String fullName;

    private String email ;

    private String password ;

    private Role role ;

    private String avatarLink ;

    public enum Role {
        ADMIN,
        MANAGER,
        USER
    }
    private String status;

    @OneToMany(mappedBy = "account")
    private List<Post> posts ;

    @OneToMany(mappedBy = "account")
    private List<FavoritePost> favoritePosts;

    @OneToMany(mappedBy = "account")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "account")
    private List<Order> orders ;

    @OneToMany(mappedBy = "account")
    private List<Comment> comments;

    @OneToMany(mappedBy = "account")
    private List<UserExamAttempt> userExamAttempts;

}
