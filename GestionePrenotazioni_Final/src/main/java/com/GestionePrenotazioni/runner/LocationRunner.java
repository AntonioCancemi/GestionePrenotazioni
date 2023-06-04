package com.GestionePrenotazioni.runner;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.model.Building;
import com.GestionePrenotazioni.model.Location;
import com.GestionePrenotazioni.service.BuildingService;
import com.GestionePrenotazioni.service.LocationService;

@Component
public class LocationRunner implements CommandLineRunner {
	@Autowired
	private LocationService locationService;

	@Autowired
	private BuildingService buildingService;

	@Value("${runner.print}")
	private String rp;

	static Logger log = LoggerFactory.getLogger(LocationRunner.class);

	@Override
	public void run(String... args) throws Exception {
		log.info("\n*****LocationRunner*****");
		start();
	}

	public void start() {
		List<Building> listBuildings = buildingService.getAll();
		if (locationService.getAll().isEmpty()) {
			System.out.println("La lista delle locatio è vuota la sto riempendo");
			for (int i = 0; i < 3; i++) {
				Random random = new Random();
				Location l1 = locationService.createPolivaleteLocation();
				Location l2 = locationService.createPrivataLocation();
				Location l3 = locationService.createSalaComputerLocation();
				Location l4 = locationService.createSalaRiunioniLocation();
				l1.setBuilding(listBuildings.get(random.nextInt(listBuildings.size())));
				l2.setBuilding(listBuildings.get(random.nextInt(listBuildings.size())));
				l3.setBuilding(listBuildings.get(random.nextInt(listBuildings.size())));
				l4.setBuilding(listBuildings.get(random.nextInt(listBuildings.size())));
				locationService.insertLocation(l1);
				locationService.insertLocation(l2);
				locationService.insertLocation(l3);
				locationService.insertLocation(l4);

			}
		} else {
			System.err.println(locationService.getAll().size());
			if (rp == "yes") {
				locationService.getAll().forEach(e -> System.out.println(e.toString()));
			}
			// locationService.getAllByBuildingCity("Roma").forEach(e ->
			// System.out.println(e));
			// locationService.getByType(LocationType.PRIVATO).forEach(e ->
			// System.out.println(e));
		}

		System.out.println("______________________________________________________________________");
	}

}
