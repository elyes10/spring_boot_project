package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stock implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idStock;
	private  int  qte;
	private int qteMin;
	private String libelleStock;
	
	@OneToMany(mappedBy = "stock")
	private  List <Produit> Produits;
	
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Stock(Long idStock, int qte, int qteMin, String libelleStock) {
		super();
		this.idStock = idStock;
		this.qte = qte;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
	}







	public int getQte() {
		return qte;
	}




	public void setQte(int qte) {
		this.qte = qte;
	}




	public int getQteMin() {
		return qteMin;
	}




	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}




	public String getLibelleStock() {
		return libelleStock;
	}




	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}




	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", qte=" + qte + ", qteMin=" + qteMin + ", libelleStock=" + libelleStock
				+ "]";
	}
	
	
	

}
