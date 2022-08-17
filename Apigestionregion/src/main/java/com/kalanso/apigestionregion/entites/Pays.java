package com.kalanso.apigestionregion.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Table(name="pays")
@Entity

public class Pays {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPays;
	
	@Column(length = 50,  unique =true)
    private String nomPays;
    
    @OneToMany(mappedBy = "pays")
    private List<Region> regions;
    
    
	public List<Region> getRegions() {
		return regions;
	}
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
	public Pays(int idPays, String nomPays) {
		super();
		this.idPays = idPays;
		this.nomPays = nomPays;
	}
	public Pays() {
		super();
	}
	public int getIdPays() {
		return idPays;
	}
	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	


}
