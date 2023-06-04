package com.GestionePrenotazioni.model;

import org.hibernate.Hibernate;

import com.GestionePrenotazioni.enums.LocationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer location_id;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private LocationType type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	private Building building;

	@Override
	public String toString() {
		Hibernate.initialize(building); // Inizializza il proxy del building
		return "Location [location_id=" + location_id + ", description=" + description + ", type=" + type + ", city="
				+ building.getCity() + "]";
	}
}
