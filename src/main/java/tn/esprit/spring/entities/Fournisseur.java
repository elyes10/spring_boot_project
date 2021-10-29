package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Fournisseur implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFournisseur;
	private String code;
	private String libelle;
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(Long idFournisseur, String code, String libelle) {
		super();
		this.idFournisseur = idFournisseur;
		this.code = code;
		this.libelle = libelle;
	}
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Fournissuer [idFournisseur=" + idFournisseur + ", code=" + code + ", libelle=" + libelle + "]";
	}
	
	
}