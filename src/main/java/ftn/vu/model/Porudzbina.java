package ftn.vu.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Porudzbina extends Identifikator {

	private Restoran restoran;

	private Jelo jelo;

	private Pice pice;

	private Date vreme;

	private Kupac kupac;

	private Dostavljac dostavljac;

	public Porudzbina(long id, Restoran restoran, Jelo jelo, Pice pice, Date vreme,
			Kupac kupac, Dostavljac dostavljac) throws Exception {
		this.id = id;
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
		if (porudzbina.getJelo() == null) {
			throw new Exception("Jelo ne moze biti null!");
		}
		if (porudzbina.getVreme() == null) {
			throw new Exception("Vreme ne moze biti null!");
		}
		if (porudzbina.getKupac() == null) {
			throw new Exception("Kupac ne moze biti null!");
		}
		// dostavljac i pice mogu biti null u momentu kreiranje objekta

		if (!porudzbina.getRestoran()
				.equals(porudzbina.getJelo().getRestoran())) {
			// ako restoran iz objekta jelo nije jednak restoranu iz objekta
			// poruzdbina baci exception
			throw new Exception(
					"Jelo mora biti iz istog restorana za koji je kreirana porudzbina!");
		}

		if (porudzbina.getPice() != null) { // pice je opciono, zbog toga moze
											// biti null
			if (!porudzbina.getRestoran().equals(
					porudzbina.getPice().getRestoran())) {
				throw new Exception(
						"Pice mora biti iz istog restorana za koji je kreirana porudzbina!");
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

		if (this.getPice() != null) {
			ukupnaCena = ukupnaCena + this.getPice().getCena();
		}

		ukupnaCena = ukupnaCena + dostava;

		return ukupnaCena;
	}
	
	private String getPiceId() {
		if(pice != null) {
			return pice.getId() + "";
		}
		return "-1";
	}
	
    private String getDostavljacId(){
		if(dostavljac != null) {
			return dostavljac.getId() + "";
		}
		return "-1";
    }
	
	private String getVremeStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(vreme).toString();
	}

	@Override
	public String toString() {
		return super.toString() + "|restoran " + restoran.getId() + "|jelo "
				+ jelo.getId() + "|pice " + getPiceId() + "|" + getVremeStr()
				+ "|kupac " + kupac.getId() + "|dostavljac "
				+ getDostavljacId() + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dostavljac == null) ? 0 : dostavljac.hashCode());
		result = prime * result + ((jelo == null) ? 0 : jelo.hashCode());
		result = prime * result + ((kupac == null) ? 0 : kupac.hashCode());
		result = prime * result + ((pice == null) ? 0 : pice.hashCode());
		result = prime * result
				+ ((restoran == null) ? 0 : restoran.hashCode());
		result = prime * result + ((vreme == null) ? 0 : vreme.hashCode());
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
		Porudzbina other = (Porudzbina) obj;
		if (dostavljac == null) {
			if (other.dostavljac != null)
				return false;
		} else if (!dostavljac.equals(other.dostavljac))
			return false;
		if (jelo == null) {
			if (other.jelo != null)
				return false;
		} else if (!jelo.equals(other.jelo))
			return false;
		if (kupac == null) {
			if (other.kupac != null)
				return false;
		} else if (!kupac.equals(other.kupac))
			return false;
		if (pice == null) {
			if (other.pice != null)
				return false;
		} else if (!pice.equals(other.pice))
			return false;
		if (restoran == null) {
			if (other.restoran != null)
				return false;
		} else if (!restoran.equals(other.restoran))
			return false;
		if (vreme == null) {
			if (other.vreme != null)
				return false;
		} else if (!vreme.equals(other.vreme))
			return false;
		return true;
	}
	
	

}
