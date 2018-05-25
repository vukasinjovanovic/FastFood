package ftn.vu.model;

public abstract class Artikal {
	
	private String naziv;
	private double cena;
	private String opis;
	private Restoran restoran;
	
	public String getNaziv () {
		return naziv;
	}
	
	public void setNaziv (String naziv) {
		this.naziv = naziv;
	}
	
	public double getCena () {
		return cena;
	}
	
	public void setCena (double cena) {
		this.cena = cena;
	}
	
	public String getOpis () {
		return opis;
	}
	
	public void getOpis (String opis) {
		this.opis = opis;
	}
	
	public Restoran getRestoran () {
		return restoran;
	}
	
	public void setRestoran (Restoran restoran) {
		this.restoran = restoran;
	}

}
