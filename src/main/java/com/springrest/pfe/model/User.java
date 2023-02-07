package com.springrest.pfe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idUser;
@Column
private String nom;
@Column
private String prenom;
@Column
private String email;
@Column
private String pseudo;
@Column
private String role;
@Column
private String image;
@Column
private String login;
@Column
private String password;
//---------user------apppub
@OneToMany(mappedBy = "user",orphanRemoval = true,cascade = {CascadeType.ALL })
private List<AppreciationPublication> appreciationPublication;

//--------user------appcmt
@OneToMany(mappedBy = "user",orphanRemoval = true,cascade = {CascadeType.ALL })
private List<AppreciationCommentaire> appreciationCommentaire;

//------------user----->----pub
@OneToMany(mappedBy = "user",orphanRemoval = true,cascade = {CascadeType.MERGE
		,CascadeType.REFRESH})
@JsonProperty(access = Access.WRITE_ONLY)
private List<Publication> listPublication;
@OneToMany(mappedBy = "user",orphanRemoval = true,cascade = {CascadeType.ALL })
@JsonProperty(access = Access.WRITE_ONLY)
private List<Commentaire> listCommentaire;

}
