package ro.allamvizsga.projekt.message;

import ro.allamvizsga.projekt.model.Egyesulet;

public class EgyesuletMsg {
	private Long id;
	private String nev;
	
	public EgyesuletMsg() {
	}

	public EgyesuletMsg(Egyesulet egyesulet) {
		this.id=egyesulet.getId();
		this.nev = egyesulet.getNev();
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

}
