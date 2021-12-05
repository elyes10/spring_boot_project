package tn.esprit.spring.controller;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

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

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.service.IFournisseurService;

@Slf4j
@RestController
@RequestMapping("/fournisseur")
public class FournisseurRestController {
	
	
	
	@Autowired
	IFournisseurService fs;
	
	
	@GetMapping(value="/getAllFournisseurs")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
	List<Fournisseur> listf = fs.retrieveAllFournisseurs();
	return listf;

}
	
	
	@PostMapping(value ="/addFournisseur")
	@ResponseBody
	@ApiOperation(value = "Ajouter un fournisseur")
	public void ajoutProduit(@RequestBody Fournisseur f){
		        fs.addFournisseur(f);
				
	}
	
	
	
	
	
	@GetMapping("/retrieveFournisseur/{id}")
	@ResponseBody
	@ApiOperation(value = "retrouver un fournisseur")
	 public Fournisseur getProduit(@PathVariable("id")Long idFournisseur){
		 Fournisseur f=fs.retrieveFournisseur(idFournisseur);
		 return f;
		 }
	
	
	
	@DeleteMapping("/deleteFournisseur/{id}")
	@ResponseBody
	@ApiOperation(value = "Supprimer un fournisseur")
	public void deleteFournisseurById(@PathVariable("id") Long idFournisseur){
       fs.deleteFournisseur(idFournisseur);		
	}
	
	
	
	@PutMapping("/updateFournisseur")
	@ResponseBody
	@ApiOperation(value = "modifier un fournisseur")

	public void updateProduit(@RequestBody Fournisseur f) throws RelationNotFoundException{
       fs.updateFournisseur(f);
}
	

}
