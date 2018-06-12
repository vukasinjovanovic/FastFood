package ftn.vu.ui;

import java.util.List;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Jelo;

public class ListaJelaEkran extends ListaPodatakaEkran {

	public ListaJelaEkran(IzvorPodataka izvorPodataka) {
		super(izvorPodataka);
		// TODO Auto-generated constructor stub
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
		Jelo jelo = (Jelo) obj;
		
		redovi[index][0] = jelo.getId();
		redovi[index][1] = jelo.getNaziv();
		redovi[index][2] = jelo.getCena();
		redovi[index][3] = jelo.getOpis();
		redovi[index][4] = jelo.getRestoran().getNaziv();
		redovi[index][5] = jelo.getKolocina();
	}

	@Override
	public String[] dajKolone() {
		String[] kolone = new String[] { "ID", "Naziv", "Cena", "Opis",
				"Restoran", "Kolicina" };
		return kolone;
	}

	@Override
	public List dajPodatke() {
		return izvorPodataka.getJela();
	}

}
