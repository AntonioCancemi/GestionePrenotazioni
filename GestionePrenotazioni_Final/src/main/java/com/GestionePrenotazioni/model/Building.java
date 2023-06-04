package com.GestionePrenotazioni.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buildings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Building {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer building_id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String city;

//	@OneToMany(mappedBy = "building", fetch = FetchType.EAGER)
//	private List<Location> locations;
	@OneToMany(mappedBy = "building", fetch = FetchType.EAGER)
	private List<Location> locations;

	@Override
	public String toString() {
		return "Building [building_id=" + building_id + ", name=" + name + ", address=" + address + ", city=" + city
				+ "]";
	}
}
