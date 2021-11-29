package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Rayon implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
   
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private Long idRayon;
	@Column(name="code")
	private String Code;
	@Column(name="libelle")
	private String libelle;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "rayon")
	private  List <Produit> Produits;

	public Rayon(Long idRayon) {
		super();
		this.idRayon = idRayon;
	}
	
	
	
	
	
}
