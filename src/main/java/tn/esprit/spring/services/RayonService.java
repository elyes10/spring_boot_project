package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Rayon;


public interface RayonService {
	
	
	List<Rayon> getsAllRayons();
	Rayon addRayon(Rayon r);
	Rayon updateRayon(Rayon u);
	Rayon findRayon(Long id);
	void deleteRayon(int i);
	void deleteRayon(Long rayonId);

}
