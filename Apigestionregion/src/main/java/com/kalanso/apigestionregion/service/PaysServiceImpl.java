package com.kalanso.apigestionregion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalanso.apigestionregion.entites.Pays;
import com.kalanso.apigestionregion.repository.PaysRepository;

@Service
public class PaysServiceImpl implements PaysService {
	
	@Autowired
	PaysRepository paysrepo;

	@Override
	public Pays creerr(Pays pays) {
		// TODO Auto-generated method stub
		return paysrepo.save(pays);
	}

	@Override
	public List<Pays> liree() {
		// TODO Auto-generated method stub
		return paysrepo.findAll();
	}

	@Override
	public Pays modifierr(int idPays, Pays pays) {
		// TODO Auto-generated method stub
		return paysrepo.findById(idPays)
				.map( p->{
				 p.setNomPays(pays.getNomPays());
					
				return paysrepo.save(p);
				 }).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
	}

	@Override
	public String supprimerr(int idPays) {
		// TODO Auto-generated method stub
		paysrepo.deleteById(idPays);
		return "pays supprimer";
	}

	

}
