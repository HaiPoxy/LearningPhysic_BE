package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Articles;

@Repository
public interface ArticleRepository extends JpaRepository<Articles, Integer> {
    // Bạn có thể thêm các query method tùy chỉnh ở đây nếu cần
}