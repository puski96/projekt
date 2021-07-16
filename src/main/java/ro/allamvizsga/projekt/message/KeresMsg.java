package ro.allamvizsga.projekt.message;

import javax.persistence.Column;

import ro.allamvizsga.projekt.model.Keres;
import ro.allamvizsga.projekt.model.Tulajdonos;

public class KeresMsg {

private Tulajdonos tulajdonos;
	
	private String fajta;
	private String szuldat;
	private Integer bakok;
	private Integer nostenyek;
	private String apajobbful;
	private String apabalful;
	private String anyajobbful;
	private String anyabalful;
	private Long tulajIdLong;
	
	
	
	public KeresMsg(Keres keres) {
		this.tulajdonos = keres.getTulajdonos();
		this.fajta = keres.getFajta();
		this.szuldat = keres.getSzuldat();
		this.bakok = keres.getBakok();
		this.nostenyek = keres.getNostenyek();
		this.apajobbful = keres.getApajobbful();
		this.apabalful = keres.getApabalful();
		this.anyajobbful = keres.getAnyajobbful();
		this.anyabalful = keres.getAnyabalful();
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
	public Long getTulajIdLong() {
		return tulajIdLong;
	}
	public void setTulajIdLong(Long tulajIdLong) {
		this.tulajIdLong = tulajIdLong;
	}
	
	
}
