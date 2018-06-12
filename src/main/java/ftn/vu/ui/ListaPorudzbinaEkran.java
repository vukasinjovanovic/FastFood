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

public class ListaPorudzbinaEkran extends JDialog {
	private JTable tabela;
	private IzvorPodataka izvorPodataka;

	private Administrator administrator = null;
	private Kupac kupac = null;
	private Dostavljac dostavljac = null;

	public ListaPorudzbinaEkran(final IzvorPodataka izvorPodataka)  {
		this.izvorPodataka = izvorPodataka;
		this.administrator = izvorPodataka.getUlogovaniAdministrator();
		this.kupac = izvorPodataka.getUlogovaniKupac();
		this.dostavljac = izvorPodataka.getUlogovaniDostavljac();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 504);
		setLocationRelativeTo(null);
		setModal(true);

		JButton dodajBtn = new JButton("Dodaj");
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				otvoriPorudzbinaEkran();
			}
		});
		JButton izmeniBtn = new JButton("Izmeni");
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				otvoriPorudzbinaEkranIzmena();
			}
		});

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(dodajBtn, BorderLayout.WEST);
		panel.add(izmeniBtn, BorderLayout.WEST);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brisanjePorudzbine();
			}
		});
		panel.add(btnObrisi);

		tabela = new JTable();

		JScrollPane scrollPane = new JScrollPane(tabela);

		getContentPane().add(scrollPane, BorderLayout.CENTER);

		postaviPorudzbneUTabelu();
		
		if(this.dostavljac != null) {
			btnObrisi.setEnabled(false);
			dodajBtn.setEnabled(false);
		}

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

	public void postaviPorudzbneUTabelu()  {

   
		List<Porudzbina> porudzbine = getPorudzbine();
		
		if(porudzbine != null && !porudzbine.isEmpty()) {
			
			String[] kolone = new String[] { "ID", "Restoran", "Jelo", "Pice",
					"Vreme", "Kupac", "Dostavljac", "Ukupna cena", "Adresa", "Napomena" };
			
			Object[][] redovi = new Object[porudzbine.size()][kolone.length];

			int index = 0;
			for (Porudzbina porudzbina : porudzbine) {

				redovi[index][0] = porudzbina.getId();
				redovi[index][1] = porudzbina.getRestoran().getNaziv();
				redovi[index][2] = porudzbina.getJelo().getNaziv();
				redovi[index][3] = getNazivPica(porudzbina);
				redovi[index][4] = porudzbina.getVreme();
				redovi[index][5] = porudzbina.getKupac().getIme()
						+ porudzbina.getKupac().getPrezime();
				redovi[index][6] = getDostavljac(porudzbina);
				redovi[index][7] = porudzbina.getUkupnaCena();
				redovi[index][8] = porudzbina.getAdresa();
				redovi[index][9] = porudzbina.getNapomena();
				
				index++;
			}

			DefaultTableModel model = new DefaultTableModel(redovi, kolone);

			tabela.setModel(model);

			// Neka standardna podesavanja JTable komponente:
			// Dozvoljeno selektovanje redova
			tabela.setRowSelectionAllowed(true);
			// Ali ne i selektovanje kolona
			tabela.setColumnSelectionAllowed(false);
			// Dozvoljeno selektovanje samo jednog reda odjednom
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// Onemoguceno je direktno editovanje sadrzaja u celijama
			tabela.setDefaultEditor(Object.class, null);
		} else {
			JOptionPane.showMessageDialog(null, "Nema vidljivih porudzbina!", "OK",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	private String getDostavljac(Porudzbina porudzbina) {
		if(porudzbina.getDostavljac() == null) {
			return ""; 
		}
		
		return porudzbina.getDostavljac().getIme() + " " + porudzbina.getDostavljac().getPrezime();
	}

	private List<Porudzbina> getPorudzbine() {
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
				postaviPorudzbneUTabelu();
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
