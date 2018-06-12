package ftn.vu.ui;

import java.util.List;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Kupac;

public class ListaKupacaEkran extends ListaPodatakaEkran {

	public ListaKupacaEkran(IzvorPodataka izvorPodataka) {
		super(izvorPodataka);
	}

	@Override
	public void dodajAkcija() {
		NoviKorisnikEkran nke = new NoviKorisnikEkran(izvorPodataka);
		nke.dodavanjeKupca();
		nke.setVisible(true);
		
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
		Kupac kupac = (Kupac) obj;
		
		redovi[index][0] = kupac.getId();
		redovi[index][1] = kupac.getIme();
		redovi[index][2] = kupac.getPrezime();
		redovi[index][3] = kupac.getKorisnickoIme();
		redovi[index][4] = "*********";
		redovi[index][5] = kupac.getAdresa();
		redovi[index][6] = kupac.getBrojTelefona();
	}

	@Override
	public String[] dajKolone() {
		String[] kolone = new String[] { "ID", "Ime", "Prezime", "K ime",
				"Lozinka", "Adresa", "Telefon" };
		return kolone;
	}

	@Override
	public List dajPodatke() {
		return izvorPodataka.getKupci();
	}

}
