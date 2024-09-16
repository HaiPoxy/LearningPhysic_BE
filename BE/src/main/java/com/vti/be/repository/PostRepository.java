package com.vti.be.repository;

import com.vti.be.entity.Post;
import com.vti.be.entity.Post.postStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    // Find all posts sorted by number of likes in descending order
    @Query("SELECT p FROM Post p ORDER BY p.numberLike DESC")
    Page<Post> findAllByOrderByNumberLikeDesc(Pageable pageable);

    // Find posts by status
    @Query("SELECT p FROM Post p WHERE p.status = :status")
    Page<Post> findByStatus(@Param("status") postStatus status, Pageable pageable);

    // Find posts by account ID
    @Query("SELECT p FROM Post p WHERE p.account.id = :accountId")
    Page<Post> findByAccountId(@Param("accountId") Integer accountId, Pageable pageable);

    // Find posts by favorite posts account ID
    @Query("SELECT p FROM Post p JOIN p.favoritePosts fp WHERE fp.account.id = :accountId")
    Page<Post> findByFavoritePostsAccountId(@Param("accountId") Integer accountId, Pageable pageable);
}
