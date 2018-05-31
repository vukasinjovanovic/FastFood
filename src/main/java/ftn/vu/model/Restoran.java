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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresa == null) ? 0 : adresa.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((kategorija == null) ? 0 : kategorija.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restoran other = (Restoran) obj;
		if (adresa == null) {
			if (other.adresa != null)
				return false;
		} else if (!adresa.equals(other.adresa))
			return false;
		if (id != other.id)
			return false;
		if (kategorija != other.kategorija)
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}
	
	

}
