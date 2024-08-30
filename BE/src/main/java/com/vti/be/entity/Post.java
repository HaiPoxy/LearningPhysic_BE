package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String title ;

    private String content ;

    private int numberLike ;

    private int grade ;

    private postStatus status ;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account ;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();


    @CreationTimestamp
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    private LocalDateTime updatedAt ;

    public enum postStatus {
        ACTIVE,
        DENIED,
        HIDE
    }

    @OneToMany(mappedBy = "post")
    private List<FavoritePost> favoritePosts;
}
