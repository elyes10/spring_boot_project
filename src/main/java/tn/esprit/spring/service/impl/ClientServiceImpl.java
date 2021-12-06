package tn.esprit.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.service.ClientService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		  if(c.getNom()!=null){
		  existingClient.setNom(c.getNom());}
		  if(c.getPrenom()!=null){
		  existingClient.setPrenom(c.getPrenom());}
		  if(c.getCategorieClient()!=null){
		  existingClient.setCategorieClient(c.getCategorieClient());}
		  if(c.getDateNaissance()!=null){
		  existingClient.setDateNaissance(c.getDateNaissance());}
		  if(c.getEmail()!=null){
		  existingClient.setEmail(c.getEmail());}
		  if(c.getPassword()!=null){
		  existingClient.setPassword(c.getPassword());}
		  if(c.getProfession()!=null){
		  existingClient.setProfession(c.getProfession());}
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
	public List<Client> FindAllClientsByCategorie(CategorieClient categorieClient) {
	
		return clientRepository.findByCategorieClient(categorieClient);
	}
	
	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
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

	@Override
	public float pourcentageCategorieClient(CategorieClient categ) {
		int allclients=retrieveAllClients().size();
		int clientsbycateg=FindAllClientsByCategorie(categ).size();
		float pourcentage=((float)clientsbycateg/allclients)*100;
		return pourcentage;
	}

	

}
