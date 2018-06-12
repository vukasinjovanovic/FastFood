package ftn.vu.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.Kupac;
import ftn.vu.model.Porudzbina;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPorudzbinaEkran extends ListaPodatakaEkran {

	public ListaPorudzbinaEkran(final IzvorPodataka izvorPodataka)  {
		super(izvorPodataka);
		
		if(this.dostavljac != null) {
			btnObrisi.setEnabled(false);
			dodajBtn.setEnabled(false);
		}
	}

	@Override
	public void dodajAkcija() {
		otvoriPorudzbinaEkran();
	}

	@Override
	public void izmeniAkcija() {
		otvoriPorudzbinaEkranIzmena();
	}

	@Override
	public void obrisiAkcija() {
		brisanjePorudzbine();
	}

	private void otvoriPorudzbinaEkran() {
		PorudzbinaEkran porudzbinaEkran = new PorudzbinaEkran(izvorPodataka, this, null);
		porudzbinaEkran.setVisible(true);
	}

	private void otvoriPorudzbinaEkranIzmena() {
		Porudzbina porudzbina = uzmiSelektovanuPorudzbinu();
		
		boolean izmena = daLiJeMogucaIzmena(porudzbina);
		if(izmena) {
			PorudzbinaEkran porudzbinaEkran = new PorudzbinaEkran(izvorPodataka, this, porudzbina);
			porudzbinaEkran.setVisible(true);
		}
	}

	private boolean daLiJeMogucaIzmena(Porudzbina porudzbina) {
		
		if(porudzbina == null) {
			JOptionPane.showMessageDialog( null, "Morate selektovati porudzbinu!", "OK",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(porudzbina.getDostavljac() != null) {
			JOptionPane.showMessageDialog( null, "Dostava u toku! Nije moguce menjati porudzbinu", "OK",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	private Porudzbina uzmiSelektovanuPorudzbinu() {
		if(tabela.getSelectedRow() == -1) {
			return null;
		}
		
		long id = Long.parseLong(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
		
		Porudzbina porudzbina = izvorPodataka.nadjiPorudzbinu(id);
		return porudzbina;
	}
	
	@Override
	public String[] dajKolone(){
		String[] kolone = new String[] { "ID", "Restoran", "Jelo", "Pice",
				"Vreme", "Kupac", "Dostavljac", "Ukupna cena", "Adresa", "Napomena" };
		return kolone;
	}
	
	@Override
	public void popuniRedove(Object[][] redovi, Object obj, int indexReda) {
		
		Porudzbina porudzbina = (Porudzbina) obj;

		redovi[indexReda][0] = porudzbina.getId();
		redovi[indexReda][1] = porudzbina.getRestoran().getNaziv();
		redovi[indexReda][2] = porudzbina.getJelo().getNaziv();
		redovi[indexReda][3] = getNazivPica(porudzbina);
		redovi[indexReda][4] = porudzbina.getVreme();
		redovi[indexReda][5] = porudzbina.getKupac().getIme()
				+ porudzbina.getKupac().getPrezime();
		redovi[indexReda][6] = getDostavljac(porudzbina);
		redovi[indexReda][7] = porudzbina.getUkupnaCena();
		redovi[indexReda][8] = porudzbina.getAdresa();
		redovi[indexReda][9] = porudzbina.getNapomena();
		
	}

	private String getDostavljac(Porudzbina porudzbina) {
		if(porudzbina.getDostavljac() == null) {
			return ""; 
		}
		
		return porudzbina.getDostavljac().getIme() + " " + porudzbina.getDostavljac().getPrezime();
	}

	@Override
	public List dajPodatke() {
		if (administrator != null) {
			return izvorPodataka.getPorudzbine();
		} else if (dostavljac != null) {
			return izvorPodataka.getPorudzbineZaDostavljaca(dostavljac);
		} else if (kupac != null) {
			return izvorPodataka.getPorudzbineZaKupca(kupac);
		}
		return null;
	}

	private Object getNazivPica(Porudzbina porudzbina) {
		if (porudzbina.getPice() != null) {
			return porudzbina.getPice().getNaziv();
		}
		return "";
	}
	


	private void brisanjePorudzbine() {
		Porudzbina porudzbina = uzmiSelektovanuPorudzbinu();
		
		boolean brisanje = daLiJeMoguceBrisanje(porudzbina);
		if(brisanje) {
			int r = JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Brisanje",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE); 
			if(r == 0) {
				izvorPodataka.getPorudzbine().remove(porudzbina);
				
				JOptionPane.showMessageDialog( null, "Porudzbina obrisana!", "OK",JOptionPane.INFORMATION_MESSAGE);
				popuniTabeluPodacima();
			}
		}
		
	}

	private boolean daLiJeMoguceBrisanje(Porudzbina porudzbina) {
		
		if(porudzbina == null) {
			JOptionPane.showMessageDialog( null, "Morate selektovati porudzbinu!", "OK",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
				
	    if(porudzbina.getDostavljac() != null){
			JOptionPane.showMessageDialog(null, 
					"Porudzbina preuzeta od strane dostavljaca! Nije moguce brisanje!", "OK",JOptionPane.INFORMATION_MESSAGE);
			return false;
	    }
	    
	    return true;
	}

}
