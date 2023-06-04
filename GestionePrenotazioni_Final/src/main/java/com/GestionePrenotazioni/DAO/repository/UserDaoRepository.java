package com.GestionePrenotazioni.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.model.User;

@Repository
public interface UserDaoRepository extends JpaRepository<User, String> {
	@Query("SELECT u FROM User u WHERE u.username > :username")
	public User findUserGTusername(String username);
}
