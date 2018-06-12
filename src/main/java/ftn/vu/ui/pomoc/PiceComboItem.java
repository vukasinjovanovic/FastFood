package ftn.vu.ui.pomoc;

import ftn.vu.model.Pice;

public class PiceComboItem {

	private Pice pice;
	
	public PiceComboItem (Pice pice) {
		this.pice = pice;
	}
	
	
	@Override
	public String toString() {
		return pice.getNaziv();
	}
	
	public Pice getPice() {
		return pice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pice == null) ? 0 : pice.hashCode());
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
		PiceComboItem other = (PiceComboItem) obj;
		if (pice == null) {
			if (other.pice != null)
				return false;
		} else if (pice.getId() != other.pice.getId())
			return false;
		return true;
	}
	
	
}
