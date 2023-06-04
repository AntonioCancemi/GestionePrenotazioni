package com.GestionePrenotazioni.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.enums.LocationType;
import com.GestionePrenotazioni.model.Location;

@Repository
public interface LocationDaoRepository extends JpaRepository<Location, Integer> {
	List<Location> findAllByBuildingCity(String city);

	List<Location> findByType(LocationType type);
}
