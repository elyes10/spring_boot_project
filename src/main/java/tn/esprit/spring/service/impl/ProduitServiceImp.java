package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.*;
import tn.esprit.spring.service.IProduitService;

import javax.management.relation.RelationNotFoundException;
import java.util.*;

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
		// System.out.println("produits affichés");
		return produitRepo.findAll();
	}

	@Override
	public Produit retrieveProduitById(Long id) {
		return produitRepo.getById(id);

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
        DetailProduit dProduit = existe.getDetailProduit();
		Date date =new Date(System.currentTimeMillis());
		dProduit.setDateDerniereModification(date);
		existe.setDetailProduit(dProduit);
		return this.produitRepo.save(existe);
	}

	@Override
	public void deleteProduitById(Long id) {
		Produit prd = produitRepo.getById(id);
		dpRepo.delete(prd.getDetailProduit());
			produitRepo.delete(prd);
	}

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
		if (p != null) {
			p.setStock(s);
		}
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
		if (p != null) {
			p.getFournisseurs().add(f);
		}
		produitRepo.save(p);
	}

	@Override
	public List<Produit> ProduitParDateCreation(Date date1, Date date2) {
		return produitRepo.ProduitParDateCreation(date1, date2);
	}

	@Override
	@Transactional
	public Produit addRaitingProduit(Produit produit) throws RelationNotFoundException {
		Produit existe = this.produitRepo.findById(produit.getIdProduit()).orElseThrow(
				() -> new RelationNotFoundException("produit not found with id :" + produit.getIdProduit()));
		int somme = existe.getSommeRating();
		somme = somme+1;
		float rating = produit.getRating();
		float ratingb = ((rating+existe.getRating())/somme);
		existe.setRating(ratingb);
		System.out.println("produit "+somme);
		existe.setSommeRating(somme);
		return this.produitRepo.save(existe);
	}

	@Override
	public float getProductRating(Long idProduct) throws RelationNotFoundException {
		Produit produit = produitRepo.findById(idProduct).orElseThrow(
				() -> new RelationNotFoundException("produit not found with id :" + idProduct));
		return produit.getRating();
	}

	@Override
	public Map<CategorieProduit, Integer> getNbProduitByCategorie() {
		Map<CategorieProduit,Integer> nbProduitByCategories= new HashMap<>();
		Set<CategorieProduit> categories = new HashSet<>();
		dpRepo.findAll().stream().forEach(d -> categories.add(d.getCategorieProduit()));
		List<CategorieProduit> categoriesList = new ArrayList<>(categories);

		for (int i=0;i<categoriesList.size();i++) {
			int m = 0;
			m = produitRepo.getnbProduitsByCategorie(categoriesList.get(i));
			nbProduitByCategories.put(categoriesList.get(i),m);
		}
		System.out.println("ouma" +nbProduitByCategories);
		return nbProduitByCategories;
	}


}
