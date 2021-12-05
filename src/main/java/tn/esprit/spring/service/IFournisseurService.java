package tn.esprit.spring.service;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Fournisseur;

public interface IFournisseurService {
	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur f);

	boolean deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur f ) throws RelationNotFoundException;

	Fournisseur retrieveFournisseur(Long id);
	


}
