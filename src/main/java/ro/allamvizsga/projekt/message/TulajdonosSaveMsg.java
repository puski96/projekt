package ro.allamvizsga.projekt.message;

public class TulajdonosSaveMsg {
	
	private Long id;
	private String nev;
	private String cim;
	private String telszam;
	private boolean biro;
	private Long egyesuletId;
	
	 


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public boolean isBiro() {
		return biro;
	}



	public void setBiro(boolean biro) {
		this.biro = biro;
	}



	public TulajdonosSaveMsg() {
	}

	
	
	

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getCim() {
		return cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public Long getEgyesuletId() {
		return egyesuletId;
	}
	
	
	public void setEgyesuletId(Long egyesuletId) {
		this.egyesuletId = egyesuletId;
	}



	public String getTelszam() {
		return telszam;
	}



	public void setTelszam(String telszam) {
		this.telszam = telszam;
	}



}
