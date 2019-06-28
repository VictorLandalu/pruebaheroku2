package ufv.dis.finalej2.vg;

public class Tweet {

	
	
	private String name;
	private String mensaje;
	private String date;
	
	
	public Tweet (String nom, String men, String dat) {
		this.name = nom;
		this.mensaje = men;
		this.date = dat;
	}
	public void setName(String nom) {
		this.name = nom;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setMensaje(String mensaj) {
		this.mensaje = mensaj;
	}
	
	public String getMensaje () {
		return this.mensaje;
	}
	
	public void setDate(String dat) {
		this.date = dat;
	}
	
	public String getDate () {
		return this.date;
	}
	
}
