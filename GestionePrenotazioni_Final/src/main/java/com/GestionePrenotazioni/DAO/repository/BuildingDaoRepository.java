package com.GestionePrenotazioni.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.model.Building;

@Repository
public interface BuildingDaoRepository extends JpaRepository<Building, Integer> {

}
