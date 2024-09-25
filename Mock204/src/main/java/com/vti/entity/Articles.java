package com.vti.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Articles", catalog = "Learning_Physic")
public class Articles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")  // Ánh xạ cột "article_id"
    private int articleId;

    @Column(name = "title", nullable = false, length = 255)  // Ánh xạ cột "title"
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")  // Ánh xạ cột "content"
    private String content;

    @Column(name = "image_url", length = 255)  // Ánh xạ cột "image_url"
    private String imageUrl;

    @Column(name = "created_at", updatable = false)  // Ánh xạ cột "created_at"
    private Timestamp createdAt;

    @Column(name = "updated_at")  // Ánh xạ cột "updated_at"
    private Timestamp updatedAt;

    // Constructor không tham số (bắt buộc cho JPA)
    public Articles() {
    }

    // Constructor có tham số
    public Articles(String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    // Getters và Setters

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ToString method để hiển thị thông tin Article
    @Override
    public String toString() {
        return "Articles{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

