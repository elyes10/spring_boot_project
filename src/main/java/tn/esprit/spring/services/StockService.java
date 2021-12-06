package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Stock;

public interface StockService {
	
	List<Stock> getsAllStocks();
	String retrieveStatusStock();
	Stock addStock(Stock s);
	Stock updateStock(Stock u);
	Stock findStock(Long id);
	Stock patchStock (Stock p);
    
    void deleteStock(int i);
	void deleteStock(Long stockId);
	List<Produit> findProduit(Long id);
	
	
}