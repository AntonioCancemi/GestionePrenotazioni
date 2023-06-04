package com.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.DAO.repository.LocationDaoRepository;
import com.GestionePrenotazioni.enums.LocationType;
import com.GestionePrenotazioni.model.Location;

@Service
public class LocationService {
	@Autowired
	LocationDaoRepository db;
	@Autowired
	@Qualifier("LocationCustomBean")
	ObjectProvider<Location> createLocationCustomProvider;
	@Autowired
	@Qualifier("LocationPolivalenteBean")
	ObjectProvider<Location> createLocationPolivalenteProvider;
	@Autowired
	@Qualifier("LocationPrivataBean")
	ObjectProvider<Location> createLocationPrivataProvider;
	@Autowired
	@Qualifier("LocationSalaComputerBean")
	ObjectProvider<Location> createLocationSalaComputerProvider;
	@Autowired
	@Qualifier("LocationSalaRiunioniBean")
	ObjectProvider<Location> createLocationSalaRiunioniProvider;

	public Location createCustomLocation() {
		return createLocationCustomProvider.getObject();
	}

	public Location createPolivaleteLocation() {
		return createLocationPolivalenteProvider.getObject();
	}

	public Location createPrivataLocation() {
		return createLocationPrivataProvider.getObject();
	}

	public Location createSalaComputerLocation() {
		return createLocationSalaComputerProvider.getObject();
	}

	public Location createSalaRiunioniLocation() {
		return createLocationSalaRiunioniProvider.getObject();
	}

	// CRUD
	public void insertLocation(Location l) {
		db.save(l);
		System.out.println("Building " + l.getDescription() + ", " + l.getType() + " inserito nel DB!!!");

	}

	public void updateLocation(Location l) {
		db.save(l);
		System.out.println("Building " + l.getDescription() + ", " + l.getType() + " modificato nel DB!!!");

	}

	public void deleteLocation(Location l) {
		db.delete(l);
		System.out.println("Building " + l.getDescription() + ", " + l.getType() + " cancellato dal DB!!!");

	}

	public List<Location> getAll() {
		return db.findAll();
	}

	public List<Location> getAllByBuildingCity(String city) {
		return db.findAllByBuildingCity(city);

	}

	public List<Location> getByType(LocationType type) {
		return db.findByType(type);
	}
}
