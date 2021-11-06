package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import tn.esprit.spring.services.StockService;
import tn.esprit.spring.entities.Stock;

@RestController
@Api(tags = "Stock management")
@RequestMapping("/stock")
public class StockRestController {

	@Autowired
	StockService stockService;
	
	// http://localhost:8089/SpringMVC/stock/get-all-stocks
	@GetMapping("/get-all-stocks")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des stocks")
	public List<Stock> getStocks() {
	List<Stock> listStocks = stockService.getsAllStocks();
	return listStocks;
	}
	
	
	// http://localhost:8089/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s)
	{
	Stock stock = stockService.addStock(s);
	return stock;
	}
	
	
	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
	stockService.deleteStock(stockId);
	}
	
	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
	return stockService.updateStock(stock);
	}
	
}
