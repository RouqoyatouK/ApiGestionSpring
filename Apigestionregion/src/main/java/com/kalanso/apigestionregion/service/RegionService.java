package com.kalanso.apigestionregion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kalanso.apigestionregion.entites.Region;

@Service
public interface RegionService {
	
	Region creer(Region region);
	
	
	List<Region> lire();
	
	Region modifier (int id, Region region);
	
	String supprimer(int id);
	
	String Jointure (Region regionannee);
	
	//afficher region sans pays
	
	List<Object[]> ReadWithoutPays();

}
