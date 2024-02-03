package com.selvigtech.blog.model.dao;

import com.selvigtech.blog.model.Article;
import com.selvigtech.blog.model.LocalUser;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ArticleDAO extends ListCrudRepository<Article, Long> {
    List<Article> findByUser(LocalUser user);
}
