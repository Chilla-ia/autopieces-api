package com.autopieces.autopieces.services;

import com.autopieces.autopieces.models.Clients;
import com.autopieces.autopieces.repositories.ClientsRepository;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@Component
public class ClientsService {

    private final ClientsRepository _clientsRepository;

    public ClientsService(ClientsRepository _clientsRepository) {
        this._clientsRepository = _clientsRepository;
    }

    public Optional<Clients> getClient(final long id) {
        return _clientsRepository.findById(id);
    }

    public Iterable<Clients> getAllClients() {
        return _clientsRepository.findAll();
    }

    public Clients addClient(Clients newClient) {
        return _clientsRepository.save(newClient);
    }

    public void deleteClientById(final long id) {
        _clientsRepository.deleteById(id);
    }

}
