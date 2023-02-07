package com.springrest.pfe.service;



import java.util.List;

import com.springrest.pfe.model.Commentaire;
import com.springrest.pfe.model.Publication;


public interface CommentaireService {
    public void delete(Long id);
    Commentaire addCommentaireToPublication(Long iduser,Long idpub,Commentaire commentaire);
    List<Commentaire> findall();
    Commentaire modifierCommentaire(Long id, Commentaire comm);
    List<Commentaire> commentairespublication(Long id);
}
