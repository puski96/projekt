package ro.allamvizsga.projekt.message;

import ro.allamvizsga.projekt.model.Kisallat;

public class KisallatSelectMsg {
	private String jobbful;
	private String balful;
	private String fajta;
	
	
	
	public KisallatSelectMsg(Kisallat kisallat) {
		this.jobbful=kisallat.getJobbful();
		this.balful=kisallat.getBalful();
		this.fajta=kisallat.getFajta().getFajta();
	}
	
	
	
	public String getJobbful() {
		return jobbful;
	}
	public void setJobbful(String jobbful) {
		this.jobbful = jobbful;
	}
	public String getBalful() {
		return balful;
	}
	public void setBalful(String balful) {
		this.balful = balful;
	}
	public String getFajta() {
		return fajta;
	}
	public void setFajta(String fajta) {
		this.fajta = fajta;
	}
	
}
