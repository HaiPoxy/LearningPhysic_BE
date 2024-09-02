package com.vti.be.repository;

import com.vti.be.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepository extends JpaRepository<Article,Integer> {
}
