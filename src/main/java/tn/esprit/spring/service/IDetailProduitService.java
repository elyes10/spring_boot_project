package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.DetailProduit;

@Service
public interface IDetailProduitService {
	
	
   List<DetailProduit> getsAlldP() ;
	
   void saveDetailProduit(DetailProduit dp );
	
	
	DetailProduit retrieveDetailProduit(Long id);

	DetailProduit updateDetailProduit(DetailProduit dp) throws RelationNotFoundException;
	
	
	boolean deleteDetailProduitById(Long id);
	//DetailProduit getDetailProduitsByLibelleProduit(String libelle );
	DetailProduit getDetailProduitByProduit(Long idProduit);



}
