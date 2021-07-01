package ro.allamvizsga.projekt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Kiallitasreszvetel")
public class Kiallresztvesz {
	
	@Id
	@SequenceGenerator(sequenceName = "KIALLRESZTVESZSEQ", name = "KIALLRESZTVESZ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "KIALLRESZTVESZ")
	private Long id;
	
	@Column(name="pontszam")
	private double pontszam;

	@ManyToOne()
	@JoinColumn(name = "kiallitas_id")
	private Kiallitas kiallitas;
	
	@ManyToOne()
	@JoinColumn(name = "kisallat_id")
	private Kisallat kisallat;
	
	public Kiallitas getKiallitas() {
		return kiallitas;
	}

	public void setKiallitas(Kiallitas kiallitas) {
		this.kiallitas = kiallitas;
	}

	public double getPontszam() {
		return pontszam;
	}

	public void setPontszam(double pontszam) {
		this.pontszam = pontszam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Kisallat getKisallat() {
		return kisallat;
	}

	public void setKisallat(Kisallat kisallat) {
		this.kisallat = kisallat;
	}

}
