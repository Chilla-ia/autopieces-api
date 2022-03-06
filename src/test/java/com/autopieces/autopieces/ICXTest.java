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

public class ICXTest
{
	private ArticleService articleService;
	private ClientsService clientsService;
	private ContratService contratService;

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
				Arguments.of(1,10),
				Arguments.of(2,20),
				Arguments.of(3,30)
		);
	}

	@MethodSource("chargerLesContrats")
	void testCalculPrixParContrat(long contratId, long prixAttendu){
		// TODO :
	}

}