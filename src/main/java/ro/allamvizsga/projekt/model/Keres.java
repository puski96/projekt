package ro.allamvizsga.projekt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Keres")
public class Keres {

	@Id
	@SequenceGenerator(sequenceName = "KERESSEQ", name = "KERES")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "KERES")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tulaj_id")
	private Tulajdonos tulajdonos;
	
	
	@Column(name="fajta")
	private String fajta;
	
	@Column(name="szuldat")
	private String szuldat;
	
	@Column(name="bakok")
	private Integer bakok;
	
	@Column(name="nostenyek")
	private Integer nostenyek;
	
	@Column(name="apajobbful")
	private String apajobbful;
	
	@Column(name="apabalful")
	private String apabalful;
	
	@Column(name="anyajobbful")
	private String anyajobbful;
	
	@Column(name="anyabalful")
	private String anyabalful;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tulajdonos getTulajdonos() {
		return tulajdonos;
	}

	public void setTulajdonos(Tulajdonos tulajdonos) {
		this.tulajdonos = tulajdonos;
	}

	public String getFajta() {
		return fajta;
	}

	public void setFajta(String fajta) {
		this.fajta = fajta;
	}

	public String getSzuldat() {
		return szuldat;
	}

	public void setSzuldat(String szuldat) {
		this.szuldat = szuldat;
	}

	public Integer getBakok() {
		return bakok;
	}

	public void setBakok(Integer bakok) {
		this.bakok = bakok;
	}

	public Integer getNostenyek() {
		return nostenyek;
	}

	public void setNostenyek(Integer nostenyek) {
		this.nostenyek = nostenyek;
	}

	public String getApajobbful() {
		return apajobbful;
	}

	public void setApajobbful(String apajobbful) {
		this.apajobbful = apajobbful;
	}

	public String getApabalful() {
		return apabalful;
	}

	public void setApabalful(String apabalful) {
		this.apabalful = apabalful;
	}

	public String getAnyajobbful() {
		return anyajobbful;
	}

	public void setAnyajobbful(String anyajobbful) {
		this.anyajobbful = anyajobbful;
	}

	public String getAnyabalful() {
		return anyabalful;
	}

	public void setAnyabalful(String anyabalful) {
		this.anyabalful = anyabalful;
	}

	
	
}
