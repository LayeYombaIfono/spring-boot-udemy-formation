package com.hamilatech.backend.service;

import com.hamilatech.backend.entities.Categorie;

import java.util.List;

public interface CategoryService {
    Categorie addCategory(Categorie categorie);

    List<Categorie> getAllCategory();

    void deleteCategoryById(Long id);
}
