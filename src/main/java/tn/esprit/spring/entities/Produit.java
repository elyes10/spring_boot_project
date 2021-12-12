package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Produit implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduit")
    private Long idProduit;

    @NotNull
    @Column(name = "code")
    private String code;

    @NotNull
    @Column(name = "libelle")
    private String libelle;

    @NotNull
    @Column(name = "prixUnitaire")
    private Float prixUnitaire;

    @DecimalMin(value="0.0")
    @DecimalMax(value="5.0")
    private  float rating;

    private int sommeRating;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Rayon rayon;

    @OneToMany(mappedBy = "Produit")
    private List<DetailFacture> detailFacture;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Stock stock;

    @OneToOne(cascade = {CascadeType.ALL})
    private DetailProduit detailProduit;

    @ManyToMany()
    private Set<Fournisseur> fournisseurs;

    @ElementCollection(targetClass=String.class)
    private List<String> imagesUrls;
}
