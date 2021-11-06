package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.IRayonRepository;
import tn.esprit.spring.entities.Rayon;


@Slf4j
@Service
public class RayonServiceimpl implements RayonService{
	
	@Autowired
	IRayonRepository IRR;

	@Override
	public List<Rayon> getsAllRayons() {
		// TODO Auto-generated method stub
		 ArrayList<Rayon> c=new ArrayList<Rayon>();
		 IRR.findAll().forEach(rayon1->c.add(rayon1));
		 for(Rayon r : c) {
			 log.info("list rayon"+r);
		 }
		 return c;
	}

	@Override
	public Rayon addRayon(Rayon r) {
		log.info("rayon ajouté"+r);
		// TODO Auto-generated method stub
		 return IRR.save(r);
	}

	@Override
	public Rayon updateRayon(Rayon u) {
		// TODO Auto-generated method stub
				log.info("rayon update"+u);
				return IRR.save(u);
	}

	@Override
	public Rayon findRayon(Long id) {
		// TODO Auto-generated method stub
				return IRR.findById(id).get();
	}

	@Override
	public void deleteRayon(int i) {
		// TODO Auto-generated method stub
		
		IRR.deleteById((long) i);
	}

	@Override
	public void deleteRayon(Long rayonId) {
		// TODO Auto-generated method stub
		IRR.deleteById((long) rayonId);
	}

}
