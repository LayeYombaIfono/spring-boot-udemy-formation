package com.hamilatech.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import lombok.*;

import java.util.List;


@Entity
@Table(name = "table_categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    @Column
    private String nomCat;


    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
   private List<Produit> produits;

    public Categorie() {
        super();
    }

    public Categorie(String nomCat, List<Produit> produits) {
        this.nomCat = nomCat;
        this.produits = produits;
    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
