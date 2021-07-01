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
@Table(name="Fajta")
public class Fajta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FAJTA")
	@SequenceGenerator(sequenceName = "FAJTASEQ", name = "FAJTA", allocationSize = 1)
	private Long id;
	
	@Column(name="fajtaleiras", columnDefinition="TEXT")
	private String fajtaleiras;
	
	@Column(name="fajta")
	private String fajta;
	
	@Column(name="kep")
	private String kep;
	
	@Column(name="allattipus")
	private String allattipus;
	
	@Column(name="rovidites")
	private String rovidites;
	
	@Column(name="bemutatkozo", columnDefinition="TEXT")
	private String bemutatkozo;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Kisallat> kisallatok;
	
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFajtaleiras() {
		return fajtaleiras;
	}


	public void setFajtaleiras(String fajtaleiras) {
		this.fajtaleiras = fajtaleiras;
	}


	public String getFajta() {
		return fajta;
	}


	public void setFajta(String fajta) {
		this.fajta = fajta;
	}


	public String getKep() {
		return kep;
	}


	public void setKep(String kep) {
		this.kep = kep;
	}


	public Set<Kisallat> getKisallatok() {
		return kisallatok;
	}


	public void setKisallatok(Set<Kisallat> kisallatok) {
		this.kisallatok = kisallatok;
	}


	public String getAllattipus() {
		return allattipus;
	}


	public void setAllattipus(String allattipus) {
		this.allattipus = allattipus;
	}


	public String getRovidites() {
		return rovidites;
	}


	public void setRovidites(String rovidites) {
		this.rovidites = rovidites;
	}


	public String getBemutatkozo() {
		return bemutatkozo;
	}


	public void setBemutatkozo(String bemutatkozo) {
		this.bemutatkozo = bemutatkozo;
	}


	
	

}
