package ftn.vu.model;

public abstract class Identifikator {

	protected long id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
}
