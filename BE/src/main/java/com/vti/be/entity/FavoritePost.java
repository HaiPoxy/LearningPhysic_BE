package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FavoritePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account ;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post ;

    private String status;
}
