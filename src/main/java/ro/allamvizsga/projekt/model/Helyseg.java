package ro.allamvizsga.projekt.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Helyseg")
public class Helyseg {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FAJTA")
	@SequenceGenerator(sequenceName = "FAJTASEQ", name = "FAJTA", allocationSize = 1)
	private Long id;
	
	@Column(name="Helyseg")
	private String helysegNev;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="latitude")
	private String latitude;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Hirdetesek> hirdetesek;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHelysegNev() {
		return helysegNev;
	}

	public void setHelysegNev(String helysegNev) {
		this.helysegNev = helysegNev;
	}

	

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Set<Hirdetesek> getHirdetesek() {
		return hirdetesek;
	}

	public void setHirdetesek(Set<Hirdetesek> hirdetesek) {
		this.hirdetesek = hirdetesek;
	}

	
	
	
	
}
