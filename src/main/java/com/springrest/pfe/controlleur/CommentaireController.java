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

import com.springrest.pfe.model.Commentaire;
import com.springrest.pfe.service.CommentaireService;

@RestController
@RequestMapping("api/app")
@CrossOrigin("*")
public class CommentaireController {
  
	@Autowired 
  private CommentaireService commentaireService;
  @PostMapping("users/{iduser}/publications/{idpub}/commentaire")
  public Commentaire addCommentaireToPublication(@PathVariable(name="iduser") Long iduser,@PathVariable(name="idpub") Long idpub,@RequestBody Commentaire Com) {
  return commentaireService.addCommentaireToPublication(iduser, idpub, Com);
  } 
  @DeleteMapping("/commentaires/supprimer/{id}")
  public void Supprimer(@PathVariable(name = "id") Long id) {
	  commentaireService.delete(id);
  }
	// les commentaires  d'une publication 
  @GetMapping("/commentaires/{id}")
  public List<Commentaire> affichercommentairepub( @PathVariable(name="id") Long id ){
	  return commentaireService.commentairespublication(id);
  }
  @PutMapping("/commentaires/{id}")
  public Commentaire modifiercommentaire(@PathVariable(name="id") Long id,@RequestBody Commentaire Com) {
  return commentaireService.modifierCommentaire(id, Com);
  } 
}
