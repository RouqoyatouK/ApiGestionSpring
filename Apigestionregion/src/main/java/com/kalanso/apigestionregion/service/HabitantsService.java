package com.kalanso.apigestionregion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kalanso.apigestionregion.entites.Annee;


@Service
public interface HabitantsService {
	
	Annee creer(Annee habitants);
	
	List<Annee> lire();
	String supprimer(int id);

	Annee modifier(int id, Annee habitants);
	
	//jointure
	

	Annee getAnneeByid(int id);

	void updateRegion(Annee annee);

	
	
	
	

}
