package ftn.vu.model;

public class Kupac extends Korisnik {
	
	private String adresa;
	
	private String brojTelefona;
	
	public String getAdresa () {
		return adresa;
	}
	
	public void setAdresa (String adresa) {
		this.adresa = adresa;
	}
	
	public String getBrojTelefona () {
		return brojTelefona;
	}
	
	public void setBrojTelefona (String brojTelefona) {
		this.brojTelefona = brojTelefona;
		
	}

	@Override
	public String toString() {
		return super.toString() + "|" + adresa + "|" + brojTelefona + "";
	}
	
	
}
