package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.DetailFacture;

public interface DetailFactureRepository extends CrudRepository<DetailFacture, Long>{

/**
	@Query(value = "SELECT SUM(df.prixtotal) FROM detailfacture df WHERE df.facture.active = true")
	public float getChiffreAffaireMagasin();
	*/
	
}
