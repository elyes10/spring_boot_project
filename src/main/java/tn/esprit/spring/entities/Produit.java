package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Produit {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long idProduit;
  private String code;
  private String  Lieblle ; 
  private Float prixUnitaire;
  
  @ManyToOne
  private Rayon rayon;
  
  @ManyToOne
  private detailFacture detailfacture;
  
  @ManyToOne
  private Stock stock;
  @OneToOne
  private DetailProduit Detailproduit;
  @ManyToMany(cascade = CascadeType.ALL)
  private Set<Fournisseur> Fournisseur;
  
  
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}


public Produit(String code, String lieblle, Float prixUnitaire) {
	super();
	this.code = code;
	Lieblle = lieblle;
	this.prixUnitaire = prixUnitaire;
}




public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public String getLieblle() {
	return Lieblle;
}


public void setLieblle(String lieblle) {
	Lieblle = lieblle;
}


public Float getPrixUnitaire() {
	return prixUnitaire;
}


public void setPrixUnitaire(Float prixUnitaire) {
	this.prixUnitaire = prixUnitaire;
}


@Override
public String toString() {
	return "produit [idProduit=" + idProduit + ", code=" + code + ", Lieblle=" + Lieblle + ", prixUnitaire="
			+ prixUnitaire + "]";
}
  
  
}
