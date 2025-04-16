package com.hamilatech.backend.repository;

import com.hamilatech.backend.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@RepositoryRestController(path = "cat")
//@CrossOrigin("http://localhost:4200/")
public interface CategoryRepository extends JpaRepository<Categorie, Long> {
}
