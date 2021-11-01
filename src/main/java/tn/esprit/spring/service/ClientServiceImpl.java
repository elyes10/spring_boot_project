package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	

	@Override
	public List<Client> retrieveAllClients() {
		
		return (List<Client>) clientRepository.findAll() ;
	}

	@Override
	public Client addClient(Client c) {
		
		return clientRepository.save(c) ;
	}

	@Override
	public String deleteClient(Long id) {
		clientRepository.deleteById(id); 
		return ("client deleted"+id);
	}

	@Override
	
	public Client updateClient(Client c) {
		  Client existingClient = clientRepository.findById(c.getIdClient()).orElse(null);
		  existingClient.setNom(c.getNom());
		  existingClient.setPrenom(c.getPrenom());
		  existingClient.setCategorieClient(c.getCategorieClient());
		  existingClient.setDateNaissance(c.getDateNaissance());
		  existingClient.setEmail(c.getEmail());
		  existingClient.setPassword(c.getPassword());
		  existingClient.setProfession(c.getProfession());
	        return clientRepository.save(existingClient);
	}

	@Override
	public Client retrieveClient(Long id) {
		
		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> addClients(List<Client> Clients) {
	
		return clientRepository.saveAll(Clients);
	}

}
