package ro.allamvizsga.projekt.message;

public class KisallatSaveMsg {

	private Long id;
	private String jobbful;
	private String balful;
	private String nem;
	private Long tulajId;
	private Long fajtaId;
	
	
	public KisallatSaveMsg() {
		
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getTulajId() {
		return tulajId;
	}



	public void setTulajId(Long tulajId) {
		this.tulajId = tulajId;
	}



	public Long getFajtaId() {
		return fajtaId;
	}



	public void setFajtaId(Long fajtaId) {
		this.fajtaId = fajtaId;
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

	public String getNem() {
		return nem;
	}

	public void setNem(String nem) {
		this.nem = nem;
	}



	


}
