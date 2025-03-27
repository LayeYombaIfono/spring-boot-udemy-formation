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
@RequestMapping(path = "/products/categories")
@CrossOrigin
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
   @RequestMapping(method = RequestMethod.GET)
    public List<Categorie> getAllCategories(){
        return this.service.getAllCategory();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteCategoryById(Long id){
        this.service.deleteCategoryById(id);
    }
}
