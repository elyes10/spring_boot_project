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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.*;




@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
  

  
}
