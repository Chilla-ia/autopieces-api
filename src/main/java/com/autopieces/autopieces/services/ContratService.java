package com.autopieces.autopieces.services;

import com.autopieces.autopieces.models.Contrat;
import lombok.Data;
import com.autopieces.autopieces.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
@Component
public class ContratService {

    @Autowired
    private ContratRepository _contratRepository;

    public Optional<Contrat> getContrat(final Long id) {
        return _contratRepository.findById(id);
    }

    public Iterable<Contrat> getAllContrats() {
        return _contratRepository.findAll();
    }
}
