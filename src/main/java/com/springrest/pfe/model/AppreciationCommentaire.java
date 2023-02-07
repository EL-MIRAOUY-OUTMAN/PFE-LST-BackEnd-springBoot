package com.springrest.pfe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @NoArgsConstructor @AllArgsConstructor 
public class AppreciationCommentaire {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idApp;
@Column
private String type;
//------user-----appcmt
@ManyToOne
@JoinColumn(name = "iduser_ref")
@JsonProperty(access = Access.WRITE_ONLY)
private User user;
//-------cmt---------appcmt
@ManyToOne
@JoinColumn(name = "ref_idcmt")
@JsonProperty(access = Access.WRITE_ONLY)
private Commentaire listcommentaire;

}
