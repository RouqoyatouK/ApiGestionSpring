package com.kalanso.apigestionregion.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kalanso.apigestionregion.entites.Region;


@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
	

	@Query(value= "select id, coderegion, nom , domaine_activite , superficie , nb_habitant, langue from region", nativeQuery = true)
	List<Object[]> FindRegionWithoutPays();
	 

}
