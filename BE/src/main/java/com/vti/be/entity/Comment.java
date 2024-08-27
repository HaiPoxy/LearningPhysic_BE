package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String content ;


    @ManyToOne
    @JoinColumn(name = "parent_comment_id", referencedColumnName = "id")
    private Comment commentParent;

    @OneToMany(mappedBy = "commentParent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> childComments;

    @CreationTimestamp
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    private LocalDateTime updateAt ;

    @ManyToOne
    @JoinColumn(name = "post_id" , referencedColumnName = "id")
    private Post post ;

    @PrePersist
    @PreUpdate
    private void validateParentChildRelationship() {
        if (commentParent != null && this.equals(commentParent)) {
            throw new IllegalStateException("A comment cannot be its own parent.");
        }

        if (childComments != null) {
            for (Comment childComment : childComments) {
                if (this.equals(childComment)) {
                    throw new IllegalStateException("A comment cannot be its own child.");
                }
            }
        }
    }
}
