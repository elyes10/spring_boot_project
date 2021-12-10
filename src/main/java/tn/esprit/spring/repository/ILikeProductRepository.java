package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.LikeProduct;

@Repository
public interface ILikeProductRepository extends JpaRepository<LikeProduct, Long> {

    @Query(value = "select COUNT(*) from like_product l where l.id_produit =:idProduct", nativeQuery = true)
    int findLikesByIdProduit(long idProduct);

    LikeProduct findLikeProductByIdProduitAndIdClient(long idProduct, long idClient);
}
