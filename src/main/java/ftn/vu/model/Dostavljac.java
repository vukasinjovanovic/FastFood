package ftn.vu.model;

public class Dostavljac extends Korisnik {
	
	private long jmbg;
	
	private double plata;
	
	private TipVozila tipVozila;
	
	private String registarskaOznakaVozila;
	
	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}
	
	public String getRegistarskaOznakaVozila () {
		return registarskaOznakaVozila;
	}
	
	public void setRegistarskaOznakaVozila(String registarskaOznakaVozila) {
		this.registarskaOznakaVozila = registarskaOznakaVozila;
		
	}

	@Override
	public String toString() {
		return super.toString() + "|" + jmbg + "|" + plata + "|" + tipVozila + "|" + registarskaOznakaVozila + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (jmbg ^ (jmbg >>> 32));
		long temp;
		temp = Double.doubleToLongBits(plata);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime
				* result
				+ ((registarskaOznakaVozila == null) ? 0
						: registarskaOznakaVozila.hashCode());
		result = prime * result
				+ ((tipVozila == null) ? 0 : tipVozila.hashCode());
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
		Dostavljac other = (Dostavljac) obj;
		if (jmbg != other.jmbg)
			return false;
		if (Double.doubleToLongBits(plata) != Double
				.doubleToLongBits(other.plata))
			return false;
		if (registarskaOznakaVozila == null) {
			if (other.registarskaOznakaVozila != null)
				return false;
		} else if (!registarskaOznakaVozila
				.equals(other.registarskaOznakaVozila))
			return false;
		if (tipVozila != other.tipVozila)
			return false;
		return true;
	}	
	
	
}
