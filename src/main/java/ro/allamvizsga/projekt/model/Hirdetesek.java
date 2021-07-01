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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.sql.ast.Clause;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name="Hirdetesek")
public class Hirdetesek {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="nev")
	private String nev;
	
	@Column(name="ar")
	private String ar;
	
	@Column(name="db")
	private Integer db;
		
	@Column(name="leiras")
	private String leiras;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tulaj_id")
	private Tulajdonos tulajdonos;
	
	@OneToOne(mappedBy = "hirdetesek")
	private Kepfeltolt kepfeltolt;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "helyseg_id")
	private Helyseg helyseg;
 
	@Column(name="eladva")
	private Long eladva;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public Long getEladva() {
		return eladva;
	}

	public void setEladva(Long eladva) {
		this.eladva = eladva;
	}

	public Kepfeltolt getKepfeltolt() {
		return kepfeltolt;
	}

	public void setKepfeltolt(Kepfeltolt kepfeltolt) {
		this.kepfeltolt = kepfeltolt;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getAr() {
		return ar;
	}

	public void setAr(String ar) {
		this.ar = ar;
	}

	public Integer getDb() {
		return db;
	}

	public void setDb(Integer db) {
		this.db = db;
	}

	

	public Tulajdonos getTulajdonos() {
		return tulajdonos;
	}

	public void setTulajdonos(Tulajdonos tulajdonos) {
		this.tulajdonos = tulajdonos;
	}
	

	public String getLeiras() {
		return leiras;
	}

	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}

	public Helyseg getHelyseg() {
		return helyseg;
	}

	public void setHelyseg(Helyseg helyseg) {
		this.helyseg = helyseg;
	}

	
}
