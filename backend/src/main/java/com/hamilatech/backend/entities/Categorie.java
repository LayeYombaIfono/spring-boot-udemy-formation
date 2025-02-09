package com.hamilatech.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "table_categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    @Column
    private String nomCat;

    @Column
    private String descriptionCat;



    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
   private List<Produit> produits;



}
