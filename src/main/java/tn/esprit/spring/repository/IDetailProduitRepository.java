package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Produit;

public interface IDetailProduitRepository extends JpaRepository<DetailProduit,Long> {

	
	
	
	/*@Query("select dp from DetailProduit dp right join produit p where p.libelle= :lib")
	DetailProduit getDetailProduitsByLibelleProduit(@Param("lib") String libelle );*/
	
}
