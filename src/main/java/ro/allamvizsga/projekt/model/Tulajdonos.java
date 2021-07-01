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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Tulajdonos")
public class Tulajdonos {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TULAJ")
@SequenceGenerator(sequenceName = "TULAJSEQ", name = "TULAJ", allocationSize = 1)
private Long id;

@Column(name="nev")
private String nev;

@Column(name="cim")
private String cim;

@Column(name="biro")
private boolean biro;

@Column(name="telszam")
private String telszam;

@ManyToOne(cascade = CascadeType.DETACH)
@JoinColumn(name = "egyesulet_id")
private Egyesulet egyesulet;


@OneToMany(mappedBy = "tulaj", cascade = CascadeType.DETACH)
@JsonBackReference
private Set<Kisallat> kisallatok;

 @OneToOne()
 @JoinColumn(name = "email", referencedColumnName = "id")
 private User user;

 @OneToMany(mappedBy = "tulajdonos", cascade = CascadeType.ALL)
 @JsonBackReference
	private Set<Keres> keres;

 @ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "helyseg_id")	  
	private Helyseg helyseg;
 
public Tulajdonos(String nev, String cim, boolean biro, String telSzam, Egyesulet egyesulet, Set<Kisallat> kisallatok) {
	super();
	this.nev = nev;
	this.cim = cim;
	this.biro = biro;
	this.egyesulet = egyesulet;
	this.kisallatok=kisallatok;
	this.telszam=telSzam;
}

public Tulajdonos() {
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNev() {
	return this.nev;
}

public void setNev(String nev) {
	this.nev = nev;
}

public String getCim() {
	return this.cim;
}

public void setCim(String cim) {
	this.cim = cim;
}

public boolean isBiro() {
	return this.biro;
}

public void setBiro(boolean biro) {
	this.biro = biro;
}

public Egyesulet getEgyesulet() {
	return this.egyesulet;
}

public void setEgyesulet(Egyesulet egyesulet) {
	this.egyesulet = egyesulet;
}

public Set<Kisallat> getKisallatok() {
	return this.kisallatok;
}

public void setKisallatok(Set<Kisallat> kisallatok) {
	this.kisallatok = kisallatok;
}

public String getTelszam() {
	return telszam;
}

public void setTelszam(String str) {
	this.telszam = str;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Set<Keres> getKeres() {
	return keres;
}

public void setKeres(Set<Keres> keres) {
	this.keres = keres;
}

public Helyseg getHelyseg() {
	return helyseg;
}

public void setHelyseg(Helyseg helyseg) {
	this.helyseg = helyseg;
}


}
