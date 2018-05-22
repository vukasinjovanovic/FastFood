package ftn.vu.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame loginFrame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		loginFrame = new JFrame();
		loginFrame.setAutoRequestFocus(false);
		loginFrame.setBounds(100, 100, 408, 154);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setBounds(10, 11, 108, 14);
		loginFrame.getContentPane().add(lblKorisnickoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setBounds(10, 36, 108, 14);
		loginFrame.getContentPane().add(lblLozinka);
		
		textField = new JTextField();
		textField.setBounds(128, 8, 225, 20);
		loginFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 33, 225, 20);
		loginFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Odustani");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// akcija na klik: Odustani
				
				// ciste se teks polja
				textField.setText("");
				textField_1.setText("");
				
				// zatvara se forma i sam program
				loginFrame.dispose();
			}
		});
		btnNewButton_1.setBounds(227, 64, 89, 23);
		loginFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Prijavi se");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO: dodati proveru unetih kredencijala
				
				// kad je uspesno logovanje, otvara se glavni ekran
				GlavniEkran gFrame = new GlavniEkran();
				gFrame.setVisible(true);
				loginFrame.dispose();
			}
		});
		btnNewButton.setBounds(128, 64, 89, 23);
		loginFrame.getContentPane().add(btnNewButton);
	}
}
