package ro.allamvizsga.projekt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="kep")
public class Kep {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="nev")
	private String nev;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "hirdetes_id")
	private Hirdetesek hirdetesek;

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

	public Hirdetesek getHirdetesek() {
		return hirdetesek;
	}

	public void setHirdetesek(Hirdetesek hirdetesek) {
		this.hirdetesek = hirdetesek;
	}
	
	
}
