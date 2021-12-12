package tn.esprit.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.service.IDetailProduitService;
import tn.esprit.spring.service.IProduitService;
import tn.esprit.spring.service.ImageService;
import javax.management.relation.RelationNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping("/produit")
public class ProduitRestController {

    @Autowired
    IProduitService ips;

    @Autowired
    IDetailProduitService dps;

    @Autowired
    ImageService imageService;


    @GetMapping(value = "/getAllProduits")
    @ResponseBody
    public List<Produit> getProduits() {
        List<Produit> listProduits = ips.findAllProduits();
        return listProduits;

    }

    @PostMapping(value = "/addProduit", consumes = {"multipart/form-data"})
    @ResponseBody
    @ApiOperation(value = "Ajouter un produit")
    public Produit ajoutProduit(@RequestParam("produit") String p, @RequestParam("files") MultipartFile[] files) throws JsonProcessingException, RelationNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        Produit data = objectMapper.readValue(p, Produit.class);
        List<String> file_s = new ArrayList<String>();
        dps.saveDetailProduit(data.getDetailProduit());
        Produit produit = ips.addProduit(data);
        for (int i = 0; i < files.length; i++) {
            imageService.store(files[i], data);
            file_s.add("http://localhost:8083/SpringMVC/produit/" + produit.getIdProduit() + "/" + produit.getIdProduit() +  files[i].getOriginalFilename());
        }
        produit.setImagesUrls(file_s);
        ips.updateProduit(produit);
        return produit;
    }

    @GetMapping("/{productId}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename, @PathVariable Long productId) throws IOException {
        Resource file = imageService.loadProductFiles(filename, productId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok().headers(headers)
                .body(new InputStreamResource(file.getInputStream()));
    }

    @GetMapping("/retrieveProduit/{idProduit}")
    @ResponseBody
    public Produit getProduit(@PathVariable("idProduit") Long idPoduit) {
        return ips.retrieveProduitById(idPoduit);
    }

    @DeleteMapping("/deleteProduit/{idProduit}")
    @ResponseBody
    @ApiOperation(value = "Supprimer un produit")
    public void deleteProduitById(@PathVariable("idProduit") Long idProduit) {
        ips.deleteProduitById(idProduit);
    }

    @PutMapping("/updateProduit/{idProduit}")
    @ResponseBody
    public void updateProduit(@RequestBody Produit p, @PathVariable("idProduit") Long idProduit) throws RelationNotFoundException {
        ips.updateProduit(p);
    }

    @GetMapping(value = "/getProduitsByCategorie/{cp}")
    @ResponseBody
    public List<Produit> retrieveProduitsByCat(@PathVariable("cp") CategorieProduit categorieProduit) {
        return ips.retrieveProduitsByCategorie(categorieProduit);
    }

    @PutMapping("/assignProduitToStock")
    @ResponseBody
    public void assignProduitToStock(@RequestBody Produit p) {
        ips.assignProduitToStock(p.getIdProduit(), p.getStock().getIdStock());
    }

    @PutMapping("/assignFournisseurToProduit/{p}/{f}")
    @ResponseBody
    public void assignFournisseurtToProduit(@RequestBody @PathVariable("p") Long idProduit, @PathVariable("f") Long idFournisseur) {
        ips.assignFournisseutToProduit(idProduit, idFournisseur);
    }

    @GetMapping(value = "/getProduitsByDateCreation/{d1}/{d2}")
    @ResponseBody
    public List<Produit> produitParDateCreation(@PathVariable("d1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date d1, @PathVariable("d2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date d2) {
        return ips.ProduitParDateCreation(d1, d2);
    }

    @PutMapping("/updateRaitingProduit")
    @ResponseBody
    public void addRatingProduit(@RequestBody Produit p) throws RelationNotFoundException {
        System.out.println("produit "+p);
        ips.addRaitingProduit(p);
    }

    @GetMapping("/getRatingByProduit")
    public float getProductRating(Long idProduct) throws RelationNotFoundException{
       return  ips.getProductRating(idProduct);
    }
    @Scheduled(fixedDelay = 60000)
    @GetMapping("/getC")
    Map<CategorieProduit ,Integer> getNb(){
   return ips.getNbProduitByCategorie();
}
}