package com.kalanso.apigestionregion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kalanso.apigestionregion.entites.Annee;

public interface HabitantsRepository extends JpaRepository<Annee, Integer> {

}
