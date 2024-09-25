package com.vti.service;

import java.util.List;

import com.vti.entity.Articles;


public interface ArticleService {

    List<Articles> getAllArticles();
    
    Articles getArticleById(int id);
    
    Articles createArticle(Articles article);
    
    Articles updateArticle(int id, Articles article);
    
    void deleteArticle(int id);

	Articles updateArticle1(int id, Articles updatedArticle);

	Articles createArticle1(Articles article);
}