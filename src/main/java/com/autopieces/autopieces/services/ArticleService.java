package com.autopieces.autopieces.services;

import com.autopieces.autopieces.models.Article;
import lombok.Data;
import com.autopieces.autopieces.repositories.ArticleRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
@Component
public class ArticleService {

    private final ArticleRepository _articleRepository;

    public ArticleService(ArticleRepository _articleRepository) {
        this._articleRepository = _articleRepository;
    }

    public Optional<Article> getArticle(final long id) {
        return _articleRepository.findById(id);
    }

    public Iterable<Article> getArticlesList() {
        return _articleRepository.findAll();
    }

    public List<Article> getArticleWithPriceGreaterThan(float price) {
        return _articleRepository.findByPriceGreaterThanEqual(price);
    }

    public Article addArticle(Article newArticle) {
        return _articleRepository.save(newArticle);
    }

    public void deleteArticleById(final long id){
        _articleRepository.deleteById(id);
    }
}
