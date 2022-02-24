package com.autopieces.autopieces.repositories;

import com.autopieces.autopieces.models.Commande;
import com.autopieces.autopieces.models.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {

    List<Commande> findCommandeByClientId(Long clientsId);

    List<Commande> findCommandeByOrderDateEquals(Date date);

    List<Commande> findCommandeByOrderDateGreaterThanEqual(Date date);

}
