package com.springrest.pfe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cat")
	private int idCat;
	@Column
	private String libelle;
	public Category(int id_cat, String libelle) {
		super();
		this.idCat = id_cat;
		this.libelle = libelle;
	}
	// category --------pub
	@OneToMany(mappedBy = "cat",orphanRemoval = true,cascade = {CascadeType.MERGE })
	private  List<Publication> publication;
	
	

}
