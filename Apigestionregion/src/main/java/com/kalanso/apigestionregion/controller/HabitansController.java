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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/habitans")
@AllArgsConstructor
@Api(value = "hello", description = "Sample hello world application")

public class HabitansController {

	@Autowired
	HabitantsService habitantsservice;
	
	
	@ApiOperation(value = "My App Service get test1 API")
	@PostMapping("/create")
	public Annee create( @RequestBody Annee  habitants) {
		return habitantsservice.creer(habitants);
	}
	
	
	@ApiOperation(value = "My App Service get test1 API")
	@GetMapping("/read")
	public List<Annee> read() {
		return habitantsservice.lire();
}

	
	@ApiOperation(value = "My App Service get test1 API")
    @PutMapping("/update/{id}")
	public Annee update(@PathVariable int id, @RequestBody Annee habitants) {
		return habitantsservice.modifier(id, habitants);
		
	}
//@DeleteMapping("/delete/{id}")
//public String delete(@PathVariable int id ) {
//	return habitantsservice.supprimer(id);
//	
//} 

	@ApiOperation(value = "My App Service get test1 API")
   @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id ) {
	 this.habitantsservice.supprimer(id);
	 return "supprimer";
	
} 
}
