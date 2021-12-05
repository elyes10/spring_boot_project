package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.IProduitRepository;

public interface IProduitService {
	
	List<Produit> findAllProduits();

	
	//public Produit addProduit(Produit produit,Long id , Long ids) ;
	
	public Produit addProduit(Produit produit) ;

	Produit retrieveProduitById(Long id);

	Produit updateProduit(Produit produit) throws RelationNotFoundException
;
	
	void deleteProduitById(Long id);
	

	
	/*public Produit deleteProduct(Long id) ;
	*/


	void assignProduitToStock(Long idProduit, Long idStock);
	
	void assignFournisseutToProduit(Long idProduit,Long idFournisseur);
	
	List<Produit> retrieveProduitsByCategorie(CategorieProduit categorieProduit);
	List<Produit> ProduitParDateCreation(Date date1,Date date2);


}

