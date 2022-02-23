package com.autopieces.autopieces.services;

import com.autopieces.autopieces.models.Article;
import lombok.Data;
import com.autopieces.autopieces.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
@Component
public class ArticleService {

    @Autowired
    private ArticleRepository _articleRepository;

    public Optional<Article> getArticle(final Long id) {
        return _articleRepository.findById(id);
    }

    public Iterable<Article> getAllArticles() {
        return _articleRepository.findAll();
    }

    public List<Article> getArticleWithPriceGreaterThan(float price) {
        return _articleRepository.findByPriceGreaterThanEqual(price);
    }
}
