package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Client  implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nom;
	private String  prenom;
	@Temporal (TemporalType.DATE)
	private Date dateNaissance;
	private String  email;
	private String password;
	@Enumerated(EnumType.STRING)
	private categorieClient  CategorieClient;
	@Enumerated(EnumType.STRING)
	private profession  profession;
	
	
	@OneToMany(mappedBy = "client")
	private  List <Facture> Factures;
	
	
	
	
	
	
	
	
	
	

}
