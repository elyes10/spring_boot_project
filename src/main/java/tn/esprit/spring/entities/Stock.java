package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Stock implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock;
	@Column(name="qte")
	private  int  qte;
	@Column(name="qteMin")
	private int qteMin;
	@Column(name="libelleStock")
	private String libelleStock;
	
	@JsonIgnore
	@OneToMany(mappedBy = "stock")
	private  List <Produit> Produits;

	public Stock(Long idStock) {
		super();
		this.idStock = idStock;
	}
	
	
	

}
