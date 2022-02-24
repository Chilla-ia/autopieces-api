package com.autopieces.autopieces.controllers;

import com.autopieces.autopieces.models.Commande;
import com.autopieces.autopieces.services.CommandeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
@Api(value = "onlinestore")
public class CommandeController {

    private final CommandeService _commandeService;

    public CommandeController(CommandeService _commandeService) {
        this._commandeService = _commandeService;
    }

    @ApiOperation(value = "Récupére une liste de commande")
    @GetMapping("/")
    public Iterable<Commande> getAllCommandes(){
        return _commandeService.getAllCommandes();
    }

    @ApiOperation(value = "Récupére une commande via son id")
    @GetMapping("/{id}")
    public Optional<Commande> getCommandeById(@ApiParam("Identifiant de la commande - Ne peut être vide ") @PathVariable Long id){
        return _commandeService.getCommande(id);
    }

    @ApiOperation(value = "Récupére une commande via un client ")
    @GetMapping("/{clientId}")
    public List<Commande> getCommandeByClientId(@ApiParam("Information du client - Ne peut être vide ") @PathVariable Long clientId){
        return _commandeService.getCommandeByClientId(clientId);
    }

    @ApiOperation(value = "Récupére une commande dont la date est supérieure ou égale à ")
    @GetMapping("/{date}")
    public List<Commande> getCommandWhenDateIsGreaterOrEqualsTo(@ApiParam("Date - Ne peut être vide ") @PathVariable Date date){
        return _commandeService.getCommandeWhenOrderDateIsGreaterThan(date);
    }
}
