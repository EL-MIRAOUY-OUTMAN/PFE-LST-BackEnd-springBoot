package com.springrest.pfe.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idpub;
	@Column
private String type;
	@Column
	private String image;
	@Column(length =1000)
	private String text;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date datepub;
	@Column
	private int nbrdislike;
	@Column
	private int nbrlike;
	@Column
	private int nbrcom;
	@Column
	private int nbrsignal;
	@Column
	private boolean etat;
	
	//---------------pub------>cat
	
	@ManyToOne
	@JoinColumn(name="ref_idcat")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Category cat;
	
	//----------pub---->user
	@ManyToOne
	@JoinColumn(name="ref_iduser")
	@JsonProperty(access = Access.READ_WRITE)
	private User user;
	
	//----------apppubl----->---publ
	
@OneToMany(mappedBy = "publication",cascade = {CascadeType.MERGE})
	private List<AppreciationPublication> appreciationPublication;

//-------pub---------cmt

@OneToMany(mappedBy = "publication",cascade = {CascadeType.MERGE
		,CascadeType.REFRESH})
private List<Commentaire> commentaire;

	
	
	
}
