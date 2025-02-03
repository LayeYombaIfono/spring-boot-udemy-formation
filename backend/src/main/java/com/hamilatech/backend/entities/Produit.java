package com.hamilatech.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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


    @Override
    public String toString() {
        return "Produit :" +":" + id +", nomProduit:'" + nomProduit + ", prixProduit:" + prixProduit + ", dateCreation:" + dateCreation;

    }
}
