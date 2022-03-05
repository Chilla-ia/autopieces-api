package com.autopieces.autopieces.repositories;

import com.autopieces.autopieces.models.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, long> {

    List<Article> findByPriceGreaterThanEqual(float price);

}
