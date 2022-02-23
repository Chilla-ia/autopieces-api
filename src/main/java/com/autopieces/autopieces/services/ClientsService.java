package com.autopieces.autopieces.services;

import com.autopieces.autopieces.models.Clients;
import com.autopieces.autopieces.repositories.ClientsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@Component
public class ClientsService {

    @Autowired
    private ClientsRepository _clientsRepository;

    public Optional<Clients> getClient(final Long id) {
        return _clientsRepository.findById(id);
    }

    public Iterable<Clients> getAllClients() {
        return _clientsRepository.findAll();
    }


}
