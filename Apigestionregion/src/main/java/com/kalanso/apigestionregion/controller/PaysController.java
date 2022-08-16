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

import com.kalanso.apigestionregion.entites.Pays;

import com.kalanso.apigestionregion.service.PaysService;

@RestController
@RequestMapping("/pays")
public class PaysController {
	
	@Autowired
	PaysService paysservice;
	
	@PostMapping("/create")
	public Pays create( @RequestBody Pays pays) {
		return paysservice.creerr(pays);
	}
	
	@GetMapping("/read")
	public List<Pays> read() {
		return paysservice.liree();
		
	}
	
	@PutMapping("/update/{idPays}")
	public Pays update(@PathVariable int idPays, @RequestBody Pays pays) {
		return paysservice.modifierr(idPays, pays);
		
	}
	
	@DeleteMapping("/delete/{idPays}")
	public String delete(@PathVariable int idPays ) {
		return paysservice.supprimerr(idPays);
		
	} 
}
