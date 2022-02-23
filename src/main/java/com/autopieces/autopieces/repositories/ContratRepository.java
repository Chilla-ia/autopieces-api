package com.autopieces.autopieces.repositories;

import com.autopieces.autopieces.models.Article;
import com.autopieces.autopieces.models.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Long> {

    List<Contrat> findContratByIdContrat(final Long id);

    List<Contrat> findAll();
}
