package com.hamilatech.backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;


@Entity
@Table(name = "table_produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String nomProduit;

    @Column(nullable = false)
    private  double prixProduit;

   @Column
   @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreation;

    @ManyToOne
    private Categorie categorie;


    public Produit() {
        super();
    }

    public Produit(String nomProduit, double prixProduit, LocalDate dateCreation, Categorie categorie) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
