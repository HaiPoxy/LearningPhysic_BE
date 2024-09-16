package com.vti.be.specification;

import com.vti.be.entity.Post;
import com.vti.be.form.PostFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filter by grade if provided
            if (form != null  && form.getGrade() != 0) {
                predicates.add(builder.equal(root.get("grade"), form.getGrade()));
            }

            // Additional filters for case 2 (status), case 3 (accountId), case 4 (favoritePostsAccountId)
            if (form.getType() == 2) {
                predicates.add(builder.equal(root.get("status"), Post.postStatus.ACTIVE));
            }

            if (form.getType() == 3) {
                predicates.add(builder.equal(root.get("account").get("id"), form.getIdUser()));
            }

            if (form.getType() == 4) {
                predicates.add(builder.equal(root.join("favoritePosts").get("accountId"), form.getIdUser()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
