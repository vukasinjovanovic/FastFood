package ftn.vu.izvor.podataka;

import java.util.ArrayList;
import java.util.List;

import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;

public class IzvorPodataka {
	
	private List<Administrator> administratori = new ArrayList<Administrator>();
	
	private List<Dostavljac> dostavljaci = new ArrayList<Dostavljac>();

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

	public long dajSledeciId() {
		maxId = maxId + 1;
		return maxId;
	}

	public void setMaxId(long maxId) {
		this.maxId = maxId;
	}
	
	
	
}
