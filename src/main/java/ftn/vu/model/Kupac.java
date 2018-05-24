package ftn.vu.model;

public class Kupac extends Korisnik {
	
	private String adresa;
	
	private int brojTelefona;
	
	public String getAdresa () {
		return adresa;
	}
	
	public void setAdresa (String adresa) {
		this.adresa = adresa;
	}
	
	public int getBrojTelefona () {
		return brojTelefona;
	}
	
	public void setBrojTelefona (int brojTelefona) {
		this.brojTelefona = brojTelefona;
		
	}
	
	

}
