package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.categorieClient;
import tn.esprit.spring.service.ClientServiceImpl;

@RestController
@CrossOrigin
@Api(tags = "Client management")
public class ClientController {
	
	@Autowired
   ClientServiceImpl clientServiceImpl;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@ApiOperation(value = "Ajout Client")
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client)
	{   String pwd=client.getPassword();
	    String encryptPwd=passwordEncoder.encode(pwd);
	    client.setPassword(encryptPwd);
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
    public String deleteClient(@PathVariable long id) {
        return clientServiceImpl.deleteClient(id);
    }
	
	@GetMapping("/clientsByCategory/{category}")
    public List<Client> ClientBycategory(@PathVariable categorieClient category) {
        return clientServiceImpl.FindAllClientsByCategorie(category);
    }
	
	@GetMapping("/chiffreAffaireParCategorieClient/{categorieClient}/{startDate}/{endDate}")
	 public float ChiffreAffaireParCategorieClient(@PathVariable categorieClient categorieClient,@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date startDate,@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date endDate)
	 {
		 return clientServiceImpl.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
	 }
}
