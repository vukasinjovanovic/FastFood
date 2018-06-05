package ftn.vu.model;

public class Administrator extends Korisnik {
	
	private long jmbg;
	
	private double plata;
	
	public Administrator() {
	}

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

	@Override
	public String toString() {
		return super.toString() + "|" + jmbg + "|" + plata + "";
	}
	
	

}
