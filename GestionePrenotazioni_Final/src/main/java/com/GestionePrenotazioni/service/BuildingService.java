package com.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.DAO.repository.BuildingDaoRepository;
import com.GestionePrenotazioni.model.Building;

@Service
public class BuildingService {
	@Autowired
	BuildingDaoRepository db;

	@Autowired
	@Qualifier("CustomBuilding")
	ObjectProvider<Building> buildingCustomProvider;

	@Autowired
	@Qualifier("FakeBuildingWname")
	ObjectProvider<Building> buildingFakeProvider;

	public Building createCustomBuilding() {
		return buildingCustomProvider.getObject();
	}

	public Building createFakeBuilding() {
		return buildingFakeProvider.getObject();
	}

	// CRUD
	public void insertBuilding(Building b) {
		db.save(b);
		System.out.println("Building " + b.getName() + ", " + b.getAddress() + " inserito nel DB!!!");

	}

	public void updateBuilding(Building b) {
		db.save(b);
		System.out.println("Building " + b.getName() + ", " + b.getAddress() + " modificato nel DB!!!");

	}

	public void deleteBuilding(Building b) {
		db.delete(b);
		System.out.println("Building " + b.getName() + ", " + b.getAddress() + " cancellato nel DB!!!");

	}

	public List<Building> getAll() {
		return db.findAll();
	}
}
