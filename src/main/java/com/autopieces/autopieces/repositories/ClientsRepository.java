package com.autopieces.autopieces.repositories;

import com.autopieces.autopieces.models.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<Clients, long> {

}
