package tn.esprit.spring.service;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.IFournisseurRepository;

@Service
public class FournisseurServiceImpl implements IFournisseurService{
	
	@Autowired
	IFournisseurRepository founisseurRepo;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		List<Fournisseur> fournisseurs=founisseurRepo.findAll();
		return fournisseurs;
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		founisseurRepo.save(f);
		return f;
	}

	@Override
	public boolean deleteFournisseur(Long id) {
		Fournisseur f =founisseurRepo .getOne(id);

		if (f != null) {
			founisseurRepo.delete(f);
			return true;
		}
		return false;
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f)throws RelationNotFoundException {
		Fournisseur existe = this.founisseurRepo.findById(f.getIdFournisseur()).orElseThrow(
				() -> new RelationNotFoundException("produit not found with id :" + f.getIdFournisseur()));
		existe.setCode(f.getCode());
		existe.setLibelle(f.getLibelle());
		return this.founisseurRepo.save(existe);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		Fournisseur f = founisseurRepo.findById(id).orElse(null);
		return f;
	}

}
