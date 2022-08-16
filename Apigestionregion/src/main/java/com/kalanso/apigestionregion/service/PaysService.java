package com.kalanso.apigestionregion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kalanso.apigestionregion.entites.Pays;

@Service
public interface PaysService {
	
   Pays creerr(Pays pays);
	
	
	List<Pays> liree();
	
	Pays modifierr (int idPays, Pays pays);
	
	String supprimerr(int idPays);
	

}
