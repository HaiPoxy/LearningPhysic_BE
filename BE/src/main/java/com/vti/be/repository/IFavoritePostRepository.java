package com.vti.be.repository;

import com.vti.be.entity.FavoritePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFavoritePostRepository extends JpaRepository<FavoritePost, Integer> {
}
