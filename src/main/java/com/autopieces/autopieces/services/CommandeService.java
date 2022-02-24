package com.autopieces.autopieces.services;

import com.autopieces.autopieces.models.Clients;
import com.autopieces.autopieces.models.Commande;
import lombok.Data;
import com.autopieces.autopieces.repositories.CommandeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Data
@Service
@Component
public class CommandeService {

    private final CommandeRepository _commandeRepository;

    public CommandeService(CommandeRepository _commandeRepository) {
        this._commandeRepository = _commandeRepository;
    }

    public Optional<Commande> getCommande(final Long id) {
        return _commandeRepository.findById(id);
    }

    public Iterable<Commande> getAllCommandes() {
        return _commandeRepository.findAll();
    }

    public List<Commande> getCommandeByClientId(Long clientsId) {
        return _commandeRepository.findCommandeByClientId(clientsId);
    }

    public List<Commande> getCommandeWhenOrderDateEqualsTo(Date date) {
        return _commandeRepository.findCommandeByOrderDateEquals(date);
    }

    public List<Commande> getCommandeWhenOrderDateIsGreaterThan (Date date) {
        return _commandeRepository.findCommandeByOrderDateGreaterThanEqual(date);
    }
}
