package com.GestionePrenotazioni.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.model.Building;
import com.GestionePrenotazioni.service.BuildingService;

@Component
public class BuildingRunner implements ApplicationRunner {
	static Logger log = LoggerFactory.getLogger(BuildingRunner.class);
	@Autowired
	private BuildingService buildingService;

	@Value("${runner.print}")
	private String rp;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("\n*****BuildingRunner*****");

		start();

	}

	public void start() {
		if (buildingService.getAll().isEmpty()) {
			System.out.println("La lista degli edifici è vuota la sto riempendo");

			for (int i = 0; i < 3; i++) {
				Building b3 = buildingService.createFakeBuilding();
				b3.setCity("Roma");
				Building b4 = buildingService.createFakeBuilding();
				b4.setCity("Napoli");
				Building b5 = buildingService.createFakeBuilding();
				b5.setCity("Torino");
				Building b6 = buildingService.createFakeBuilding();
				b6.setCity("Napoli");

				buildingService.insertBuilding(b3);
				buildingService.insertBuilding(b4);
				buildingService.insertBuilding(b5);
				buildingService.insertBuilding(b6);

			}
		} else {
			System.err.println(buildingService.getAll().size());
			if (rp == "yes") {
				buildingService.getAll().forEach(e -> System.out.println(e.toString()));
			}
		}
		System.out.println("______________________________________________________________________");
	}

	public void custom(String address, String city, String name) {
		Building b2 = buildingService.createCustomBuilding();
		b2.setAddress(address);
		b2.setCity(city);
		b2.setName(name);

	}

}
