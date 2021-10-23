package tn.esprit.spring.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity
public class Client  {
	
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
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Long idClient, String nom, String prenom, Date dateNaissance, String email, String password,
			categorieClient categorieClient, tn.esprit.spring.entities.profession profession) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
		CategorieClient = categorieClient;
		this.profession = profession;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public categorieClient getCategorieClient() {
		return CategorieClient;
	}
	public void setCategorieClient(categorieClient categorieClient) {
		CategorieClient = categorieClient;
	}
	public profession getProfession() {
		return profession;
	}
	public void setProfession(profession profession) {
		this.profession = profession;
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", email=" + email + ", password=" + password + ", CategorieClient=" + CategorieClient
				+ ", profession=" + profession + "]";
	}
	
	
	

}
