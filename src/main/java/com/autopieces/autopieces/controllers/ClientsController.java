package com.autopieces.autopieces.controllers;

import com.autopieces.autopieces.models.Clients;
import com.autopieces.autopieces.services.ClientsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiParam;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
@Api(value = "onlinestore")
public class ClientsController {

    private final ClientsService _clientsService;

    public ClientsController(ClientsService _clientsService) {
        this._clientsService = _clientsService;
    }

    @ApiOperation(value = "Récupére une liste de client")
    @GetMapping("clients")
    public Iterable<Clients> getAllClients(){
        return _clientsService.getAllClients();
    }

    @ApiOperation(value = "Récupére un client via son id")
    @GetMapping("/{id}")
    public Optional<Clients> getClientById(@ApiParam("Identifiant du client - Ne peut être vide ") @PathVariable long id){
        return _clientsService.getClient(id);
    }

    @PostMapping("/new-client")
    Clients newClient(@RequestBody Clients newClient) {
        return _clientsService.addClient(newClient);
    }

    @ApiOperation(value = "Supprime un client via son id")
    @DeleteMapping("/delete{id}")
    public void deleteClientById(@ApiParam("Identifiant du client - Ne peut être vide ") @PathVariable long id){
        _clientsService.deleteClientById(id);
    }
}
