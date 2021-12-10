package tn.esprit.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.service.ILikeProductService;

import javax.management.relation.RelationNotFoundException;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping("/like")
public class LikeRestController {

    @Autowired
    ILikeProductService likeProductService;

    @PostMapping(value = "/addLike/{idProduit}/{idClient}")
    @ResponseBody
    @ApiOperation(value = "Ajouter like à un produit")
    public void ajoutProduit(@PathVariable("idProduit") Long idProduct, @PathVariable("idClient") Long idClient) {
        likeProductService.addProdcutLike(idProduct, idClient);
    }

    @GetMapping("/likes/{idProduit}")
    @ResponseBody
    public int getProduitLikes(@PathVariable("idProduit") Long idPoduit) {
        return likeProductService.getLikesOfProduct(idPoduit);
    }

    @DeleteMapping("/deleteLikeProduit/{idProduit}/{idClient}")
    @ResponseBody
    @ApiOperation(value = "Supprimer un like du produit")
    public void deleteProduitById(@PathVariable("idProduit") Long idProduit, @PathVariable("idClient") Long idClient) {
        likeProductService.deleteLikeProduitByProductIdClientId(idProduit, idClient);
    }
}