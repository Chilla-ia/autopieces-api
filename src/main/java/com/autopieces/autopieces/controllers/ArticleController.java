package com.autopieces.autopieces.controllers;

import com.autopieces.autopieces.models.Article;
import com.autopieces.autopieces.services.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
@Api(value = "onlinestore", description = "Opération permettant de récupérer des informations sur les articles")
public class ArticleController {

    @Autowired
    private ArticleService _articleService;

    @ApiOperation(value = "Récupére une liste d'article")
    @GetMapping("/")
    public Iterable<Article> getAllArticles(){
        return _articleService.getAllArticles();
    }

    @ApiOperation(value = "Récupére un article via son id")
    @GetMapping("/{id}")
    public Optional<Article> getArticleById(@ApiParam("Identifiant de l'article - Ne peut être vide ") @PathVariable Long id){
        return _articleService.getArticle(id);
    }

    @ApiOperation(value = "Récupére un article dont le prix est supérieur à ")
    @GetMapping("/{price}")
    public List<Article> getArticleWithPriceGreaterThan(@ApiParam("Prix de l'article - Ne peut être vide ") @PathVariable Float price){
        return _articleService.getArticleWithPriceGreaterThan(price);
    }
}
