package ftn.vu.model;

public class Jelo extends Artikal {
	
	private int kolicina;
	
	public int getKolocina () {
		return kolicina;
	}
	
	public void setKolicina (int kolicina) {
		this.kolicina = kolicina;
	}

	@Override
	public String toString() {
		return super.toString() + "|" + kolicina + "";
	}
}
