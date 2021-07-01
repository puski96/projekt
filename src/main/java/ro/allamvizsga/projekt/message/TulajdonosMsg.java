package ro.allamvizsga.projekt.message;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ro.allamvizsga.projekt.model.Kisallat;
import ro.allamvizsga.projekt.model.Tulajdonos;


public class TulajdonosMsg {
	
	private Long id;
	private String nev;
	private String cim;
	private String telszam;
	private String egyesuletNev;
	private String egyesuletElnok;
	private String fajtanev;
	Set<String> hs = new HashSet<String>();

	public TulajdonosMsg(Tulajdonos tulaj) {
		this.id=tulaj.getId();
		this.nev = tulaj.getNev();
		this.cim = tulaj.getCim();
		this.telszam=tulaj.getTelszam();
//			this.fajtanev= tulaj.getKisallatok();
		this.egyesuletNev= tulaj.getEgyesulet() != null?tulaj.getEgyesulet().getNev():"";
		this.egyesuletElnok=tulaj.getEgyesulet().getElnok();
		this.fajtanev = new String();
		for (Iterator iterator = tulaj.getKisallatok().iterator(); iterator.hasNext();) {
			Kisallat kisallat = (Kisallat) iterator.next();
			hs.add(kisallat.getFajta().getFajta());
			
		}		this.fajtanev+=hs;
	}
	
	 
	public TulajdonosMsg() {
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

	public String getCim() {
		return cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	
	public String getEgyesuletNev() {
		return egyesuletNev;
	}


	public void setEgyesuletNev(String egyesuletNev) {
		this.egyesuletNev = egyesuletNev;
	}


	public String getFajtanev() {
		return fajtanev;
	}

	public void setFajtanev(String fajtanev) {
		this.fajtanev = fajtanev;
	}


	public String getEgyesuletElnok() {
		return egyesuletElnok;
	}


	public void setEgyesuletElnok(String egyesuletElnok) {
		this.egyesuletElnok = egyesuletElnok;
	}


	public String getTelszam() {
		return telszam;
	}


	public void setTelszam(String telszam) {
		this.telszam = telszam;
	}


}
