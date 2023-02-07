package com.springrest.pfe.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Commentaire {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idComt;
@Column
private String text;
@Column
private String chemain;
@Column
@Temporal(TemporalType.DATE)
private Date dateCommentaire;

@Column
private int nbrdislike;
@Column
private int nbrlike;
@Column
private int nbrsignal;
//----------CMT---->user
	@ManyToOne
	@JoinColumn(name="ref_iduser")
	@JsonProperty(access = Access.READ_WRITE)
	private User user;
//----------pub--------cmt
@ManyToOne
@JoinColumn(name = "ref_idpub")
@JsonProperty(access = Access.WRITE_ONLY)
private Publication publication;
//-----cmt-----apprcmt
@OneToMany(mappedBy = "listcommentaire",orphanRemoval = true,cascade = {CascadeType.ALL })
@JsonProperty(access = Access.WRITE_ONLY)
private List<AppreciationCommentaire> appreciationCommentaire;

public Commentaire(String text, String chemain, Date dateCommentaire) {
	super();
	this.text = text;
	this.chemain = chemain;
	this.dateCommentaire = dateCommentaire;

}



}
