package ftn.vu.model;

public class Administrator extends Korisnik {
	
	private int jmbg;
	
	private double plata;
	
	public Administrator() {
		this.prezime = "";
	}

	public int getJmbg() {
		return jmbg;
	}

	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	

}
