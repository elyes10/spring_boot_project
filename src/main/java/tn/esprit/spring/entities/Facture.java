package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Facture {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFActure;
	private float montantRemise ;
	private float montantFacture;
	@Temporal (TemporalType.DATE)
	private Date dateFacture;
	private Boolean active;
	
	//relation client et facture
	 @ManyToOne
	  private Client client;
	 
	 //relation facture  et details facture
	 @OneToMany(mappedBy = "facture")
		private  List <detailFacture> detailFactures;
	 
	 
	
	
	
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(Long idFActure, float montantRemise, float montantFacture, Date dateFacture, Boolean active) {
		super();
		this.idFActure = idFActure;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
	}
	
	
	public float getMontantRemise() {
		return montantRemise;
	}
	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}
	public float getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Facture [idFActure=" + idFActure + ", montantRemise=" + montantRemise + ", montantFacture="
				+ montantFacture + ", dateFacture=" + dateFacture + ", active=" + active + "]";
	}
	
	
	

}
