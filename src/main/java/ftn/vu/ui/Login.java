package ftn.vu.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame loginJFrame;
	private JTextField korisnickoImeTekstPolje;
	private JTextField lozinkaTekstPolje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Login loginProzor = new Login();
		loginProzor.loginJFrame.setVisible(true);
		
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginJFrame = new JFrame(); // novi objekat tipa JFrame
		loginJFrame.setBounds(100, 100, 408, 154); // dimenzije
		loginJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // prekini rad programa kad se svi prozori zatvore
		loginJFrame.setLocationRelativeTo(null); // prikazi formu na centru ekrana
		loginJFrame.getContentPane().setLayout(null); // koristi apsolutno pozicioniranje (pixel po pixel)
		
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
				System.out.println("Kliknuto na odustani!");
				// akcija na klik: Odustani
				
				// ciste se teks polja
				korisnickoImeTekstPolje.setText("");
				lozinkaTekstPolje.setText("");
				
				// zatvara se forma i sam program
				loginJFrame.dispose();
			}
		});
		odustaniDugme.setBounds(227, 64, 89, 23);
		loginJFrame.getContentPane().add(odustaniDugme);
		
		JButton prijaviSeDugme = new JButton("Prijavi se");
		prijaviSeDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Kliknuto na prijavi se!");
				
				// TODO: dodati proveru unetih kredencijala
				
				// kad je uspesno logovanje, otvara se glavni ekran
				GlavniEkran glavniEkran = new GlavniEkran();
				glavniEkran.setVisible(true);
				loginJFrame.dispose();
			}
		});
		prijaviSeDugme.setBounds(128, 64, 89, 23);
		loginJFrame.getContentPane().add(prijaviSeDugme);
	}
}
