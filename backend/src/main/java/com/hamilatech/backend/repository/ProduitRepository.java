package com.hamilatech.backend.repository;

import com.hamilatech.backend.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
