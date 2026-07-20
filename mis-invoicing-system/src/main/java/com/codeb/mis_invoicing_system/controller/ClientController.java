package com.codeb.mis_invoicing_system.controller;


import com.codeb.mis_invoicing_system.entity.Client;
import com.codeb.mis_invoicing_system.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.* ;

 import java.util.List ;

@RestController
@RequestMapping("/api/clients")

public class ClientController {

@Autowired
private ClientRepository clientRepository ;

//  1 . Add new client
    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    // 2 . To See All Clients
    @GetMapping
    public List<Client> getAllclients(){
        return clientRepository.findAll();
    }

    // 3 . To See Specific Client(id)
@GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id ){
        return clientRepository.findById(id).orElse(null);
}

// 4 . client update
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id , @RequestBody Client updatedClient){
        updatedClient.setId(id);
        return clientRepository.save(updatedClient);
    }


    // Delete Client
    @DeleteMapping ("/{id}")
    public String deleteClient(@PathVariable Long id ){
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return  "Client with ID " + id + " deleted succesfully ! ";
        }
        return "Client not founded ! ";
    }




}
