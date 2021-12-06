package tn.esprit.spring.service;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;

import java.util.Date;
import java.util.List;

public interface ClientService {
	
	List<Client> retrieveAllClients();
	Client addClient(Client c);
	String deleteClient(Long id);
	Client updateClient(Client c);
	Client retrieveClient(Long id);
	List<Client> addClients(List<Client> Clients);
	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
	List<Client> FindAllClientsByCategorie(CategorieClient categorieClient);
	List<Facture> clientFacturesBetweenTwoDates(Client c,Date startDate,Date endDate);
	float chiffreAffaireDuneListeFacture(List<Facture>listFacture);
	float pourcentageCategorieClient(CategorieClient categ);
}
