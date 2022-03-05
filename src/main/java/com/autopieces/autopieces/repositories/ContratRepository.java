package com.autopieces.autopieces.repositories;

import com.autopieces.autopieces.models.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContratRepository extends CrudRepository<Contrat, Long> {

}
