package com.vti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vti.entity.Articles;
import com.vti.service.ArticleService;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Articles> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Articles getArticleById(@PathVariable int id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public Articles createArticle(@RequestBody Articles article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    public Articles updateArticle(@PathVariable int id, @RequestBody Articles article) {
        return articleService.updateArticle(id, article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable int id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}