package com.hamilatech.backend.service;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.repository.CategoryRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategorieServiceImpl implements  CategoryService{

    @Autowired
    private  CategoryRepository repository;


    @Override
    public Categorie addCategory(Categorie categorie) {
      try {
          if (categorie != null){

             return this.repository.save(categorie);
          }
          return null;

      }catch (Exception e){
          throw new RuntimeException(e.getMessage());
      }

    }

    @Override
    public List<Categorie> getAllCategory() {
        try {
            List<Categorie> categoryExisting = this.repository.findAll();
            if (categoryExisting.isEmpty()){
                throw new RuntimeException("Erreur du serveur");
            }
            return categoryExisting;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void deleteCategoryById(Long id) {
        this.repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aucune catégorie trouvé avec ID " + id));
    }


}
