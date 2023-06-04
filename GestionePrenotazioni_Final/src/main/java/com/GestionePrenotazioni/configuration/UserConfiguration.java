package com.GestionePrenotazioni.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.model.User;
import com.github.javafaker.Faker;

@Configuration
public class UserConfiguration {

	@Value("${user.admin.completename}")
	private String completename;
	@Value("${user.admin.username}")
	private String username;
	@Value("${user.admin.email}")
	private String email;

	@Bean("AdminUserBean")
	@Scope("singleton")
	User adminUser() {
		return new User(username, completename, email);
	}

	@Bean("CustomUserBean")
	@Scope("prototype")
	User customUser() {
		return new User();
	}

	@Bean("FakeUserBean")
	@Scope("prototype")
	User fakeUser() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		User userFake = new User();
		userFake.setUsername(fake.name().username());
		userFake.setCompletename(fake.name().firstName() + " " + fake.name().lastName());
		userFake.setEmail(userFake.getUsername() + "@alibabba.com");
		return userFake;
	}

}
