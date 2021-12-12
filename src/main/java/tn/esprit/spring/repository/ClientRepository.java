package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Client;

import java.util.List;

/**
 * @author HP OMEN
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByCategorieClient(CategorieClient CategorieClient);

	Client findByNom(String nom);

}
