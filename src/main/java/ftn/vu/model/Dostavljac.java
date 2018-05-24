package ftn.vu.model;

public class Dostavljac extends Korisnik {
	
	private long jmbg;
	
	private double plata;
	
	public long getJmbg() {
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

	
	private TipVozila tipVozila;

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}
	
	private String registarskaOznakaVozila;
	
	public String getRegistarskaOznakaVozila () {
		return registarskaOznakaVozila;
	}
	
	public void setRegistarskaOznakaVozila(String registarskaOznakaVozila) {
		this.registarskaOznakaVozila = registarskaOznakaVozila;
		
	}	
	
	
}
