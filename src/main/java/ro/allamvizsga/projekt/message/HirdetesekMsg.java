package ro.allamvizsga.projekt.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ro.allamvizsga.projekt.model.Hirdetesek;

@JsonInclude(Include.NON_NULL)
public class HirdetesekMsg {
private Long id;
		
	private String ar;
	
	private String leiras;
	
	private Integer db;
	
	private String neve;
	
	private String cime;
	
	private String nev;
	
	private String telefonszam;
	
	private String email;
	
	private byte[] kep;

	private String longitude;
	
	private String latitude;
	
	public HirdetesekMsg(Hirdetesek hirdetesek) {
			this.id=hirdetesek.getId();
			this.leiras=hirdetesek.getLeiras();
			this.ar = hirdetesek.getAr();
			this.db = hirdetesek.getDb();
			this.neve = hirdetesek.getTulajdonos().getNev();
			this.cime=hirdetesek.getTulajdonos().getCim();
			this.nev=hirdetesek.getNev();
			this.telefonszam=hirdetesek.getTulajdonos().getTelszam();
			if(hirdetesek.getKepfeltolt()!=null) {
				
				this.kep=hirdetesek.getKepfeltolt().getPic();
			}
			this.longitude=hirdetesek.getHelyseg().getLongitude();
			this.latitude=hirdetesek.getHelyseg().getLatitude();
//		this.email=hirdetesek.getTulajdonos().getUser().getUserName();
	}
	

	
	public byte[] getKep() {
		return kep;
	}


	public void setKep(byte[] kep) {
		this.kep = kep;
	}



	public String getCime() {
		return cime;
	}


	public void setCime(String cime) {
		this.cime = cime;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
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







	public String getNeve() {
		return neve;
	}


	public void setNeve(String neve) {
		this.neve = neve;
	}


	public String getTelefonszam() {
		return telefonszam;
	}


	public void setTelefonszam(String telefonszam) {
		this.telefonszam = telefonszam;
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


	public String getLeiras() {
		return leiras;
	}


	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}
		
	
}
