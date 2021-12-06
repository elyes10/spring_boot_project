package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Stock;

import java.util.List;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {

	
   //DeleteData
	//jpql
	@Modifying
	@Query(value = "delete from Stock s where s.idStock= :id")
	void deleteReqById(@Param("id") Long id) ;
	
	//InsertDatatoDataBase
	//sql
	@Modifying
	@Query(value = "INSERT INTO Stock (idStock, qte,qteMin,libelleStock) VALUES (:idStock,:qte, :qteMin, :libelleStock, )",
	nativeQuery = true)
	Stock addStock(@Param("idStock")Long idStock ,@Param("qte")int qte,@Param("qteMin")int qteMin,@Param( "libelleStock")String libelleStock );
	
    //SelectAllStocks
	//jpql
	@Query(value = "SELECT s FROM Stock s")
	List<Stock> getAll();
	
	

    //GetById
	//jpql
	@Query(value = "select s from Stock s where s.idStock =:id")
	Stock retrieveStockByid(@Param("id") Long id);
	
	
	//SelectStockByProduit
		@Query(value="	select s.libelle_stock from stock s JOIN produit p on p.stock_id_stock=s.id_stock WHERE p.id_produit=?1",nativeQuery=true)
		String getStockByProd(Long idProduit);
		
		
	
				
				
	
	



	

}
