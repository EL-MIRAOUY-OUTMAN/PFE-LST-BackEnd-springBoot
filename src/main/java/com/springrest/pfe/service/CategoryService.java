package com.springrest.pfe.service;



import java.util.List;

import com.springrest.pfe.model.Category;


public interface CategoryService {
 List<Category> findByLibelle(String nom);
 
    List<Category> findall();
}
