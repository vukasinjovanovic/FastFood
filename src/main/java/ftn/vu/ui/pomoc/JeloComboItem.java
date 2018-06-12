package ftn.vu.ui.pomoc;

import ftn.vu.model.Jelo;

public class JeloComboItem {

	private Jelo jelo;
	
	public JeloComboItem(Jelo jelo) {
		this.jelo = jelo;
	}
	
	@Override
	public String toString() {
		return jelo.getNaziv();
	}
	
	public Jelo getJelo() {
		return jelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jelo == null) ? 0 : jelo.hashCode());
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
		JeloComboItem other = (JeloComboItem) obj;
		if (jelo == null) {
			if (other.jelo != null)
				return false;
		} else if (jelo.getId() != other.jelo.getId())
			return false;
		return true;
	}
	
	
}
