package ro.allamvizsga.projekt.message;

public class HirdetesekSaveMsg {
	private Long id;
	private String nev;
	private String fajta;
	private String leiras;
	private String ar;
	private Integer db;
	private Long tulajId;
	private Long kepid;
	
	
	
	
	
	public HirdetesekSaveMsg() {
	}
	
	public Long getKepid() {
		return kepid;
	}

	public void setKepid(Long kepid) {
		this.kepid = kepid;
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
	public String getFajta() {
		return fajta;
	}
	public void setFajta(String fajta) {
		this.fajta = fajta;
	}
	public String getLeiras() {
		return leiras;
	}
	public void setLeiras(String leiras) {
		this.leiras = leiras;
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
	public Long getTulajId() {
		return tulajId;
	}
	public void setTulajId(Long tulajId) {
		this.tulajId = tulajId;
	}
	
}
