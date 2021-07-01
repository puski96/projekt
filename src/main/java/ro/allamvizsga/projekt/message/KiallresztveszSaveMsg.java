package ro.allamvizsga.projekt.message;

public class KiallresztveszSaveMsg {
	
	private Long id;
	private double pontszam;
	private Long kisallatId;
	private Long kiallitasId;
	
	
	public KiallresztveszSaveMsg() {
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public double getPontszam() {
		return pontszam;
	}


	public void setPontszam(double pontszam) {
		this.pontszam = pontszam;
	}


	public Long getKisallatId() {
		return kisallatId;
	}


	public void setKisallatId(Long kisallatId) {
		this.kisallatId = kisallatId;
	}


	public Long getKiallitasId() {
		return kiallitasId;
	}


	public void setKiallitasId(Long kiallitasId) {
		this.kiallitasId = kiallitasId;
	}
	
	
}
