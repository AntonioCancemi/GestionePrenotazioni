package com.GestionePrenotazioni.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.model.User;
import com.GestionePrenotazioni.service.UserService;

@Component
public class UserRunner implements ApplicationRunner {
	static Logger log = LoggerFactory.getLogger(UserRunner.class);

	@Autowired
	private UserService userService;

	@Value("${runner.print}")
	private String rp;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("\n*****UserRunner*****");
		start();

	}

	public void start() {
		if (userService.getAll().isEmpty()) {
			System.out.println("La lista degli user è vuota la sto riempendo");

			User u1 = userService.createAdimUser();
			userService.insertUser(u1);
			for (int i = 0; i < 3; i++) {
				User u2 = userService.createFakeUser();
				userService.insertUser(u2);
			}
		} else {
			System.err.println(userService.getAll().size());
			if (rp == "yes") {
				userService.getAll().forEach(e -> System.out.println(e));
			}
		}
		System.out.println("______________________________________________________________________");
	}

}
