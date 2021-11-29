package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.categorieClient;
import tn.esprit.spring.repository.ClientRepository;
@Slf4j
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
		log.info("client ajouté"+c.toString());
		return clientRepository.save(c) ;
	}

	@Override
	public String deleteClient(Long id) {
		log.info("client deleted ,ID:"+id);
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
		  log.info("client updated"+c.toString());
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

	@Override
	public List<Client> FindAllClientsByCategorie(categorieClient categorieClient) {
	
		return clientRepository.findByCategorieClient(categorieClient);
	}
	
	@Override
	public float getChiffreAffaireParCategorieClient(categorieClient categorieClient, Date startDate, Date endDate) {
	float chiffreAffaire=0.0f;
		List<Client> listeClient=FindAllClientsByCategorie(categorieClient);
	for(int i=0;i<listeClient.size();i++)
	{
		chiffreAffaire=chiffreAffaire+chiffreAffaireDuneListeFacture(clientFacturesBetweenTwoDates(listeClient.get(i), startDate, endDate));
	}	
		return 0;
	}

	@Override
	public List<Facture> clientFacturesBetweenTwoDates(Client c, Date startDate, Date endDate) {
		List<Facture> listFacture= c.getFactures();
		List<Facture> listFactureBetweenDates = new ArrayList<>();
		for(int i=0;i<listFacture.size();i++)
		{
			if (listFacture.get(i).getDateFacture().getTime() >= startDate.getTime() && listFacture.get(i).getDateFacture().getTime() <= endDate.getTime() ) {
			listFactureBetweenDates.add(listFacture.get(i));	
			}
		}
			
		
		return listFactureBetweenDates;
	}

	@Override
	public float chiffreAffaireDuneListeFacture(List<Facture> listFacture) {
		float chiffreAffaire=0.0f;
		for(int i=0;i<listFacture.size();i++)
		{
			chiffreAffaire=chiffreAffaire+(listFacture.get(i).getMontantFacture()-listFacture.get(i).getMontantRemise());
		}
		return chiffreAffaire;
	}

	

}
