package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.ImageModel;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	
	Optional<ImageModel> findByName(String name);
}
