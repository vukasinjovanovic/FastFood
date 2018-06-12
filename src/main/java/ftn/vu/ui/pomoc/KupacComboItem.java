package ftn.vu.ui.pomoc;

import ftn.vu.model.Kupac;

public class KupacComboItem {

	private Kupac kupac;
	

	public KupacComboItem(Kupac kupac) {
		this.kupac = kupac;
	}
	
	@Override
	public String toString() {
		return kupac.getIme() + " " + kupac.getPrezime();
	}
	
	public Kupac getKupac() {
		return kupac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kupac == null) ? 0 : kupac.hashCode());
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
		KupacComboItem other = (KupacComboItem) obj;
		if (kupac == null) {
			if (other.kupac != null)
				return false;
		} else if (kupac.getId() != other.kupac.getId())
			return false;
		return true;
	}
	
	
}
