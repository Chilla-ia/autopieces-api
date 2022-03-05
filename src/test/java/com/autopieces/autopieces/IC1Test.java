package com.autopieces.autopieces;

import static org.junit.jupiter.api.Assertions.*;

import com.autopieces.autopieces.services.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dreamTeam
 */
public class IC1Test
{
    private ArticleService _articleService;

    float embrayage;
    /**
     *  Initialise les valeurs avant chaque test
     */
    @BeforeEach
    void setup() throws Exception {
        embrayage = (float) 556.9;
    }

    /**
     * Test method for {}
     * Methode pour tester si les prix des articles affiché corresponde bien a ceux en BDD
     *  récupére le prix d'un article du front et le compare au prix de l'article asocié en BDD
     */
    @Test
    void testCoherencePrice()
    {
        long embrayageId = 1;
        float expectedEmbrayagePrice = _articleService.getArticle(embrayageId).get().getPrice();
        assertEquals(expectedEmbrayagePrice, embrayage,"Le prix de l'article est erronée !");
    }
}
