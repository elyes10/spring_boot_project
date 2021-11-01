package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.service.ClientServiceImpl;

@RestController
public class ClientController {
	
	@Autowired
   ClientServiceImpl clientServiceImpl;
	
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client)
	{
		return clientServiceImpl.addClient(client);
	}

	@PostMapping("/addClients")
	public List<Client> addClients(@RequestBody List<Client> clients)
	{
		return clientServiceImpl.addClients(clients);
	}
	
	@GetMapping("/clients")
    public List<Client> findAllClients() {
        return clientServiceImpl.retrieveAllClients();
    }
	
	@GetMapping("/clientById/{id}")
    public Client findClientById(@PathVariable long id) {
        return clientServiceImpl.retrieveClient(id);
    }
	
	@PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client) {
        return clientServiceImpl.updateClient(client);
    }
	
	@DeleteMapping("/deleteClient/{id}")
    public String deleteProduct(@PathVariable long id) {
        return clientServiceImpl.deleteClient(id);
    }
	
}
