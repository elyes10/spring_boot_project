package tn.esprit.spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.service.impl.ClientServiceImpl;

import java.util.Date;
import java.util.List;

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
    public List<Client> ClientBycategory(@PathVariable CategorieClient category) {
        return clientServiceImpl.FindAllClientsByCategorie(category);
    }
	
	@GetMapping("/chiffreAffaireParCategorieClient/{categorieClient}/{startDate}/{endDate}")
	 public float ChiffreAffaireParCategorieClient(@PathVariable CategorieClient categorieClient, @PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date endDate)
	 {
		 return clientServiceImpl.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
	 }
	
	@GetMapping("/clientsCategoryPourcentage/{category}")
    public float ClientcategoryPourcentage(@PathVariable CategorieClient category) {
        return clientServiceImpl.pourcentageCategorieClient(category);
    }

	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}
}
