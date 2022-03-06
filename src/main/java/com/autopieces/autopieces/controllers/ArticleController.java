package com.autopieces.autopieces.controllers;

import com.autopieces.autopieces.models.Article;
import com.autopieces.autopieces.services.ArticleService;
import com.autopieces.autopieces.services.ClientsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@Api(value = "onlinestore")
public class ArticleController extends HttpServlet {

    private final ArticleService _articleService;

    private final ClientsService _clientsService;

    public ArticleController(ArticleService _articleService, ClientsService _clientsService) {
        this._articleService = _articleService;
        this._clientsService = _clientsService;

    }

/////
/*@GetMapping(path="/")
public String accueillir() {
    return "login";
}

    @PostMapping(path = "/")
    public String traiterFormulaireCreation(HttpServletRequest req, HttpServletResponse resp, Model model) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Clients client = _clientsService.postClientIdentifiers(username, password);
            List<Product> listProducts = ProductService.getListProducts(client.getContract());
            model.addAttribute("listProducts", listProducts);
        } catch (Exception e) {
            System.out.println("ATTENTION!!!!ERREURS");
            e.printStackTrace();
        }


        return "listProducts";
    }*/
    /////
    @GetMapping("/index")
    @ModelAttribute
    public String articlesList(Model model)
    {
        model.addAttribute("articles", _articleService.getArticlesList());

        return "index";
    }

    @ApiOperation(value = "Récupére une liste d'article")
    @GetMapping("/articles")
    public Iterable<Article> getAllArticles() {return _articleService.getArticlesList();}

    @ApiOperation(value = "Récupére un article via son id")
    @GetMapping("/{id}")
    public Optional<Article> getArticleById(@ApiParam("Identifiant de l'article - Ne peut être vide ") @PathVariable Long id){
        return _articleService.getArticle(id);
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
