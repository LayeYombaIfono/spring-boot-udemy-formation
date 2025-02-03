package com.hamilatech.backend.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomProduit;

    @Column
    private  double prixProduit;

    @Column
    private Date dateCreation;

    @ManyToOne
    private Categorie categorie;


    @Override
    public String toString() {
        return "Produit :" +":" + id +", nomProduit:'" + nomProduit + ", prixProduit:" + prixProduit + ", dateCreation:" + dateCreation;

    }
}
