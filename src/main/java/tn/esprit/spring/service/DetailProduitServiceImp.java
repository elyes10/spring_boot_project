package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;


import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.IDetailProduitRepository;


@Service
public class DetailProduitServiceImp implements IDetailProduitService {
	
	@Autowired
	IDetailProduitRepository dpRepo;

	@Override
	public void saveDetailProduit(DetailProduit dp) {

		
	if (dp.getDateCreation()==null){
		dp.setDateCreation(new Date());
		dp.setDateDerniereModification(new Date());
	}
	else{
		dp.setDateDerniereModification(new Date());
	}
	
		  dpRepo.save(dp);
		
	}
	
	

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
	return	dpRepo.findById(id).get();
		
		
	}

	@Override
	public DetailProduit updateDetailProduit(DetailProduit dp) throws RelationNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public boolean deleteDetailProduitById(Long id) {
		DetailProduit dp =dpRepo.getOne(id);	

		if(dp!=null) {
			dpRepo.delete(dp);
			return true;
		}
		return false;	}



	@Override
	public List<DetailProduit> getsAlldP() {
		
		List <DetailProduit> list = dpRepo.findAll();
		return list;
	}



	@Override
	public DetailProduit getDetailProduitByProduit(Long idProduit) {
		return null;
	}



	/*@Override
	public DetailProduit getDetailProduitsByLibelleProduit(String libelle) {
	
		return dpRepo.getDetailProduitsByLibelleProduit(libelle);
	}*/


}
