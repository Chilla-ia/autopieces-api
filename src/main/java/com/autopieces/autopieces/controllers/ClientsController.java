package com.autopieces.autopieces.controllers;

import com.autopieces.autopieces.models.Clients;
import com.autopieces.autopieces.services.ClientsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiParam;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
@Api(value = "onlinestore", description = "Opération permettant de récupérer des informations sur les clients")
public class ClientsController {

    @Autowired
    private ClientsService _clientsService;

    @ApiOperation(value = "Récupére une liste de client")
    @GetMapping("/")
    public Iterable<Clients> getAllClients(){
        return _clientsService.getAllClients();
    }

    @ApiOperation(value = "Récupére un client via son id")
    @GetMapping("/{id}")
    public Optional<Clients> getClientById(@ApiParam("Identifiant du client - Ne peut être vide ") @PathVariable Long id){
        return _clientsService.getClient(id);
    }

    @PostMapping("/new-client")
    Clients newClient(@RequestBody Clients newClient) {
        return _clientsService.addClient(newClient);
    }

    @ApiOperation(value = "Supprime un client via son id")
    @DeleteMapping("/delete{id}")
    public void deleteClientById(@ApiParam("Identifiant du client - Ne peut être vide ") @PathVariable Long id){
        _clientsService.deleteClientById(id);
    }
}
