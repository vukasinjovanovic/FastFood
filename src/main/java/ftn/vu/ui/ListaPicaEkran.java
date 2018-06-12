package ftn.vu.ui;

import java.util.List;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Pice;

public class ListaPicaEkran extends ListaPodatakaEkran{

	public ListaPicaEkran(IzvorPodataka izvorPodataka) {
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
		Pice pice= (Pice) obj;
		
		redovi[index][0] = pice.getId();
		redovi[index][1] = pice.getNaziv();
		redovi[index][2] = pice.getCena();
		redovi[index][3] = pice.getOpis();
		redovi[index][4] = pice.getRestoran().getNaziv();
		redovi[index][5] = pice.getKolocina();
		
	}

	@Override
	public String[] dajKolone() {
		String[] kolone = new String[] { "ID", "Naziv", "Cena", "Opis",
				"Restoran", "Kolicina" };
		return kolone;
	}

	@Override
	public List dajPodatke() {
		return izvorPodataka.getPice();
	}

}
