package tn.esprit.spring.entities;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class DetailProduit implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDetailProduit;
	@Temporal (TemporalType.DATE)
	private Date dateCreation;
	@Temporal (TemporalType.DATE)
	private Date dateDerniereModification;
	@Enumerated(EnumType.STRING)
	private categorieProduit CategorieProduit;
	
	
	
	public DetailProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public DetailProduit(Long idDetailProduit, Date dateCreation, Date dateDerniereModification,
			categorieProduit categorieProduit) {
		super();
		this.idDetailProduit = idDetailProduit;
		this.dateCreation = dateCreation;
		this.dateDerniereModification = dateDerniereModification;
		CategorieProduit = categorieProduit;
	}





	public Date getDateCreation() {
		return dateCreation;
	}





	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}





	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}





	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}





	public categorieProduit getCategorieProduit() {
		return CategorieProduit;
	}





	public void setCategorieProduit(categorieProduit categorieProduit) {
		CategorieProduit = categorieProduit;
	}





	@Override
	public String toString() {
		return "DetailProduit [idDetailProduit=" + idDetailProduit + ", dateCreation=" + dateCreation
				+ ", dateDerniereModification=" + dateDerniereModification + ", CategorieProduit=" + CategorieProduit
				+ "]";
	}





	
	
}
