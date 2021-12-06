package tn.esprit.spring.service;

import tn.esprit.spring.entities.Stock;

import java.util.List;

public interface StockService {
	
	List<Stock> getsAllStocks();
	Stock addStock(Stock s);
	Stock updateStock(Stock u);
	Stock findStock(Long id);
	Stock patchStock (Stock p);
    void deleteStock(int i);
	void deleteStock(Long stockId);
	
}