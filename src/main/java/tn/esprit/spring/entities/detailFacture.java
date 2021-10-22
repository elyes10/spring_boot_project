package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.*;


@Entity
public class detailFacture {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDetailFacture;
	private int qte;
	private Float prixTotal;
	private int pourcentageRemise;
	private Float montanRemise;
	
	//relation 
	@OneToMany(mappedBy = "detailfacture")
	private  List <Produit> Produits;
	
	
	//
	 @ManyToOne
	  private Facture facture;
	///
	
	public detailFacture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public detailFacture(Long idDetailFacture, int qte, Float prixTotal, int pourcentageRemise, Float montanRemise) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montanRemise = montanRemise;
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

	@Override
	public String toString() {
		return "detailFacture [idDetailFacture=" + idDetailFacture + ", qte=" + qte + ", prixTotal=" + prixTotal
				+ ", pourcentageRemise=" + pourcentageRemise + ", montanRemise=" + montanRemise + "]";
	}
	
	
	

}
