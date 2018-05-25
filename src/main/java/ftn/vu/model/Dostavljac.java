package ftn.vu.model;

public class Dostavljac extends Korisnik {
	
	private long jmbg;
	
	private double plata;
	
	private TipVozila tipVozila;
	
	private String registarskaOznakaVozila;
	
	public int getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}
	
	public String getRegistarskaOznakaVozila () {
		return registarskaOznakaVozila;
	}
	
	public void setRegistarskaOznakaVozila(String registarskaOznakaVozila) {
		this.registarskaOznakaVozila = registarskaOznakaVozila;
		
	}	
	
	
}
