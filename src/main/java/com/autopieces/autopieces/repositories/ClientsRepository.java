package com.autopieces.autopieces.repositories;

import com.autopieces.autopieces.models.Article;
import com.autopieces.autopieces.models.Clients;
import com.autopieces.autopieces.models.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepository extends CrudRepository<Clients, Long> {

    List<Clients> findClientsByIdClients(final Long id);

    List<Clients> findAll();
}
