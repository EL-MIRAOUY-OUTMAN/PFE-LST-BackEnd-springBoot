package com.springrest.pfe.service;

import java.util.List;

import com.springrest.pfe.model.Category;
import com.springrest.pfe.model.Publication;

public interface PublicationService {

 
  Publication ajouterPublication(Long id,String labelle,Publication pub); 
  void supprimerpub(Long id);
  List<Publication> getpubUser(Long id);
  List<Publication> affichage();
  int claculenbrlike(Long id);
  int claculenbrcom(Long id);
  Publication accepterpublication(Long id );
   Publication modifierPublication(Long id, Publication pub);
  List<Publication> PublicationCategory(String nom);
  
  
}
