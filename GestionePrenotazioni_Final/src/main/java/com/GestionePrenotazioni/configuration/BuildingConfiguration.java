package com.GestionePrenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.model.Building;
import com.github.javafaker.Faker;

@Configuration
public class BuildingConfiguration {

	@Bean("CustomBuilding")
	@Scope("prototype")
	Building customBuilding() {
		return new Building();
	}

	@Bean("FakeBuildingWname")
	@Scope("prototype")
	Building fakeBuilding() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		return new Building().builder().name(fake.university().name()).address(fake.address().streetAddress())
				.city(fake.address().cityName()).build();
	}

}
