package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.DetailFacture;

public interface DetailFactureService {

	List<DetailFacture> retrieveAllDetailFactures();
	DetailFacture addDetailFacture(DetailFacture f);
	void deleteDetailFacture(Long id);
	DetailFacture updateDetailFacture(DetailFacture f);
	DetailFacture retrieveDetailFacture(Long id);
}
