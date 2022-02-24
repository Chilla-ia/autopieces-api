package com.autopieces.autopieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dreamTeam
 */
public class IC2Test
{
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
        fail("Not yet Implemented");
    }

    /**
     * Test method for {}
     * Method pour tester si le calcul de la marge est correct
     *  Marge correspond au bénéfice que fait l'entreprise sur l'article en fonction du user - ( prix article / 100 ) * marge
     */
    @Test
    void testCalculMarge(){
        fail("Not yet Implemented");
    }

    /**
     * Test method for {}
     * Method pour tester si le calcul du prix de la commande est correct
     *  Le prix correspond a la somme du prix de l'article , marge , tva associé  - ( marge + prix article + tva )
     */
    @Test
    void testCalculPrixTotal(){
        fail("Not yet Implemented");
    }

}