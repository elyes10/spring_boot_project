package tn.esprit.spring.service;

import tn.esprit.spring.entities.Rayon;

import java.util.List;


public interface RayonService {
	
	
	List<Rayon> getsAllRayons();
	Rayon addRayon(Rayon r);
	Rayon updateRayon(Rayon u);
	Rayon findRayon(Long id);
	Rayon patchRayon (Rayon p);
	void deleteRayon(int i);
	void deleteRayon(Long rayonId);
	
}
