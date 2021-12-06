package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.*;




@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString

public class Produit implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
  private Long idProduit;
	@Column(name="code")
  private String code;
	@Column(name="Libelle")
  private String  Lieblle ; 
	@Column(name="prixUnitaire")
  private Float prixUnitaire;
  
	
  @ManyToOne
  private Rayon rayon;
  
  @OneToMany(mappedBy="Produit")
  private List <detailFacture> detailFacture;
  
  
  @ManyToOne
  private Stock stock;
  
  @OneToOne
  private DetailProduit Detailproduit;
 
  @ManyToMany(cascade = CascadeType.ALL)
  private Set<Fournisseur> Fournisseur;
  
  public Produit(Long idProduit) {
		super();
		this.idProduit = idProduit;
	}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Produit other = (Produit) obj;
	if (Detailproduit == null) {
		if (other.Detailproduit != null)
			return false;
	} else if (!Detailproduit.equals(other.Detailproduit))
		return false;
	if (Fournisseur == null) {
		if (other.Fournisseur != null)
			return false;
	} else if (!Fournisseur.equals(other.Fournisseur))
		return false;
	if (Lieblle == null) {
		if (other.Lieblle != null)
			return false;
	} else if (!Lieblle.equals(other.Lieblle))
		return false;
	if (code == null) {
		if (other.code != null)
			return false;
	} else if (!code.equals(other.code))
		return false;
	if (detailFacture == null) {
		if (other.detailFacture != null)
			return false;
	} else if (!detailFacture.equals(other.detailFacture))
		return false;
	if (idProduit == null) {
		if (other.idProduit != null)
			return false;
	} else if (!idProduit.equals(other.idProduit))
		return false;
	if (prixUnitaire == null) {
		if (other.prixUnitaire != null)
			return false;
	} else if (!prixUnitaire.equals(other.prixUnitaire))
		return false;
	if (rayon == null) {
		if (other.rayon != null)
			return false;
	} else if (!rayon.equals(other.rayon))
		return false;
	if (stock == null) {
		if (other.stock != null)
			return false;
	} else if (!stock.equals(other.stock))
		return false;
	return true;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Detailproduit == null) ? 0 : Detailproduit.hashCode());
	result = prime * result + ((Fournisseur == null) ? 0 : Fournisseur.hashCode());
	result = prime * result + ((Lieblle == null) ? 0 : Lieblle.hashCode());
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	result = prime * result + ((detailFacture == null) ? 0 : detailFacture.hashCode());
	result = prime * result + ((idProduit == null) ? 0 : idProduit.hashCode());
	result = prime * result + ((prixUnitaire == null) ? 0 : prixUnitaire.hashCode());
	result = prime * result + ((rayon == null) ? 0 : rayon.hashCode());
	result = prime * result + ((stock == null) ? 0 : stock.hashCode());
	return result;
}
  
  
}
