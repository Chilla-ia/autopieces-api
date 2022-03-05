package com.autopieces.autopieces;

import static org.junit.jupiter.api.Assertions.*;

import com.autopieces.autopieces.models.Contrat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.autopieces.autopieces.services.ArticleService;
import com.autopieces.autopieces.services.ClientsService;
import com.autopieces.autopieces.services.ContratService;

/**
 * @author dreamTeam
 */
public class IC2Test
{
	private ArticleService articleService;
	private ClientsService clientsService;
	private ContratService contratService;

    /**
     *  Initialise les valeurs avant chaque test
     */
    @BeforeEach
    void setup() throws Exception {}

    /**
     * Test method for {}
     * Methode pour tester si le calcul de la TVA est correct
     *  TVA correspond à 20% du prix de l'article - ( prix article / 100 ) * 20
     */
    @Test
    void testCalculTVA(){
    	int articleId = 1;
    	float articlePriceHT = articleService.getArticle(articleId).get().getPrice();
    	float expectedCalcul = articlePriceHT + articlePriceHT *20 /100;
    	
    	// TODO :
    	float getCalculFromFrontend = (float) 668.28;

    	assertEquals(getCalculFromFrontend, expectedCalcul,"Calcul de TVA non conforme !");
    }

    /**
     * Test method for {}
     * Method pour tester si le calcul de la marge est correct
     *  Marge correspond au bénéfice que fait l'entreprise sur l'article en fonction du user - ( prix article / 100 ) * marge
     */
    @Test
    void testCalculMarge(){
    	int userId = 1;
    	long getIdContrat = clientsService.getClient(userId).get().getContrat().getIdContrat();
    	int getMargeFromContrat = contratService.getContrat(getIdContrat).get().getMarge();
    	
    	int articleId = 1;
    	float articlePriceHT = articleService.getArticle(articleId).get().getPrice();
    	float articlePrice = articlePriceHT + articlePriceHT *20 /100;
    	float expectedCalcul = articlePrice *getMargeFromContrat /100;
    	
    	// TODO :
    	float getCalculFromFrontend = (float) 668.28 *getMargeFromContrat /100 ;

    	assertEquals(getCalculFromFrontend, expectedCalcul,"Calcul de Marge non conforme !");
    }

    /**
     * Test method for {}
     * Method pour tester si le calcul du prix de la commande est correct
     *  Le prix correspond a la somme du prix de l'article , marge , tva associé  - ( marge + prix article + tva )
     */
    @Test
    void testCalculPrixTotal(){
    	long userId = 1;
    	long getIdContrat = clientsService.getClient(userId).get().getIdContrat();
    	int getMargeFromContrat = contratService.getContrat(getIdContrat).get().getMarge();
    	
    	long articleId = 1;
    	float articlePriceHT = articleService.getArticle(articleId).get().getPrice();
    	float articlePrice = articlePriceHT + articlePriceHT *20 /100;
    	float expectedTotalPriceCalculatedWithMargin = articlePrice + articlePrice *getMargeFromContrat /100;
    	
    	// TODO :
    	float getTotalPriceCalculatedWithMarginFromFrontend = (float) 0 ;

    	assertEquals(getTotalPriceCalculatedWithMarginFromFrontend, expectedTotalPriceCalculatedWithMargin,"Calcul du prix total non conforme !");
    }

}