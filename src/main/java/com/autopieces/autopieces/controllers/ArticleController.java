package com.autopieces.autopieces.controllers;

import com.autopieces.autopieces.models.Article;
import com.autopieces.autopieces.services.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
@Api(value = "onlinestore")
public class ArticleController extends HttpServlet {

    private final ArticleService _articleService;

    public ArticleController(ArticleService _articleService) {
        this._articleService = _articleService;
    }

    @ApiOperation(value = "Récupére une liste d'article")
    @GetMapping("/")
    public Iterable<Article> getAllArticles(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        this.getServletContext().getRequestDispatcher("WEB-INF/page/home.jsp").forward(req, resp);
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

    @PostMapping("/new-article")
    Article newArticle(@RequestBody Article newArticle) {
        return _articleService.addArticle(newArticle);
    }

    @ApiOperation(value = "Supprime un article via son id")
    @DeleteMapping("/delete{id}")
    public void deleteArticleById(@ApiParam("Identifiant de l'article - Ne peut être vide ") @PathVariable Long id){
         _articleService.deleteArticleById(id);
    }
}
