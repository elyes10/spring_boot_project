package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class detailFacture implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDetailFacture;
	private int qte;
	private Float prixTotal;
	private int pourcentageRemise;
	private Float montanRemise;
	
	//relation 
	@ManyToOne
	private  Produit Produit;
	
	
	//
	 @ManyToOne
	  private Facture facture;
	///
	
	public detailFacture() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	

	public detailFacture(Long idDetailFacture, int qte, Float prixTotal, int pourcentageRemise, Float montanRemise,
			tn.esprit.spring.entities.Produit produit, Facture facture) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montanRemise = montanRemise;
		Produit = produit;
		this.facture = facture;
	}







	

	public Long getIdDetailFacture() {
		return idDetailFacture;
	}







	public void setIdDetailFacture(Long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}







	public int getQte() {
		return qte;
	}







	public void setQte(int qte) {
		this.qte = qte;
	}







	public Float getPrixTotal() {
		return prixTotal;
	}







	public void setPrixTotal(Float prixTotal) {
		this.prixTotal = prixTotal;
	}







	public int getPourcentageRemise() {
		return pourcentageRemise;
	}







	public void setPourcentageRemise(int pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}







	public Float getMontanRemise() {
		return montanRemise;
	}







	public void setMontanRemise(Float montanRemise) {
		this.montanRemise = montanRemise;
	}







	public Produit getProduit() {
		return Produit;
	}







	public void setProduit(Produit produit) {
		Produit = produit;
	}







	public Facture getFacture() {
		return facture;
	}







	public void setFacture(Facture facture) {
		this.facture = facture;
	}







	@Override
	public String toString() {
		return "detailFacture [idDetailFacture=" + idDetailFacture + ", qte=" + qte + ", prixTotal=" + prixTotal
				+ ", pourcentageRemise=" + pourcentageRemise + ", montanRemise=" + montanRemise + ", Produit=" + Produit
				+ ", facture=" + facture + "]";
	}







	
	
	

}
