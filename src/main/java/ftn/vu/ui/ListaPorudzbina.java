package ftn.vu.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Porudzbina;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class ListaPorudzbina extends JDialog {
	private JTable tabela;
	private IzvorPodataka izvorPodataka;
	
	public ListaPorudzbina(IzvorPodataka izvorPodataka) {
		this.izvorPodataka = izvorPodataka;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 504);
		setLocationRelativeTo(null);
		setModal(true);
		
		JButton dodajBtn = new JButton("Dodaj");
		JButton izmeniBtn = new JButton("Izmeni");
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(dodajBtn, BorderLayout.WEST);
		panel.add(izmeniBtn, BorderLayout.WEST);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		tabela = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		postaviPorudzbneUTabelu();
		
		
	}

	private void postaviPorudzbneUTabelu() {
		String [] kolone = new String [] {"ID", "Restoran", "Jelo", "Pice", "Vreme", "Kupac", "Dostavljac"};
		
		Object [][] redovi = new  Object[izvorPodataka.getPorudzbine().size()][kolone.length];
		
		int index = 0;
		for (Porudzbina porudzbina : izvorPodataka.getPorudzbine()) {
			
			redovi[index][0] = porudzbina.getId();
			redovi[index][1] = porudzbina.getRestoran().getNaziv();
			redovi[index][2] = porudzbina.getJelo().getNaziv();
			redovi[index][3] = getNazivPica(porudzbina);
			redovi[index][4] = porudzbina.getVreme();
			redovi[index][5] = porudzbina.getKupac().getIme() + porudzbina.getKupac().getPrezime();
			redovi[index][6] = porudzbina.getDostavljac().getIme() + porudzbina.getDostavljac().getPrezime();
			
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
		
	}

	private Object getNazivPica(Porudzbina porudzbina) {
		if(porudzbina.getPice() != null) {
			return porudzbina.getPice().getNaziv();
		}
		return "";
	}
	
	
	
}
