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
	
	@OneToMany(mappedBy = "rayon")
	@JsonIgnore
	@ToString.Exclude
	private  List <Produit> Produits;

	public Rayon(Long idRayon) {
		super();
		this.idRayon = idRayon;
	}


}
