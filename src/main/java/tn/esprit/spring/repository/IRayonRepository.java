package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Rayon;


@Repository
public interface IRayonRepository extends CrudRepository<Rayon, Long>{
	

	@Modifying
	@Query(value = "delete from Rayon r where r.idRayon= :id", nativeQuery = true)
	public void deleteReqById(@Param("id") Long id) ;
	
	
	@Modifying
	@Query(value = "INSERT INTO Rayon (idRayon, code,libelle) VALUES (:idRayon,:code, :libelle, )",
	nativeQuery = true)
	Rayon addRayon(@Param("idRayon")Long idRayon ,@Param("code")String code,@Param("libelle")String libelle );
	

	@Query(value = "SELECT r FROM Rayon r")
	List<Rayon> getAll();

	@Query(value = "select * from Rayon r where r.idRayon =:id", nativeQuery = true)
	Rayon retrieveRayon(Long id);



}
