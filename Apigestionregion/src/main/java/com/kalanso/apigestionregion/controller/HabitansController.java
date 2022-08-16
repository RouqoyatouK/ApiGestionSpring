package com.kalanso.apigestionregion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalanso.apigestionregion.entites.Annee;
import com.kalanso.apigestionregion.service.HabitantsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/habitans")
@AllArgsConstructor
public class HabitansController {

	@Autowired
	HabitantsService habitantsservice;
	
	@PostMapping("/create")
	public Annee create( @RequestBody Annee  habitants) {
		return habitantsservice.creer(habitants);
	}
	
	@GetMapping("/read")
	public List<Annee> read() {
		return habitantsservice.lire();
}

@PutMapping("/update/{id}")
	public Annee update(@PathVariable int id, @RequestBody Annee habitants) {
		return habitantsservice.modifier(id, habitants);
		
	}
//@DeleteMapping("/delete/{id}")
//public String delete(@PathVariable int id ) {
//	return habitantsservice.supprimer(id);
//	
//} 

@DeleteMapping("/delete/{id}")
public String delete(@PathVariable int id ) {
	 this.habitantsservice.supprimer(id);
	 return"supprimer";
	
} 
}
