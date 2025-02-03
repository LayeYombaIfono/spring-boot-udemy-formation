package com.hamilatech.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    @Column
    private String nomCat;

    @Column
    private String descriptionCat;



    @OneToMany(mappedBy = "categorie")
    List<Produit> produits;



}
