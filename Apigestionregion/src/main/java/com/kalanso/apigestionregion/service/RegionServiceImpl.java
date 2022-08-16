package com.kalanso.apigestionregion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalanso.apigestionregion.entites.Region;
import com.kalanso.apigestionregion.repository.RegionRepository;


@Service
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	RegionRepository regionrepo;
	


	@Override
	public Region creer(Region region) {
		// TODO Auto-generated method stub
		return regionrepo.save(region);
	}

	@Override
	public List<Region> lire(){
		// TODO Auto-generated method stub
		return regionrepo.findAll();
	}

	@Override
	public Region modifier(int id, Region region) {
		// TODO Auto-generated method stub
		return regionrepo.findById(id)
				.map( r->{
					r.setCoderegion(region.getCoderegion());
					r.setNom(region.getNom());
                    r.setDomaine_activite(region.getDomaine_activite());
					r.setSuperficie(region.getSuperficie());
					r.setLangue(region.getLangue());
					r.setNbHabitant(region.getNbHabitant());
					return regionrepo.save(r);
				  }).orElseThrow(() -> new RuntimeException("produit non trouvé"));
	}

	@Override
	public String supprimer(int id) {
		// TODO Auto-generated method stub
		regionrepo.deleteById(id);
		return "region supprimer";
	}

	@Override
	public String Jointure(Region regionannee) {
		// TODO Auto-generated method stub
		return null;
	}
//Afficher sans pays
	@Override
	public List<Object[]> ReadWithoutPays() {
		// TODO Auto-generated method stub
		return  regionrepo.FindRegionWithoutPays();
	}
	

}
