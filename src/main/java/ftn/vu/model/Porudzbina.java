package ftn.vu.model;

import java.util.Date;

public class Porudzbina extends Identifikator {

	private Restoran restoran;
	
	private Jelo jelo;
	
	private Pice pice;
	
	private Date vreme;
	
	private Kupac kupac;
	
	private Dostavljac dostavljac;
	

	public Porudzbina(Restoran restoran, Jelo jelo, Pice pice, Date vreme, Kupac kupac, Dostavljac dostavljac) throws Exception {
		super();
		this.restoran = restoran;
		this.jelo = jelo;
		this.pice = pice;
		this.vreme = vreme;
		this.kupac = kupac;
		this.dostavljac = dostavljac;
		
		validiraj(this);
	}

	private void validiraj(Porudzbina porudzbina) throws Exception {
		if (porudzbina.getRestoran() == null) {
			throw new Exception("Restoran ne moze biti null!");
		}
		if(porudzbina.getJelo() == null) {
			throw new Exception("Jelo ne moze biti null!");
		}
		if(porudzbina.getPice() == null) {
			throw new Exception("Vreme ne moze biti null!");
		}
		if(porudzbina.getKupac() == null) {
			throw new Exception("Kupac ne moze biti null!");
		}
	    // dostavljac i pice mogu biti null	u momentu kreiranje objekta
		
		
		if(!porudzbina.getRestoran().equals(porudzbina.getJelo().getRestoran())) {
			// ako restoran iz objekta jelo nije jednak restoranu iz objekta poruzdbina baci exception
			throw new Exception("Jelo mora biti iz istog restorana za koji je kreirana porudzbina!");
		}
		
		if(porudzbina.getPice() != null) { // pice je opciono, zbog toga moze biti null
			if(!porudzbina.getRestoran().equals(porudzbina.getPice().getRestoran())) {
				throw new Exception("Pice mora biti iz istog restorana za koji je kreirana porudzbina!");
			}
		}
	}

	public Restoran getRestoran() {
		return restoran;
	}

	public Jelo getJelo() {
		return jelo;
	}

	public Pice getPice() {
		return pice;
	}

	public Date getVreme() {
		return vreme;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public Dostavljac getDostavljac() {
		return dostavljac;
	}
	
	public double getUkupnaCena() {
		double ukupnaCena = 0;
		double dostava = 200;
		
		ukupnaCena = ukupnaCena + this.getJelo().getCena();
		
		if(this.getPice() != null) {
			ukupnaCena = ukupnaCena + this.getPice().getCena();
		}
		
		ukupnaCena = ukupnaCena + dostava;
		
		return ukupnaCena;
	}
	
}
