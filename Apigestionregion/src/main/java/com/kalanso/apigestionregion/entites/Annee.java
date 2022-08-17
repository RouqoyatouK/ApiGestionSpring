package com.kalanso.apigestionregion.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;




@Table(name="annee")
@Entity
public class Annee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAnnee;  
	
	@Column(length = 50,  unique =true)
	private Date dateannee;
	
//	@OneToMany(mappedBy = "annee")
// 
//	private Set<AnneeRegion> anneeRegion;
	
	 @ManyToMany(mappedBy = "anneeRegion")
	  private  List<Region> regionAnnee=new ArrayList<>();

	public int getIdAnnee() {
		return idAnnee;
	}

	public void setIdAnnee(int idAnnee) {
		this.idAnnee = idAnnee;
	}

	public Date getDateannee() {
		return dateannee;
	}

	public void setDateannee(Date dateannee) {
		this.dateannee = dateannee;
	}

	public List<Region> getRegionAnnee() {
		return regionAnnee;
	}

	public void setRegionAnnee(List<Region> regionAnnee) {
		this.regionAnnee = regionAnnee;
	}

	public Annee(int idAnnee, Date dateannee, List<Region> regionAnnee) {
		super();
		this.idAnnee = idAnnee;
		this.dateannee = dateannee;
		this.regionAnnee = regionAnnee;
	}

	public Annee() {
		super();
	}

	
	

	
	
	
	
	
	
	
		
	
	
}
