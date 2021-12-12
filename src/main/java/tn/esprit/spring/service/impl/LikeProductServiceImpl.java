package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.LikeProduct;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.ILikeProductRepository;
import tn.esprit.spring.service.ILikeProductService;

@Service
public class LikeProductServiceImpl implements ILikeProductService {

    @Autowired
    ILikeProductRepository likeProductRepository;

    @Override
    public void addProdcutLike(long idProduct, long idClient) {
        LikeProduct like = new LikeProduct();
        like.setIdProduit(idProduct);
        like.setIdClient(idClient);
        likeProductRepository.save(like);
    }

    @Override
    public int getLikesOfProduct(long idProduct) {
        return likeProductRepository.findLikesByIdProduit(idProduct);
    }

    @Override
    public Produit[] getLikedClientProduct(long idClient) {
        return new Produit[0];
    }

    @Override
    public void deleteLikeProduitByProductIdClientId(long idProduct, long idClient) {
        LikeProduct likeProduct = likeProductRepository.findLikeProductByIdProduitAndIdClient(idProduct, idClient);
        likeProductRepository.delete(likeProduct);
    }
}
