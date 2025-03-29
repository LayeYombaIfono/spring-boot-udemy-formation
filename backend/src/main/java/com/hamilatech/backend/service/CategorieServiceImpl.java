package com.hamilatech.backend.service;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.exception.ProductNotFoundException;
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
	public Categorie getCategoryById(Long id) {
		
		return repository.findById(id)
				.orElseThrow(RuntimeException::new);
	}
	
	@Override
	public void deleteCategoryById(Long id) {
		try {
			this.getCategoryById(id);
			repository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Erreur" + e.getMessage());
		}
	
	}

}
