package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rayon {
   
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idRayon;
	private String Code;
	private String libelle;
	
	@OneToMany(mappedBy = "rayon")
	private  List <Produit> Produits;
	
	public Rayon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rayon(Long idRayon, String code, String libelle) {
		super();
		this.idRayon = idRayon;
		Code = code;
		this.libelle = libelle;
	}
	
	
	
	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Rayon [idRayon=" + idRayon + ", Code=" + Code + ", libelle=" + libelle + "]";
	}
	
	
	
}
