package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Articles;
import com.vti.repository.ArticleRepository;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Articles> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Articles getArticleById(int id) {
        return articleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
    }

    @Override
    public Articles createArticle(Articles article) {
        return articleRepository.save(article);
    }

    @Override
    public Articles updateArticle1(int id, Articles updatedArticle) {
        Articles existingArticle = getArticleById(id);
        existingArticle.setTitle(updatedArticle.getTitle());
        existingArticle.setContent(updatedArticle.getContent());
        existingArticle.setImageUrl(updatedArticle.getImageUrl());
        return articleRepository.save(existingArticle);
    }

    @Override
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

	@Override
	public Articles createArticle1(Articles article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articles updateArticle(int id, Articles article) {
		// TODO Auto-generated method stub
		return null;
	}
}