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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adresa == null) ? 0 : adresa.hashCode());
		result = prime * result
				+ ((brojTelefona == null) ? 0 : brojTelefona.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kupac other = (Kupac) obj;
		if (adresa == null) {
			if (other.adresa != null)
				return false;
		} else if (!adresa.equals(other.adresa))
			return false;
		if (brojTelefona == null) {
			if (other.brojTelefona != null)
				return false;
		} else if (!brojTelefona.equals(other.brojTelefona))
			return false;
		return true;
	}
	
	
}
