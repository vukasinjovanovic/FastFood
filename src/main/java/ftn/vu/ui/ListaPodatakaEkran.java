package ftn.vu.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.Kupac;

public abstract class ListaPodatakaEkran extends JDialog {
	protected IzvorPodataka izvorPodataka;

	protected Administrator administrator = null;
	protected Kupac kupac = null;
	protected Dostavljac dostavljac = null;
	
	protected JTable tabela = new JTable();;
	protected JButton dodajBtn = new JButton("Dodaj");
	protected JButton izmeniBtn = new JButton("Izmeni");
	protected JButton btnObrisi = new JButton("Obrisi");
	
	public ListaPodatakaEkran(final IzvorPodataka izvorPodataka){
		this.izvorPodataka = izvorPodataka;
		this.administrator = izvorPodataka.getUlogovaniAdministrator();
		this.kupac = izvorPodataka.getUlogovaniKupac();
		this.dostavljac = izvorPodataka.getUlogovaniDostavljac();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 504);
		setLocationRelativeTo(null);
		setModal(true);
		
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajAkcija();
			}
		});
		
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izmeniAkcija();
			}
		});
		
		
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obrisiAkcija();
			}
		});
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(dodajBtn, BorderLayout.WEST);
		panel.add(izmeniBtn, BorderLayout.WEST);
		panel.add(btnObrisi, BorderLayout.WEST);
		getContentPane().add(panel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane(tabela);

		getContentPane().add(scrollPane, BorderLayout.CENTER);
		

		// Neka standardna podesavanja JTable komponente:
		// Dozvoljeno selektovanje redova
		tabela.setRowSelectionAllowed(true);
		// Ali ne i selektovanje kolona
		tabela.setColumnSelectionAllowed(false);
		// Dozvoljeno selektovanje samo jednog reda odjednom
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Onemoguceno je direktno editovanje sadrzaja u celijama
		tabela.setDefaultEditor(Object.class, null);
		
		popuniTabeluPodacima();
	}

	public abstract void dodajAkcija();
	
	public abstract void izmeniAkcija();
	
	public abstract void  obrisiAkcija();
	

	public void popuniTabeluPodacima()  {
   
		List podaci = dajPodatke();
		
		if(podaci != null && !podaci.isEmpty()) {
			
			String[] kolone = dajKolone();
			
			Object[][] redovi = new Object[podaci.size()][kolone.length];

			int index = 0;
			for (Object obj : podaci) {
				
				popuniRedove(redovi, obj, index);
				
				index++;
			}

			DefaultTableModel model = new DefaultTableModel(redovi, kolone);

			tabela.setModel(model);

		} else {
			JOptionPane.showMessageDialog(null, "Nema podataka za zadate kriterijume!", "OK",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	public abstract void popuniRedove(Object[][] redovi, Object obj, int index);

	public abstract String[] dajKolone();

	public abstract List dajPodatke();
	
}
