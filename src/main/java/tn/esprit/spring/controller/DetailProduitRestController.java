package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.service.IDetailProduitService;

@Slf4j
@RestController
@RequestMapping("/detailProduit")
public class DetailProduitRestController {
	
	 @Autowired
	 IDetailProduitService  dps;
	 
	/*@GetMapping(value="/getDPByLibelle/{lib}")
	@ResponseBody
	public DetailProduit retrieveProduitsByCat(@PathVariable("lib") String lib){
		 DetailProduit dp = dps.getDetailProduitsByLibelleProduit(lib);
		return dp ;
		
	}*/
	

}
