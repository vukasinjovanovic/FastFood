package ftn.vu.izvor.podataka;

import java.util.ArrayList;
import java.util.List;

import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.Jelo;
import ftn.vu.model.Kupac;
import ftn.vu.model.Pice;
import ftn.vu.model.Porudzbina;
import ftn.vu.model.Restoran;

public class IzvorPodataka {
	
	private List<Administrator> administratori = new ArrayList<Administrator>();
	
	private List<Dostavljac> dostavljaci = new ArrayList<Dostavljac>();
	
	private List<Kupac> kupci = new ArrayList<Kupac>();
	
	private List<Jelo> jela = new ArrayList<Jelo>();
	
	private List<Pice> pice = new ArrayList<Pice>();
	
	private List<Porudzbina> porudzbine = new ArrayList<Porudzbina>();
	
	private List<Restoran> restorani = new ArrayList<Restoran>();

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
	
	public List<Jelo> getJela() {
		return jela;
	}

	public void setJela(List<Jelo> jela) {
		this.jela = jela;
	}

	public List<Pice> getPice() {
		return pice;
	}

	public void setPice(List<Pice> pice) {
		this.pice = pice;
	}

	public List<Porudzbina> getPorudzbine() {
		return porudzbine;
	}

	public void setPorudzbine(List<Porudzbina> porudzbine) {
		this.porudzbine = porudzbine;
	}
	
	public List<Restoran> getRestorani() {
		return restorani;
	}

	public void setRestorani(List<Restoran> restorani) {
		this.restorani = restorani;
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
