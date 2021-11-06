package tn.esprit.spring.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Stock;

@Repository
public interface IStockRepository extends CrudRepository<Stock, Long> {

	

	@Modifying
	@Query(value = "delete from Stock s where s.idStock= :id", nativeQuery = true)
	public void deleteReqById(@Param("id") Long id) ;
	
	
	@Modifying
	@Query(value = "INSERT INTO Stock (idStock, qte,qteMin,libelleStock) VALUES (:idStock,:qte, :qteMin, :libelleStock, )",
	nativeQuery = true)
	Stock addStock(@Param("idStock")Long idStock ,@Param("qte")int qte,@Param("qteMin")int qteMin,@Param( "libelleStock")String libelleStock );
	

	@Query(value = "SELECT s FROM Stock s")
	List<Stock> getAll();

	@Query(value = "select * from Stock s where s.idStock =:id", nativeQuery = true)
	Stock retrieveStock(Long id);



	

}
