package ftn.vu.ui.pomoc;

import ftn.vu.model.Dostavljac;

public class DostavljacConboItem {

	private  Dostavljac dostavljac;
	
	public DostavljacConboItem(Dostavljac dostavljac) {
		this.dostavljac = dostavljac;
	}
	
	@Override
	public String toString() {
		return dostavljac.getIme() + " " + dostavljac.getPrezime();
	}
	
	public Dostavljac getDostavljac() {
		return dostavljac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dostavljac == null) ? 0 : dostavljac.hashCode());
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
		DostavljacConboItem other = (DostavljacConboItem) obj;
		if (dostavljac == null) {
			if (other.dostavljac != null)
				return false;
		} else if (dostavljac.getId() != other.dostavljac.getId())
			return false;
		return true;
	}
	
	
}
