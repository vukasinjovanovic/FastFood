package ftn.vu.ui;

import java.util.List;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Restoran;

public class ListaRestoranaEkran extends ListaPodatakaEkran {

	public ListaRestoranaEkran(IzvorPodataka izvorPodataka) {
		super(izvorPodataka);
	}

	@Override
	public void dodajAkcija() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void izmeniAkcija() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obrisiAkcija() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popuniRedove(Object[][] redovi, Object obj, int index) {
		Restoran restoran = (Restoran) obj;

		redovi[index][0] = restoran.getId();
		redovi[index][1] = restoran.getNaziv();
		redovi[index][2] = restoran.getAdresa();
		redovi[index][3] = restoran.getKategorija();
		
	}

	@Override
	public String[] dajKolone() {
		String[] kolone = new String[] { "ID", "Naziv", "Adresa", "Kategorija" };
		return kolone;
	}

	@Override
	public List dajPodatke() {
		return izvorPodataka.getRestorani();
	}

}
