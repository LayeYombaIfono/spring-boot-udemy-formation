package com.hamilatech.backend.entities;

import jakarta.persistence.*;


import java.util.Date;

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

    public Produit() {
        super();
    }

    public Produit(String nomProduit, double prixProduit, Date dateCreation) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
    }


    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    @Override
    public String toString() {
        return "Produit :" +":" + id +", nomProduit:'" + nomProduit + ", prixProduit:" + prixProduit + ", dateCreation:" + dateCreation;

    }
}
