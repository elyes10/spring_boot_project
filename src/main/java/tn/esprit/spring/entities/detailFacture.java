package tn.esprit.spring.entities;

import java.io.Serializable;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class detailFacture implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	private Long idDetailFacture;
	@Column(name="qte")
	private int qte;
	@Column(name="prixTotal")
	private Float prixTotal;
	@Column(name="pourcentageRemise")
	private int pourcentageRemise;
	@Column(name="montantRemise")
	private Float montanRemise;
	
	//relation 
	@ManyToOne
	private  Produit Produit;
	
	
	//
	 @ManyToOne
	  private Facture facture;
	///
	
	
	

}
