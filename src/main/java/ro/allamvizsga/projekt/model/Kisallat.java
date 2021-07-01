package ro.allamvizsga.projekt.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="Kisallat")
public class Kisallat {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "KISALLAT")
	@SequenceGenerator(sequenceName = "KISALLATSEQ", name = "KISALLAT", allocationSize = 1)
	private Long id;
	
	@Column(name="jobbful")
	private String jobbful;
	
	@Column(name="balful")
	private String balful;
	
	@Column(name="nem")
	private String nem;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "tulaj_id")
	private Tulajdonos tulaj;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fajta_id")	  
	private Fajta fajta;
	
	@OneToMany(mappedBy = "kisallat", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<Kiallresztvesz> reszvetel;
	
	
	
	
	public Kisallat() {
		
	}

	public Kisallat(Long id, String jobbful, String balful, String nem, Tulajdonos tulaj, Fajta fajta,
			Set<Kiallresztvesz> reszvetel) {
		
		this.jobbful = jobbful;
		this.balful = balful;
		this.nem = nem;
		this.tulaj = tulaj;
		this.fajta = fajta;
		this.reszvetel = reszvetel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobbful() {
		return jobbful;
	}

	public void setJobbful(String jobbful) {
		this.jobbful = jobbful;
	}

	public String getBalful() {
		return balful;
	}

	public void setBalful(String balful) {
		this.balful = balful;
	}

	public String getNem() {
		return nem;
	}

	public void setNem(String nem) {
		this.nem = nem;
	}

	public Tulajdonos getTulaj() {
		return tulaj;
	}

	public void setTulaj(Tulajdonos tulaj) {
		this.tulaj = tulaj;
	}

	public Fajta getFajta() {
		return fajta;
	}

	public void setFajta(Fajta fajta) {
		this.fajta = fajta;
	}

	public Set<Kiallresztvesz> getReszvetel() {
		return reszvetel;
	}

	public void setReszvetel(Set<Kiallresztvesz> reszvetel) {
		this.reszvetel = reszvetel;
	}

	
}
