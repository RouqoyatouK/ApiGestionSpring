package com.kalanso.apigestionregion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalanso.apigestionregion.entites.Annee;
import com.kalanso.apigestionregion.entites.Region;
import com.kalanso.apigestionregion.service.HabitantsService;
import com.kalanso.apigestionregion.service.RegionService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping( "/region")
@AllArgsConstructor
public class RegionController {
	
	@Autowired
	RegionService  regionService;
	
	@Autowired
	HabitantsService  anneeService;
//	
//	@PostMapping("/create")
//	public Region create( @RequestBody Region  region) {
//		System.out.println(region.getPays());
//		return regionService.creer(region);
//	}
	

	
	//création d'une D'une region par rapport à une annee
    @PostMapping("/{idAnnee}/create")
    public String CreerRegionAnnee(@PathVariable(value = "idAnnee") int id,
            @RequestBody Region region) {
        Annee annee =  anneeService.getAnneeByid(id);
        System.out.println(annee);

        if (annee != null) {
            region.getAnneeRegion().add(annee);
            annee.getRegionAnnee().add(region);
            regionService.creer(region);
            anneeService.creer(annee);
            return "Population ajoutée avec succes";

        } else {
            return "Cette region n'existe pas!";

        }

    }
	
	@GetMapping("/read")
	public List<Region> read() {
		return regionService.lire();
		
	}

	@PutMapping("/update/{id}")
	public Region update(@PathVariable int id, @RequestBody Region region) {
		return regionService.modifier(id, region);
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id ) {
		return regionService.supprimer(id);
		
	} 
	
	//la liste de la region sans pays
	@GetMapping("/sansPays")
	public List<Object[]> Lire() {
		return regionService.ReadWithoutPays();
		
	}
	
	
}
