package tn.esprit.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.StockService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class Stocktest {
	@Autowired
	StockService stockService;
	
	
	/*Stock s = new Stock();
	@Test
	public void testAddStock() {
	stockService.getsAllStocks();
	}*/

	/*@Test
	public void testDELETEStock() {
	stockService.deleteStock(17);

	}*/
	
		
	
	
}

