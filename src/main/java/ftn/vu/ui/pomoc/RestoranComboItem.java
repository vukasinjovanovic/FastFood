package ftn.vu.ui.pomoc;

import ftn.vu.model.Restoran;

public class RestoranComboItem {

	private Restoran restoran;
	
	public RestoranComboItem(Restoran restoran) {
		this.restoran = restoran;
	}
	
	@Override
	public String toString() {
		return this.restoran.getNaziv();
	}
	
	public Restoran getRestoran (){
		return this.restoran;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((restoran == null) ? 0 : restoran.hashCode());
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
		RestoranComboItem other = (RestoranComboItem) obj;
		if (restoran == null) {
			if (other.restoran != null)
				return false;
		} else if (restoran.getId() != other.restoran.getId())
			return false;
		return true;
	}
	
	
}
