package com.autopieces.autopieces.repositories;

import com.autopieces.autopieces.models.Article;
import com.autopieces.autopieces.models.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findArticleByIdArticle(final Long id);

    List<Article> findAll();

    List<Article> findByPriceGreaterThanEqual(float price);

}
