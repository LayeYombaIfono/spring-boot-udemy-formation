package com.hamilatech.backend.controller;

import com.hamilatech.backend.entities.Categorie;

import com.hamilatech.backend.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/cats")
//@CrossOrigin
public class CategoryRestController {
    
	@Autowired
    private CategoryService service;


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Categorie> addCategory(@RequestBody Categorie categorie){
      Categorie categorySaved = this.service.addCategory(categorie);

      return new ResponseEntity<>(categorySaved, HttpStatus.CREATED);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
   @GetMapping
    public List<Categorie> getAllCategories(){
        return this.service.getAllCategory();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        this.service.deleteCategoryById(id);
    }
    
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(path = "/{id}")
    public Categorie getCategoryById(@PathVariable Long id) {
    	return service.getCategoryById(id);
    }
}
