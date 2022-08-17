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
import com.kalanso.apigestionregion.entites.Region;
import com.kalanso.apigestionregion.service.HabitantsService;
import com.kalanso.apigestionregion.service.RegionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping( "/region")
@AllArgsConstructor

@Api(value = "hello", description = "Region")
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
	@ApiOperation(value = "My App Service get test1 API")
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
	
	@ApiOperation(value = "My App Service get test1 API")
	@GetMapping("/read")
	public List<Region> read() {
		return regionService.lire();
		
	}

	@ApiOperation(value = "My App Service get test1 API")
	@PutMapping("/update/{id}")
	public Region update(@PathVariable int id, @RequestBody Region region) {
		return regionService.modifier(id, region);
		
	}
	
	@ApiOperation(value = "My App Service get test1 API")
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id ) {
		return regionService.supprimer(id);
		
	} 
	
	//la liste de la region sans pays
	
	@ApiOperation(value = "My App Service get test1 API")
	@GetMapping("/sansPays")
	public List<Object[]> Lire() {
		return regionService.ReadWithoutPays();
		
	}
	
	
}
