package com.selvigtech.blog.api.controller.article;

import com.selvigtech.blog.model.Article;
import com.selvigtech.blog.model.LocalUser;
import com.selvigtech.blog.service.ArticleService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getArticles(@AuthenticationPrincipal LocalUser user) {
        return articleService.getArticles(user);
    }
}
