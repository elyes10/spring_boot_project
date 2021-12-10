package tn.esprit.spring.service;

import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.Produit;

import javax.management.relation.RelationNotFoundException;
import java.util.Date;
import java.util.List;

public interface IProduitService {
	
	List<Produit> findAllProduits();

	Produit addProduit(Produit produit) ;

	Produit retrieveProduitById(Long id);

	Produit updateProduit(Produit produit) throws RelationNotFoundException;
	
	void deleteProduitById(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);
	
	void assignFournisseutToProduit(Long idProduit,Long idFournisseur);
	
	List<Produit> retrieveProduitsByCategorie(CategorieProduit categorieProduit);

	List<Produit> ProduitParDateCreation(Date date1,Date date2);

	Produit addRaitingProduit(Produit produit) throws RelationNotFoundException;

	float getProductRating(Long idProduct) throws RelationNotFoundException;
}

