package com.springrest.pfe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.pfe.model.Category;
import com.springrest.pfe.model.Publication;
import com.springrest.pfe.repository.CategoryRepository;
import com.springrest.pfe.repository.PublicationRepository;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
    PublicationRepository publicationRepository; 
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findByLibelle(String nom) {
 return (List<Category>) categoryRepository.findByLibelle(nom);
	
	}
	@Override
	public List<Category> findall() {
 return categoryRepository.findAll();
	
	}


}
