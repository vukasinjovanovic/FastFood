package ftn.vu.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.Pol;
import ftn.vu.model.TipVozila;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoviKorisnikEkran extends JDialog {
	private JTextField imeTextField;
	private JTextField prezimeTextField;
	private JTextField korsnickoImeTextField;
	private JTextField lozinkaTextField;
	private JTextField jmbgTextField;
	private JTextField plataTextField;
	private JTextField regOznakaTextField;
	private JComboBox polComboBox;
	private JComboBox tipVozilacomboBox;
	private JLabel lblTipVozila;
	private JLabel lblRegOznaka;
	
	private boolean dodavanjeDostavljaca; 
	
	private IzvorPodataka izvorPodataka;

	public NoviKorisnikEkran(IzvorPodataka izvorPodataka) {
		this.izvorPodataka = izvorPodataka;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sacuvaj();
			}
		});
		btnSacuvaj.setBounds(10, 228, 89, 23);
		getContentPane().add(btnSacuvaj);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zatvori();
			}
		});
		btnOdustani.setBounds(108, 228, 89, 23);
		getContentPane().add(btnOdustani);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(10, 11, 100, 14);
		getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(10, 34, 100, 14);
		getContentPane().add(lblPrezime);
		
		JLabel lblPol = new JLabel("Pol:");
		lblPol.setBounds(10, 56, 100, 14);
		getContentPane().add(lblPol);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setBounds(10, 81, 100, 14);
		getContentPane().add(lblKorisnickoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setBounds(10, 106, 100, 14);
		getContentPane().add(lblLozinka);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(10, 131, 100, 14);
		getContentPane().add(lblJmbg);
		
		JLabel lblPlata = new JLabel("Plata:");
		lblPlata.setBounds(10, 156, 100, 14);
		getContentPane().add(lblPlata);
		
		lblTipVozila = new JLabel("Tip vozila:");
		lblTipVozila.setBounds(10, 181, 100, 14);
		getContentPane().add(lblTipVozila);
		
		lblRegOznaka = new JLabel("Reg, oznaka");
		lblRegOznaka.setBounds(10, 206, 100, 14);
		getContentPane().add(lblRegOznaka);
		
		imeTextField = new JTextField();
		imeTextField.setBounds(108, 8, 170, 20);
		getContentPane().add(imeTextField);
		imeTextField.setColumns(10);
		
		prezimeTextField = new JTextField();
		prezimeTextField.setBounds(108, 31, 170, 20);
		getContentPane().add(prezimeTextField);
		prezimeTextField.setColumns(10);
		
		korsnickoImeTextField = new JTextField();
		korsnickoImeTextField.setBounds(108, 81, 170, 20);
		getContentPane().add(korsnickoImeTextField);
		korsnickoImeTextField.setColumns(10);
		
		lozinkaTextField = new JTextField();
		lozinkaTextField.setBounds(108, 106, 170, 20);
		getContentPane().add(lozinkaTextField);
		lozinkaTextField.setColumns(10);
		
		jmbgTextField = new JTextField();
		jmbgTextField.setBounds(108, 128, 170, 20);
		getContentPane().add(jmbgTextField);
		jmbgTextField.setColumns(10);
		
		plataTextField = new JTextField();
		plataTextField.setBounds(108, 153, 170, 20);
		getContentPane().add(plataTextField);
		plataTextField.setColumns(10);
		
		regOznakaTextField = new JTextField();
		regOznakaTextField.setBounds(108, 203, 173, 20);
		getContentPane().add(regOznakaTextField);
		regOznakaTextField.setColumns(10);
		
		polComboBox = new JComboBox();
		polComboBox.setBounds(108, 56, 173, 20);
		polComboBox.addItem(Pol.MUSKI);
		polComboBox.addItem(Pol.ZENSKI);
		getContentPane().add(polComboBox);
		
		tipVozilacomboBox = new JComboBox();
		tipVozilacomboBox.setBounds(108, 178, 173, 20);
		tipVozilacomboBox.addItem(TipVozila.AUTOMOBIL);
		tipVozilacomboBox.addItem(TipVozila.BICIKL);
		tipVozilacomboBox.addItem(TipVozila.KOMBI);
		tipVozilacomboBox.addItem(TipVozila.SKUTER);
		getContentPane().add(tipVozilacomboBox);
		setModal(true);
		
	}
	
	private void zatvori() {
		this.dispose();
	}
	
	private void sacuvaj() {
		boolean rezultat = false;
		
		if(dodavanjeDostavljaca) {
			rezultat = sacuvajDostavljaca();
		} else {
			rezultat = sacuvajKupca();
		}
		
		if(rezultat) {
			// ako je cuvanje uspesno, zatvori ovaj prozor
			this.dispose();	
		}
		
	}


	private boolean sacuvajDostavljaca() {
		Dostavljac dostavljac = new Dostavljac();
		dostavljac.setId(izvorPodataka.dajSledeciId());
		dostavljac.setIme(imeTextField.getText());
		try {
			dostavljac.setJmbg(Long.parseLong(jmbgTextField.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dostavljac.setKorisnickoIme(korsnickoImeTextField.getText());
		dostavljac.setLozinka(lozinkaTextField.getText());
		try {
			dostavljac.setPlata(Double.parseDouble(plataTextField.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dostavljac.setPol(Pol.valueOf(polComboBox.getSelectedItem().toString()));
		dostavljac.setPrezime(prezimeTextField.getText());
		dostavljac.setRegistarskaOznakaVozila(regOznakaTextField.getText());
		dostavljac.setTipVozila(TipVozila.valueOf(tipVozilacomboBox.getSelectedItem().toString()));
		
		try {
			validirajDostavljaca(dostavljac);
			
			izvorPodataka.getDostavljaci().add(dostavljac);
			
			JOptionPane.showMessageDialog( null, "Dostavljac dodat!", "OK",JOptionPane.INFORMATION_MESSAGE);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, e.getMessage(), "Greška",JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
		
	}
	
	private void validirajDostavljaca(Dostavljac dostavljac) throws Exception {
		if(dostavljac.getIme() == null ||  "".equals(dostavljac.getIme())) {
			throw new Exception("Ime dostavljaca ne moze biti prazno!");
		}
		if(dostavljac.getPrezime() == null || "".equals(dostavljac.getPrezime())) {
			throw new Exception("Prezime dostavljaca ne moze biti prazno!");
		}
		
		// TODO: dodati validaciju za ostala polja
	}

	private boolean sacuvajKupca() {
		return false;
	}


	public void dodavanjeDostavljaca() {
		tipVozilacomboBox.setVisible(true);
		lblTipVozila.setVisible(true);
		regOznakaTextField.setVisible(true);
		lblRegOznaka.setVisible(true);
		
		dodavanjeDostavljaca = true;
	}

	public void dodavanjeKupca() {
		tipVozilacomboBox.setVisible(false);
		lblTipVozila.setVisible(false);
		regOznakaTextField.setVisible(false);
		lblRegOznaka.setVisible(false);
		
		dodavanjeDostavljaca = false;
	}
}
