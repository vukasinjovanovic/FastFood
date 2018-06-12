package ftn.vu.model;

public abstract class Zaposleni extends Korisnik {

	protected long jmbg;
	
	protected double plata;
	
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
	
	@Override
	public String toString() {
		return super.toString() + "|" + jmbg + "|" + plata + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (jmbg ^ (jmbg >>> 32));
		long temp;
		temp = Double.doubleToLongBits(plata);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Zaposleni other = (Zaposleni) obj;
		if (jmbg != other.jmbg)
			return false;
		if (Double.doubleToLongBits(plata) != Double
				.doubleToLongBits(other.plata))
			return false;
		return true;
	}
	
}
