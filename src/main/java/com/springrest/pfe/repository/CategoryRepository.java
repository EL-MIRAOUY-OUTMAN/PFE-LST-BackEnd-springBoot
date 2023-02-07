package com.springrest.pfe.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.pfe.model.Category;
import com.springrest.pfe.model.Publication;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

	Category findByLibelle(String nom);
  
}
