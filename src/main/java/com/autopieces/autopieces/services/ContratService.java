package com.autopieces.autopieces.services;

import com.autopieces.autopieces.models.Contrat;
import lombok.Data;
import com.autopieces.autopieces.repositories.ContratRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@Component
public class ContratService {

    private final ContratRepository _contratRepository;

    public ContratService(ContratRepository _contratRepository) {
        this._contratRepository = _contratRepository;
    }

    public Optional<Contrat> getContrat(final Long id) {
        return _contratRepository.findById(id);
    }

    public Iterable<Contrat> getAllContrats() {
        return _contratRepository.findAll();
    }
}
