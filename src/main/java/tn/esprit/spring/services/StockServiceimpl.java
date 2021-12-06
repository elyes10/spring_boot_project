package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Aspect;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.IStockRepository;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Stock;
@Aspect
@Slf4j
@Service

public class StockServiceimpl implements StockService {
	
	@Autowired
	IStockRepository ISR;
	@Autowired
	StockService sr;
	

	@Override
	public List<Stock> getsAllStocks() {
		// TODO Auto-generated method stub
		 ArrayList<Stock> a=new ArrayList<Stock>();
		 ISR.findAll().forEach(stock1->a.add(stock1));
		 for(Stock s : a) {
			 log.info("list stock"+s);
		 }
		 
		 return a;
	}

	@Override
	public Stock addStock(Stock s) {
		log.info("stock ajouté"+s);
		// TODO Auto-generated method stub
		 return ISR.save(s);
	}

	

	@Override
	public Stock findStock(Long id) {
		// TODO Auto-generated method stub
		return ISR.findById(id).get();
	}



	

	@Override
	public Stock updateStock(Stock u) {
		
		log.info("stock update"+u);
		return ISR.save(u);
	}

	@Override
	public void deleteStock(Long stockId) {
		// TODO Auto-generated method stub
		ISR.deleteById((long) stockId);
	}

	@Override
	public void deleteStock(int i) {
		// TODO Auto-generated method stub
		
		ISR.deleteById((long) i);
	}

	

	
	@Override
	public Stock patchStock(Stock p) {
		// TODO Auto-generated method stub
		log.info("stock patched"+p);
		 return ISR.save(p);
	}
	
	@Scheduled(cron = "*/60 * * * * *" )
public String retrieveStatusStock() {
		SimpleDateFormat sdf = new 	SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String finalMessage = "";
		String newLine = System.getProperty("line.separator");
		List<Stock> stocks = ISR.retrieveStatusStock();
		for (int i= 0; i < stocks.size(); i++) {
			finalMessage = newLine + finalMessage +  msgDate + newLine + ": le produit"
					+stocks.get(i).getLibelleStock() +  "a un stock de" + stocks.get(i).getQte()
					+ "inférieur à la quantité minimale a ne pas dépasser de " + stocks.get(i).getQteMin()
					+newLine;
			
		}
		log.info(finalMessage);
		return finalMessage;
	
	}

	
 public List <Produit> findProduit (Long id) {
	 return (List<Produit>) ISR.findProduit(id);
 }

	

	

	







	
  

	



	
	

	



	

	


	

}