package com.springrest.pfe.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.pfe.model.Category;
import com.springrest.pfe.model.Commentaire;
import com.springrest.pfe.model.Publication;
import com.springrest.pfe.model.User;
import com.springrest.pfe.repository.CategoryRepository;
import com.springrest.pfe.repository.PublicationRepository;
import com.springrest.pfe.repository.UserRepository;
@Service
@Transactional
public class PublicationServiceImpl implements PublicationService {
	@Autowired
	private UserRepository userRepository;
	 @Autowired 
	 private CategoryRepository categoryRepository;
  @Autowired
	private PublicationRepository publicationRepository;
  
	
	@Override
	public Publication accepterpublication(Long id) {
		Publication publicatuionupdate=publicationRepository.findById(id).get();
		publicatuionupdate.setEtat(true);
		return publicationRepository.save(publicatuionupdate);
		
	}

	@Override
	public void supprimerpub(Long id) {
		publicationRepository.deleteById(id);
		
	}

	@Override
	public List<Publication> getpubUser(Long id) {
	 User user=userRepository.findByIdUser(id);
	 List<Publication> listepub=user.getListPublication();
	 return listepub;
	}

	@Override
	public List<Publication> affichage() {
		return publicationRepository.findAll();
	}

	@Override
	public int claculenbrlike(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	@Override
	public int claculenbrcom(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Publication ajouterPublication(Long id,String labelle, Publication pub) {
		Category category=categoryRepository.findByLibelle(labelle);
		User user=userRepository.findByIdUser(id);
         user.getListPublication().add(pub);
          pub.setUser(user);
          category.getPublication().add(pub);
		  pub.setDatepub(new Date());
		return publicationRepository.save(pub);
	}

	@Override
	public Publication modifierPublication(Long id, Publication publica) {
	Publication publication=publicationRepository.findById(id).get();
	publication.setEtat(false);
	publication.setImage(publica.getImage());
	publication.setText(publica.getText());
		return publicationRepository.save(publication);
	}

	@Override
	public List<Publication> PublicationCategory(String nom) {
	 Category category=	categoryRepository.findByLibelle(nom);
	 List<Publication> publications=category.getPublication();
		return publications;
	}

	
	

}
