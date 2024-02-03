package com.selvigtech.blog.service;

import com.selvigtech.blog.model.Article;
import com.selvigtech.blog.model.LocalUser;
import com.selvigtech.blog.model.dao.ArticleDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private ArticleDAO articleDAO;

    public ArticleService(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }
    public List<Article> getArticles(LocalUser user) {
        return articleDAO.findByUser(user);
    }
}
