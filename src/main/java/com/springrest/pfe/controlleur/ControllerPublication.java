package com.springrest.pfe.controlleur;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.pfe.model.Publication;

import com.springrest.pfe.service.PublicationService;


@RestController
@RequestMapping("api/app")
@CrossOrigin("*")
public class ControllerPublication {
	
	@Autowired
	private PublicationService pub;
	
	//------------------------------control publication------------
	@GetMapping("/publications")
	public List<Publication> getall(){
		return pub.affichage();
	}
	// publication of user 
	@GetMapping("/publications/{id}")
	public List<Publication> getpublication(@PathVariable(name="id") Long id){
		return pub.getpubUser(id);
	}
	
	// add pub to category par un utulisateur
	@PostMapping("/users/{iduser}/{labelle}/publication")
	public Publication ajouterPublication(@PathVariable(name="iduser") Long id,@PathVariable(name="labelle") String labelle, @RequestBody Publication p){
		return pub.ajouterPublication(id,labelle,p);
	}
	
	@PutMapping("/publications/{id}")
	public Publication modifier(@PathVariable(name = "id") Long id,@RequestBody Publication p){
		return pub.modifierPublication(id, p);
				
	}
	
	@DeleteMapping("/publications/supprimer/{id}")
	public void delete(@PathVariable(name = "id") Long id){
	pub.supprimerpub(id);
	}

	@PutMapping("/publications/accepter/{id}")
	public boolean accepter(@PathVariable(name="id")Long id) {
		pub.accepterpublication(id);
		return true;
	}
	@GetMapping("/publications/filter/{name}")
	public List<Publication> catpublication(@PathVariable(name="name") String name){
		return pub.PublicationCategory(name);
	}
	
}
