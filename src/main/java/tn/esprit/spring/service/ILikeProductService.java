package tn.esprit.spring.service;

import tn.esprit.spring.entities.Produit;

public interface ILikeProductService {

    void addProdcutLike(long idProduct, long idClient);

    void deleteLikeProduitByProductIdClientId(long idProduct, long idClient);

    int getLikesOfProduct(long idProduct);

    Produit[] getLikedClientProduct(long idClient);

}
