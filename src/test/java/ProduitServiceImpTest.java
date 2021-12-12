import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.service.IDetailProduitService;
import tn.esprit.spring.service.IProduitService;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProduitServiceImpTest {

    @Autowired
    IProduitService ps;
    @Autowired
    IDetailProduitService dps;

@Test
public void testDeleteProduit(){
    int nbP =this.ps.findAllProduits().size();
    this.ps.deleteProduitById(87L);
    assertEquals(nbP-1,ps.findAllProduits().size());
}
    @Test
    public void testAddProduit() {
        List<Produit> produits = ps.findAllProduits();
        int expected=produits.size();
        Produit produit = new Produit();
        produit.setCode("test_code11");
        produit.setLibelle("test_label11");
        produit.setPrixUnitaire(11.051F);
        produit.setRayon(new Rayon());
        produit.setStock(new Stock());
        produit.setDetailProduit(new DetailProduit());
        ps.addProduit(produit);
        assertEquals(expected+1, ps.findAllProduits().size());
        assertNotNull(produit.getIdProduit());
        ps.deleteProduitById(produit.getIdProduit());
    }



}
