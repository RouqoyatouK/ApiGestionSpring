package com.kalanso.apigestionregion.entites;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;






@Table(name="region")
@Entity

public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String coderegion;
	private String nom ;
	private String domaine_activite ;
	private String superficie ;
	private String nbHabitant;
	private String langue;
	
	@ManyToOne
	private Pays pays;
	
//	@OneToMany(mappedBy = "region")
//	private Set<AnneeRegion> anneeRegion;
	
	@ManyToMany
	@JoinTable(
			  name = "Annee_Region", 
			  joinColumns = @JoinColumn(name = "region_id"),
			  inverseJoinColumns = @JoinColumn(name = "annee_id"))
	private List<Annee> anneeRegion=new ArrayList<>();
	
	
	public List<Annee> getAnneeRegion() {
		return anneeRegion;
	}
	public void setAnneeRegion(List<Annee> anneeRegion) {
		this.anneeRegion = anneeRegion;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoderegion() {
		return coderegion;
	}
	public void setCoderegion(String coderegion) {
		this.coderegion = coderegion;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDomaine_activite() {
		return domaine_activite;
	}
	public void setDomaine_activite(String domaine_activite) {
		this.domaine_activite = domaine_activite;
	}
	public String getSuperficie() {
		return superficie;
	}
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	public String getNbHabitant() {
		return nbHabitant;
	}
	public void setNbHabitant(String nbHabitant) {
		this.nbHabitant = nbHabitant;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public Region(int id, String coderegion, String nom, String domaine_activite, String superficie, String nbHabitant,
			String langue) {
		super();
		this.id = id;
		this.coderegion = coderegion;
		this.nom = nom;
		this.domaine_activite = domaine_activite;
		this.superficie = superficie;
		this.nbHabitant = nbHabitant;
		this.langue = langue;
	}
	public Region() {
		super();
	}
	
	
	
	
	
}
