package tn.esprit.spring.entities;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DetailProduit implements Serializable{
	
	
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDertailProduit")
	private Long idDetailProduit;
	@Temporal (TemporalType.DATE)
	private Date dateCreation;
	@Temporal (TemporalType.DATE)
	private Date dateDerniereModification;
	@Enumerated(EnumType.STRING)
	private categorieProduit CategorieProduit;
	
	
	
	
}
