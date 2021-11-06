package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class Client  implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idClient")
	private Long idClient;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String  prenom;
	@Temporal (TemporalType.DATE)
	private Date dateNaissance;
	@Column(name="email")
	private String  email;
	@Column(name="password")
	private String password;
	@Enumerated(EnumType.STRING)
	private categorieClient  CategorieClient;
	@Enumerated(EnumType.STRING)
	private profession  profession;
	
	
	@OneToMany(mappedBy = "client")
	private  List <Facture> Factures;
	
	
	
}
