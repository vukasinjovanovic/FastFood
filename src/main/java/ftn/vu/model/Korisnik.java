package ftn.vu.model;

public abstract class Korisnik extends Identifikator {

	protected String ime;
	protected String prezime;
	protected Pol pol;
	protected String korisnickoIme;
	protected String lozinka;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return super.toString() + "|" + ime + "|" + prezime + "|" + pol + "|" + korisnickoIme + "|" + lozinka + "";
	}
	
}
