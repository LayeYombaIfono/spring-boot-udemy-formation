package com.hamilatech.backend.repository;

import com.hamilatech.backend.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categorie, Long> {
}
