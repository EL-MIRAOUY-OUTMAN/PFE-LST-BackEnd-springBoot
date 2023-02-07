package com.springrest.pfe;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springrest.pfe.model.Commentaire;
import com.springrest.pfe.model.Publication;
import com.springrest.pfe.repository.CommentaireRepository;
import com.springrest.pfe.repository.PublicationRepository;
import com.springrest.pfe.service.CommentaireService;

@SpringBootTest
class AtmanApplicationTests {
	
	
	/*
	@Autowired
	private PublicationRepository pub;
   
	@Test
	public void testinsert() {
	Publication p=new Publication("recommende", "chemain7", new Date(), 123,123,123, true);
	pub.save(p);
	Publication p1=new Publication("teste", "chemain8", new Date(), 123,123,12, false);
	pub.save(p1);
	Publication p2=new Publication("recommende", "chemain9", new Date(), 123,123,1, true);
	pub.save(p2);
	Publication p3=new Publication("teste", "chemain10", new Date(), 123,123,15, false);
	pub.save(p3);
	Publication p4=new Publication("recommende", "chemain11", new Date(), 13,123,123, true);
	pub.save(p4);

	Publication p5=new Publication("recommende", "chemain12", new Date(), 13,13,123, true);
	pub.save(p5);
	}
	 
	@Test
	public void testfind() {
	Publication p=pub.findById(1L).get();	
	System.out.println(p);
	}
	@Test
	public void testupdate() {
		
		Publication p=pub.findById(1L).get();
		p.setNbrlike(100);
		pub.save(p);
	}
	@Test
	public void testdelete() {
		
		pub.deleteById(4L);
		
	}
	
	@Test
	public void testfindall() {
	List<Publication> pl=pub.findAll();	
	for(Publication p:pl) {
	System.out.println(p);}
	}

	@Autowired
	private CommentaireService commentaireservice;
	@Test
	public void ajoutercommentaire() {
		Commentaire com=new Commentaire("text commentaire","c.png", new Date());
		commentaireservice.addCommentaireToPublication(2L, com);
	}
	*/

}
