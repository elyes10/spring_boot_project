package tn.esprit.spring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
	private CategorieClient categorieClient;
	@Enumerated(EnumType.STRING)
	private Profession profession;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private  List <Facture> Factures;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	

}
