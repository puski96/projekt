package ro.allamvizsga.projekt.message;

import liquibase.pro.packaged.iF;
import ro.allamvizsga.projekt.model.Fajta;

public class FajtaSzamMsg {

	
	private Long id;
	private String fajta;
	private Long count;

	public FajtaSzamMsg(Long id,String fajta, Long count) {
		this.id = id;
		this.fajta=fajta;
		this.count = count;
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getFajta() {
		return fajta;
	}

	public void setFajta(String fajta) {
		this.fajta = fajta;
	}

	
	

	


	
	

	
	
	
}
