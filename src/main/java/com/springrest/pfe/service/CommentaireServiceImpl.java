package com.springrest.pfe.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.pfe.model.Commentaire;
import com.springrest.pfe.model.Publication;
import com.springrest.pfe.model.User;
import com.springrest.pfe.repository.CommentaireRepository;
import com.springrest.pfe.repository.PublicationRepository;
import com.springrest.pfe.repository.UserRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	@Autowired
	private PublicationRepository publicationRepository;
    @Autowired
    private CommentaireRepository commentaireRepository;
     @Autowired
    private UserRepository userRepository;
	@Override
	public void delete(Long id) {
		commentaireRepository.deleteById(id);
	}


	

	@Override
	public List<Commentaire> findall() {
		return commentaireRepository.findAll();
	}




	@Override
	public Commentaire addCommentaireToPublication(Long iduser,Long idpub, Commentaire commentaire) {
		Publication pub=publicationRepository.findById(idpub).get();
		commentaire.setPublication(pub);
		commentaire.setDateCommentaire(new Date());
		commentaire.setNbrlike(0);
		commentaire.setNbrdislike(0);
		commentaire.setNbrsignal(0);
		User user=userRepository.findByIdUser(iduser);
		commentaire.setUser(user);
		pub.getCommentaire().add(commentaire);
		user.getListCommentaire().add(commentaire);
		
		return commentaireRepository.save(commentaire);
		
	}




	@Override
	public Commentaire modifierCommentaire(Long id, Commentaire comm) {
		Commentaire commentaire=commentaireRepository.findById(id).get();
		commentaire.setChemain(comm.getChemain());
		commentaire.setText(comm.getText());
			return commentaireRepository.save(commentaire);
		}




	@Override
	public List<Commentaire> commentairespublication(Long id) {
		Publication publication=publicationRepository.findByIdpub(id);
		List<Commentaire> commeantaires=publication.getCommentaire();
		return commeantaires;
	}
}
