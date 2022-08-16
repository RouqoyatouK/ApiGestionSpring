package com.kalanso.apigestionregion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalanso.apigestionregion.entites.Annee;
import com.kalanso.apigestionregion.repository.HabitantsRepository;

@Service
public class HabitantsServiceImpl implements HabitantsService {
	
	@Autowired
	HabitantsRepository habitansrepo;

	@Override
	public Annee creer(Annee habitants) {
		// TODO Auto-generated method stub
		return habitansrepo.save(habitants);
	}

	@Override
	public List<Annee> lire() {
		// TODO Auto-generated method stub
		return habitansrepo.findAll() ;
	}

	@Override
	public Annee modifier(int id, Annee habitants) {
		// TODO Auto-generated method stub
		return habitansrepo.findById(id)
				.map( h->{
					h.setDateannee(habitants.getDateannee());
					
					return habitansrepo.save(h);
				  }).orElseThrow(() -> new RuntimeException("Habitants non trouvé"));
	}

	@Override
	public String supprimer(int id) {
		// TODO Auto-generated method stub
		this.habitansrepo.deleteById(id);
		return "supppppp";
		
	}

	@Override
	public Annee getAnneeByid(int id) {
		// TODO Auto-generated method stub
		return habitansrepo.getReferenceById(id);
	}

	@Override
	public void updateRegion(Annee annee) {
		// TODO Auto-generated method stub
		
	}


}
