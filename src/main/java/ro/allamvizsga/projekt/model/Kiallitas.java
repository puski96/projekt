package ro.allamvizsga.projekt.model;

import java.util.Date;
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
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="Kiallitas")
public class Kiallitas {

	@Id
	@SequenceGenerator(sequenceName = "KIALLITASSEQ", name = "KIALLITAS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "KIALLITAS")
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="kezdodatum")
	private Date kezdodatum;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="vegdatum")
	private Date vegdatum;
	
	@Column(name="helyseg")
	private String helyseg;

	@OneToMany(mappedBy = "kiallitas", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Kiallresztvesz> resztvetelek;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Kiallresztvesz> getResztvetelek() {
		return resztvetelek;
	}

	public void setResztvetelek(Set<Kiallresztvesz> resztvetelek) {
		this.resztvetelek = resztvetelek;
	}

	public Date getKezdodatum() {
		return kezdodatum;
	}

	public void setKezdodatum(Date kezdodatum) {
		this.kezdodatum = kezdodatum;
	}

	public Date getVegdatum() {
		return vegdatum;
	}

	public void setVegdatum(Date vegdatum) {
		this.vegdatum = vegdatum;
	}

	public String getHelyseg() {
		return helyseg;
	}

	public void setHelyseg(String helyseg) {
		this.helyseg = helyseg;
	}
	
}
