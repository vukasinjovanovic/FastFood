package ftn.vu.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Pol;
import ftn.vu.model.TipVozila;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class NoviKorisnikEkran extends JDialog {
	private JTextField imeTextField;
	private JTextField prezimeTextField;
	private JTextField korsnickoImeTextField;
	private JTextField lozinkaTextField;
	private JTextField jmbgTextField;
	private JTextField plataTextField;
	private JTextField regOznakaTextField;

	public NoviKorisnikEkran(IzvorPodataka izvorPodataka) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.setBounds(10, 228, 89, 23);
		getContentPane().add(btnSacuvaj);
		
		JButton btnOdustani = new JButton("Odustani");
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
		
		JLabel lblTipVozila = new JLabel("Tip vozila:");
		lblTipVozila.setBounds(10, 181, 100, 14);
		getContentPane().add(lblTipVozila);
		
		JLabel lblRegOznaka = new JLabel("Reg, oznaka");
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
		
		JComboBox polComboBox = new JComboBox();
		polComboBox.setBounds(108, 56, 173, 20);
		polComboBox.addItem(Pol.MUSKI);
		polComboBox.addItem(Pol.ZENSKI);
		getContentPane().add(polComboBox);
		
		JComboBox tipVozilacomboBox = new JComboBox();
		tipVozilacomboBox.setBounds(108, 178, 173, 20);
		tipVozilacomboBox.addItem(TipVozila.AUTOMOBIL);
		tipVozilacomboBox.addItem(TipVozila.BICIKL);
		tipVozilacomboBox.addItem(TipVozila.KOMBI);
		tipVozilacomboBox.addItem(TipVozila.SKUTER);
		getContentPane().add(tipVozilacomboBox);
		setModal(true);
		
	}
}
