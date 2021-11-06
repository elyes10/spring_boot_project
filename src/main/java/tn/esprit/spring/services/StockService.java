package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entities.Stock;

public interface StockService {
	
	List<Stock> getsAllStocks();
	Stock addStock(Stock s);
	Stock updateStock(Stock u);
	Stock findStock(Long id);
	void deleteStock(int i);
	void deleteStock(Long stockId);
}