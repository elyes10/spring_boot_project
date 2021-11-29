package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.repository.IStockRepository;
import tn.esprit.spring.entities.Stock;
@Slf4j
@Service
public class StockServiceimpl implements StockService {
	@Autowired
	IStockRepository ISR;
	
	

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
		// TODO Auto-generated method stub
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

	@Scheduled(fixedRate = 60000)
	public void fixedRateMethod() {

	log.info("Method with fixed Rate");
	}
	
	@Scheduled(fixedDelay = 60000)
	public void fixedDelayMethod() {

	log.info("Method with fixed delay");

	}
	@Scheduled(cron = "*/60 * * * * *" )
	public void cronMethod() {

	log.info("Method with cron expression");
	}

	



	
	

	



	

	


	

}