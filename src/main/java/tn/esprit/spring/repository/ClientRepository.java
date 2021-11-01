/**
 * 
 */
package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Client;

/**
 * @author HP OMEN
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
