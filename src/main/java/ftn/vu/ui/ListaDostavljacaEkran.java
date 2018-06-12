package ftn.vu.ui;

import java.util.List;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Dostavljac;

public class ListaDostavljacaEkran extends ListaPodatakaEkran {

	public ListaDostavljacaEkran(IzvorPodataka izvorPodataka) {
		super(izvorPodataka);
	}

	@Override
	public void dodajAkcija() {
		NoviKorisnikEkran nke = new NoviKorisnikEkran(izvorPodataka);
		nke.dodavanjeDostavljaca();
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
		Dostavljac dostavljac = (Dostavljac) obj;
		
		redovi[index][0] = dostavljac.getId();
		redovi[index][1] = dostavljac.getIme();
		redovi[index][2] = dostavljac.getPrezime();
		redovi[index][3] = dostavljac.getKorisnickoIme();
		redovi[index][4] = "*********";
		redovi[index][5] = dostavljac.getJmbg();
		redovi[index][6] = dostavljac.getPlata();
		redovi[index][7] = dostavljac.getTipVozila();
		redovi[index][8] = dostavljac.getRegistarskaOznakaVozila();
		
	}

	@Override
	public String[] dajKolone() {
		String[] kolone = new String[] { "ID", "Ime", "Prezime", "K ime",
				"Lozinka", "JMBG", "Plata", "Tip Vozila", "Reg. oznaka"};
		return kolone;
	}

	@Override
	public List dajPodatke() {
		return izvorPodataka.getDostavljaci();
	}

}
