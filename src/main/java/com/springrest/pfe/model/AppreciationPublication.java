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
public class AppreciationPublication {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idApp;
@Column
private String type;
//    ---------apppub--------->-publ
@ManyToOne
@JoinColumn(name = "ref_idpub")
@JsonProperty(access = Access.WRITE_ONLY)
private Publication publication;

//-------appub------user
@ManyToOne
@JoinColumn(name = "ref_iduser")
@JsonProperty(access = Access.WRITE_ONLY)
private User user;


}
