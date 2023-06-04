package com.GestionePrenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.enums.LocationType;
import com.GestionePrenotazioni.model.Location;
import com.github.javafaker.Faker;

@Configuration
public class LocationConfiguration {

	@Bean("LocationCustomBean")
	@Scope("prototype")
	Location locationCustom() {
		return new Location();
	}

	@Bean("LocationPolivalenteBean")
	@Scope("prototype")
	Location locationPolivalente() {
		return new Location().builder().description("spazio polivalente per eventi,conferenze ecc.")
				.type(LocationType.OPEN_SPACE).build();
	}

	@Bean("LocationPrivataBean")
	@Scope("prototype")
	Location locationPrivata() {
		return new Location().builder().description("spazio relax").type(LocationType.PRIVATO).build();
	}

	@Bean("LocationSalaComputerBean")
	@Scope("prototype")
	Location locationSalaComputer() {
		return new Location().builder().description("Sala con 30 postazioni pc e una postazione principale")
				.type(LocationType.PRIVATO).build();
	}

	@Bean("LocationSalaRiunioniBean")
	@Scope("prototype")
	Location locationSalaRiunioni() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		return new Location().builder().description("Ampia sala circolare con 50 posti a sedere")
				.type(LocationType.SALA_RIUNIONI).build();
	}

}
