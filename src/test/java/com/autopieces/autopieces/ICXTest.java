package com.autopieces.autopieces;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.autopieces.autopieces.services.ArticleService;
import com.autopieces.autopieces.services.ClientsService;
import com.autopieces.autopieces.services.ContratService;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ICXTest
{
	private ArticleService articleService;
	private ClientsService clientsService;
	private ContratService contratService;

	@BeforeEach
	void setup() throws Exception {}

	static Stream<Arguments> chargerLesClients() throws Throwable 
    {
        return Stream.of(
            Arguments.of(1),
            Arguments.of(2),
            Arguments.of(3)
        );
    }
	
	@MethodSource("chargerLesClients")
	void testCalculPrixTotal(long userId){
    	//long userId = 1;
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

	static Stream<Arguments> chargerLesContrats() throws Throwable
	{
		return Stream.of(
				Arguments.of(1,13,26.145),
				Arguments.of(2,13,27.39),
				Arguments.of(3,13,28.635),
				Arguments.of(4,13,29.88),
				Arguments.of(5,13,31.125)
		);
	}

	@MethodSource("chargerLesContrats")
	void testCalculPrixParContrat(long contratId, long articleId, Float prixAttenduHT){
		// TODO :
		int margeContrat = contratService.getContrat(contratId).get().getMarge();
		Float articlePrice = articleService.getArticle(articleId).get().getPrice();

		Float calculatedPriceWithContrat = articlePrice + articlePrice * margeContrat / 100;
		assertEquals(calculatedPriceWithContrat,prixAttenduHT,"Le prix attendu par rapport au contrat n'est pas bon !");
	}

}