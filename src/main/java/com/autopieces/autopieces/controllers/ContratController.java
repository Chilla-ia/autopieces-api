package com.autopieces.autopieces.controllers;

import com.autopieces.autopieces.models.Contrat;
import com.autopieces.autopieces.services.ContratService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RestController
@RequestMapping("/contrat")
@Api(value = "onlinestore")
public class ContratController {

    private final ContratService _contratService;

    public ContratController(ContratService _contratService) {
        this._contratService = _contratService;
    }

    @ApiOperation(value = "Récupére une liste de contrat")
    @GetMapping("/")
    public Iterable<Contrat> getAllContrats(){
        return _contratService.getAllContrats();
    }

    @ApiOperation(value = "Récupére un contrat via son id")
    @GetMapping("/{id}")
    public Optional<Contrat> getContratById(@ApiParam("Identifiant du contrat - Ne peut être vide ") @PathVariable long id){
        return _contratService.getContrat(id);
    }
}
