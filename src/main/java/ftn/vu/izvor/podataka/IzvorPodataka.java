package ftn.vu.izvor.podataka;

import java.util.ArrayList;
import java.util.List;

import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.Kupac;

public class IzvorPodataka {
	
	private List<Administrator> administratori = new ArrayList<Administrator>();
	
	private List<Dostavljac> dostavljaci = new ArrayList<Dostavljac>();
	
	private List<Kupac> kupci = new ArrayList<Kupac>();

	private long maxId;

	public IzvorPodataka() {
	}

	public List<Administrator> getAdministratori() {
		return administratori;
	}

	public void setAdministratori(List<Administrator> administratori) {
		this.administratori = administratori;
	}
	
	public List<Dostavljac> getDostavljaci() {
		return dostavljaci;
	}

	public void setDostavljaci(List<Dostavljac> dostavljaci) {
		this.dostavljaci = dostavljaci;
	}
	
	public List<Kupac> getKupci() {
		return kupci;
	}

	public void setKupci(List<Kupac> kupci) {
		this.kupci = kupci;
	}

	public Administrator pronadjiAdmina(String kIme, String lozinka) {
		for (Administrator administrator : administratori) {
			if(administrator.getKorisnickoIme().equals(kIme) && administrator.getLozinka().equals(lozinka)) {
				return administrator;
			}
		}
		return null;
	}

	public Dostavljac pronadjiDostavljaca(String kIme, String lozinka) {
		for (Dostavljac dostavljac : dostavljaci) {
			if(dostavljac.getKorisnickoIme().equals(kIme) && dostavljac.getLozinka().equals(lozinka)) {
				return dostavljac;
			}
		}
		return null;
	}
	
	public Kupac pronadjiKupca(String kIme, String lozinka) {
		for (Kupac k : kupci) {
			if(k.getKorisnickoIme().equals(kIme) && k.getLozinka().equals(lozinka)) {
				return k;
			}
		}
		return null;
	}

	public long dajSledeciId() {
		maxId = maxId + 1;
		return maxId;
	}

	public void setMaxId(long maxId) {
		this.maxId = maxId;
	}
	
	
	
}
