package ftn.vu.model;

public class Restoran extends Identifikator{
	
	private String naziv;
	private String adresa;
	private Kategorija kategorija;
	
	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	
	public String getNaziv () {
		return naziv;
	}
	
	public void setNaziv (String naziv) {
		this.naziv = naziv;
	}
	
	public String getAdresa () {
		return adresa;
	}
	
	public void setAdresa (String adresa) {
		this.adresa = adresa;
	}


}
