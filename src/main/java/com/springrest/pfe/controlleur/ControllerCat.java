package com.springrest.pfe.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.pfe.model.Category;
import com.springrest.pfe.service.CategoryService;

//@RestController
//@RequestMapping("api/app")
//@CrossOrigin("*")
public class ControllerCat {
	
	@Autowired
	 private CategoryService cat;
	
	
	
	@GetMapping("/category/{name}")
	List<Category> findcat(@PathVariable(name="name")String nom){
		return cat.findByLibelle(nom);	
		}
	@GetMapping("/categories")
	List<Category> findallcat(){
		return cat.findall();	}

}
