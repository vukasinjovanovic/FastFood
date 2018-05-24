package ftn.vu.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ftn.vu.fajl.RadSaFajlom;
import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {

	private JFrame loginJFrame;
	private JTextField korisnickoImeTekstPolje;
	private JTextField lozinkaTekstPolje;
	private JLabel porukaLabela;
	
	private IzvorPodataka izvorPodataka;

	public static void main(String[] args) throws IOException {
		
		RadSaFajlom radSaFajlom = new RadSaFajlom();
		
		Login loginProzor = new Login();
		loginProzor.izvorPodataka = radSaFajlom.citajFajlove();
		loginProzor.loginJFrame.setVisible(true);
		
	}

	public Login() {
		inicijalizuj();
	}

	private void inicijalizuj() {
		loginJFrame = new JFrame();
		loginJFrame.setAutoRequestFocus(false);
		loginJFrame.setBounds(100, 100, 408, 180);
		loginJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginJFrame.getContentPane().setLayout(null);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setBounds(10, 11, 108, 14);
		loginJFrame.getContentPane().add(lblKorisnickoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setBounds(10, 36, 108, 14);
		loginJFrame.getContentPane().add(lblLozinka);
		
		korisnickoImeTekstPolje = new JTextField();
		korisnickoImeTekstPolje.setBounds(128, 8, 225, 20);
		loginJFrame.getContentPane().add(korisnickoImeTekstPolje);
		korisnickoImeTekstPolje.setColumns(10);
		
		lozinkaTekstPolje = new JTextField();
		lozinkaTekstPolje.setBounds(128, 33, 225, 20);
		loginJFrame.getContentPane().add(lozinkaTekstPolje);
		lozinkaTekstPolje.setColumns(10);
		
		JButton odustaniDugme = new JButton("Odustani");
		odustaniDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// akcija na klik: Odustani
				
				// ciste se teks polja
				korisnickoImeTekstPolje.setText("");
				lozinkaTekstPolje.setText("");
				
				// zatvara se forma i sam program
				loginJFrame.dispose();
			}
		});
		odustaniDugme.setBounds(225, 92, 89, 23);
		loginJFrame.getContentPane().add(odustaniDugme);
		
		JButton prijaviSeDugme = new JButton("Prijavi se");
		prijaviSeDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Administrator administrator = izvorPodataka.pronadjiAdmina(korisnickoImeTekstPolje.getText(), lozinkaTekstPolje.getText());
				
				if(administrator != null) {
					// kad je uspesno logovanje, otvara se glavni ekran
					GlavniEkran glavniEkran = new GlavniEkran();
					glavniEkran.setVisible(true);
					glavniEkran.setAdministrator(administrator);
					glavniEkran.setIzvorPodataka(izvorPodataka);
					glavniEkran.pripremiZaAdmina();
					loginJFrame.dispose();
					return;
				}
				
				Dostavljac dostavljac = izvorPodataka.pronadjiDostavljaca(korisnickoImeTekstPolje.getText(), lozinkaTekstPolje.getText());
				
				if(dostavljac != null) {
					GlavniEkran glavniEkran = new GlavniEkran();
					glavniEkran.setVisible(true);
					glavniEkran.setDostavljac(dostavljac);
					glavniEkran.setIzvorPodataka(izvorPodataka);
					glavniEkran.pripremiZaDostavljaca();
					loginJFrame.dispose();
					return;
				}
				
				if(administrator == null) {
					porukaLabela.setVisible(true);
				}

			}
		});
		prijaviSeDugme.setBounds(128, 92, 89, 23);
		loginJFrame.getContentPane().add(prijaviSeDugme);
		
		porukaLabela = new JLabel("Neuspesno logovanje!");
		porukaLabela.setForeground(Color.RED);
		porukaLabela.setBounds(128, 64, 225, 14);
		porukaLabela.setVisible(false);
		loginJFrame.getContentPane().add(porukaLabela);
	}
}
