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
@Table(name="Egyesulet")
public class Egyesulet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EGYESULET")
	@SequenceGenerator(sequenceName = "EGYESULETSEQ", name = "EGYESULET", allocationSize = 1)
	private Long id;
	
	@Column(name="nev")
	private String nev;
	
	@Column(name="azonosito")
	private String azonosito;
	
	@Column(name="elnok")
	private String elnok;
	
	@Column(name="helyseg")
	private String helyseg;
	
	@OneToMany(mappedBy = "egyesulet", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Tulajdonos> tulajok;

	public Egyesulet() {
		
	}

	public Egyesulet(String elnok, String nev) {
		this.elnok=elnok;
		this.nev=nev;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getElnok() {
		return elnok;
	}

	public void setElnok(String elnok) {
		this.elnok = elnok;
	}

	public Set<Tulajdonos> getTulajok() {
		return tulajok;
	}

	public void setTulajok(Set<Tulajdonos> tulajok) {
		this.tulajok = tulajok;
	}

	public String getHelyseg() {
		return helyseg;
	}

	public void setHelyseg(String helyseg) {
		this.helyseg = helyseg;
	}

	public String getAzonosito() {
		return azonosito;
	}

	public void setAzonosito(String azonosito) {
		this.azonosito = azonosito;
	}

	
}
