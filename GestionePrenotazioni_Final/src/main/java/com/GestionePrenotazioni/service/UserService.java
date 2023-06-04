package com.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.DAO.repository.UserDaoRepository;
import com.GestionePrenotazioni.model.User;

@Service
public class UserService {
	@Autowired
	UserDaoRepository db;
	@Autowired
	@Qualifier("AdminUserBean")
	ObjectProvider<User> userAdminProvider;
	@Autowired
	@Qualifier("CustomUserBean")
	ObjectProvider<User> userCustomProvider;
	@Autowired
	@Qualifier("FakeUserBean")
	ObjectProvider<User> userFakeProvider;

	public User createFakeUser() {
		return userFakeProvider.getObject();
	}

	public User createAdimUser() {
		return userAdminProvider.getObject();
	}

	public User createCustomUser() {
		return userCustomProvider.getObject();
	}

	// CRUD
	public void insertUser(User u) {
		db.save(u);
		System.out.println("User " + u.getUsername() + " inserito nel DB!!!");

	}

	public void updateUser(User u) {
		db.save(u);
		System.out.println("User " + u.getUsername() + " aggiornato nel DB!!!");

	}

	public void deleteUser(User u) {
		db.delete(u);
		System.out.println("User " + u.getUsername() + " eliminato dal DB!!!");

	}

	public List<User> getAll() {
		return db.findAll();
	}

	// find custom
	public User getByID(String username) {
		return db.findUserGTusername(username);
	}
}
