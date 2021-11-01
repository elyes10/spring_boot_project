package tn.esprit.spring.service;
import java.util.List;
import tn.esprit.spring.entities.Client;

public interface ClientService {
	
	List<Client> retrieveAllClients();
	Client addClient(Client c);
	String deleteClient(Long id);
	Client updateClient(Client c);
	Client retrieveClient(Long id);
	 public List<Client> addClients(List<Client> Clients);
}
