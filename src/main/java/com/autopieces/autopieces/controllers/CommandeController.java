package com.autopieces.autopieces.controllers;

import com.autopieces.autopieces.models.Commande;
import com.autopieces.autopieces.services.CommandeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.autopieces.autopieces.models.Clients;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
@Api(value = "onlinestore", description = "Opération permettant de récupérer des informations sur les commandes")
public class CommandeController {

    @Autowired
    private CommandeService _commandeService;

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
    @GetMapping("/{client}")
    public List<Commande> getCommandeByClient(@ApiParam("Information du client - Ne peut être vide ") @PathVariable Clients client){
        return _commandeService.getCommandeByClient(client);
    }

    @ApiOperation(value = "Récupére une commande dont la date est égale à ")
    @GetMapping("/{date}")
    public List<Commande> getCommandWhenDateIsEqualsTo(@ApiParam("Date - Ne peut être vide ") @PathVariable Date date){
        return _commandeService.getCommandeWhenOrderDateEqualsTo(date);
    }

    @ApiOperation(value = "Récupére une commande dont la date est supérieure ou égale à ")
    @GetMapping("/{date}")
    public List<Commande> getCommandWhenDateIsGreaterOrEqualsTo(@ApiParam("Date - Ne peut être vide ") @PathVariable Date date){
        return _commandeService.getCommandeWhenOrderDateIsGreaterThan(date);
    }
}
