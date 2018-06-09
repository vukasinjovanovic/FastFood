package ftn.vu.model;

public class Pice extends Artikal {
	
    private double kolicina;
	
	public double getKolocina () {
		return kolicina;
	}
	
	public void setKolicina (double kolicina) {
		this.kolicina = kolicina;
	}

	@Override
	public String toString() {
		return super.toString() + "|" + kolicina + "";
	}	

}
