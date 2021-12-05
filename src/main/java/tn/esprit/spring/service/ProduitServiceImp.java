package tn.esprit.spring.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.relation.RelationNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.IDetailProduitRepository;
import tn.esprit.spring.repository.IFournisseurRepository;
import tn.esprit.spring.repository.IProduitRepository;
import tn.esprit.spring.repository.IRayonRepository;
import tn.esprit.spring.repository.IStockRepository;

@Service
public class ProduitServiceImp implements IProduitService {

	@Autowired
	IProduitRepository produitRepo;
	
	@Autowired
	IRayonRepository  rayonRepo;
	
	@Autowired
	IStockRepository stockRepo;
	
	
	@Autowired
	IDetailProduitRepository dpRepo;

	@Autowired
	IFournisseurRepository fournisseurRepo;

	@Override
	public List<Produit> findAllProduits() {
		List<Produit> produits = produitRepo.findAll();
		// System.out.println("produits affichés");
		return produits;
	}
	

	@Override
	public Produit retrieveProduitById(Long id) {
		Produit prod = produitRepo.getOne(id);
		return prod;

	}
	

	@Override
@Transactional
	public Produit updateProduit(Produit produit) throws RelationNotFoundException{
		Produit existe = this.produitRepo.findById(produit.getIdProduit()).orElseThrow(
				() -> new RelationNotFoundException("produit not found with id :" + produit.getIdProduit()));
		existe.setCode(produit.getCode());
		existe.setLibelle(produit.getLibelle());
		existe.setPrixUnitaire(produit.getPrixUnitaire());
		existe.setRayon(produit.getRayon());
		existe.setStock(produit.getStock());
		//existe.setFournisseurs(fournisseurRepo.getOne(produit.getFournisseurs().stream().findFirst().get().getIdFournisseur()));
        DetailProduit dProduit = existe.getDetailProduit();
		//dProduit.setCategorieProduit(produit.getDetailProduit().getCategorieProduit());
		Date date =new Date(System.currentTimeMillis());
		dProduit.setDateDerniereModification(date);
		existe.setDetailProduit(dProduit);

		//dProduit.setCategorieProduit(produit.getDetailProduit().getCategorieProduit());
		//dpRepo.save(dProduit);
		
		//dProduit.setProduit(produit);
		
		return this.produitRepo.save(existe);
	}
	
	
	@Override
	public void deleteProduitById(Long id) {

		Produit prd = produitRepo.getOne(id);
		dpRepo.delete(prd.getDetailProduit());
			produitRepo.delete(prd);
			
	}
	

	/*@Override
	public Produit addProduit(Produit produit,Long idr, Long ids) {
	Rayon rayon=rayonRepo.findById(idr).orElse(null);
		Stock stock=stockRepo.findById(ids).orElse(null);
		
		produit.setRayon(rayon);
		produit.setStock(stock);
		dpRepo.save(produit.getDetailProduit());
	return 	produitRepo.save(produit);
		
	}*/
	//@Transactional
	@Override
	public Produit addProduit(Produit produit) {
		Set<Fournisseur> listFournisseur = new HashSet<>();
		System.out.println(produit);
	    Rayon rayon=rayonRepo.findById(produit.getRayon().getIdRayon()).orElse(null);
		Stock stock=stockRepo.findById(produit.getStock().getIdStock()).orElse(null);
		Fournisseur f=fournisseurRepo.findById(produit.getFournisseurs().stream().findFirst().get().getIdFournisseur()).orElse(null);
		listFournisseur.add(f);
		System.out.println(f);
		produit.setRayon(rayon);
		produit.setStock(stock);
		produit.setFournisseurs(listFournisseur);
	    return 	produitRepo.save(produit);
	}
	
	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
    Produit p=	produitRepo.findById(idProduit).orElse(null);
    Stock s=stockRepo.findById(idStock).orElse(null);
    p.setStock(s);
    produitRepo.save(p);

    	          
	}


    @Override
	public List<Produit> retrieveProduitsByCategorie(CategorieProduit categorieProduit) {
		return produitRepo.getProduitsByCategorie(categorieProduit) ;
	}


	@Override
	public void assignFournisseutToProduit(Long idProduit, Long idFournisseur) {
		Produit p=produitRepo.findById(idProduit).orElse(null);
		Fournisseur f=fournisseurRepo.findById(idFournisseur).orElse(null);
		p.getFournisseurs().add(f);
	    produitRepo.save(p);
				
	}


	@Override
	public List<Produit> ProduitParDateCreation(Date date1, Date date2) {
		List<Produit>prod=produitRepo.ProduitParDateCreation(date1, date2);
		return prod;
	}


	

    


	
	


	
	
	
	

}
