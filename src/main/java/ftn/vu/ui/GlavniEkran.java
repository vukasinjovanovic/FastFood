package ftn.vu.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;

import ftn.vu.fajl.RadSaFajlom;
import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniEkran extends JFrame {
	
	private Administrator administrator = null;
	
	
	JButton btnDodajDostavljaca = new JButton("Dodaj dostavljaca");

	public GlavniEkran(final RadSaFajlom radSaFajlom, final IzvorPodataka izvorPodataka) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		dodajDogadjaje(radSaFajlom, izvorPodataka);
		
		sakriSveElemente();
	}

	private void sakriSveElemente() {
		btnDodajDostavljaca.setVisible(false);
	}

	private void dodajDogadjaje(final RadSaFajlom radSaFajlom, final IzvorPodataka izvorPodataka) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
				try {
					radSaFajlom.pisiFajlove(izvorPodataka);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		
		
		btnDodajDostavljaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoviKorisnikEkran nke = new NoviKorisnikEkran(izvorPodataka);
				nke.dodavanjeDostavljaca();
				nke.setVisible(true);
			}
		});
		
		btnDodajDostavljaca.setBounds(10, 29, 147, 23);
		getContentPane().add(btnDodajDostavljaca);
		
		JButton dodajKupcaBtn = new JButton("Dodaj kupca");
		dodajKupcaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoviKorisnikEkran nke = new NoviKorisnikEkran(izvorPodataka);
				nke.dodavanjeKupca();
				nke.setVisible(true);
				
			}
		});
		dodajKupcaBtn.setBounds(10, 63, 147, 23);
		getContentPane().add(dodajKupcaBtn);
		
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public void pripremiZaAdmina() {
		System.out.println("U metodi pripremiZaAdmina");
		btnDodajDostavljaca.setVisible(true);
	}

	public void pripremiZaDostavljaca() {
		System.out.println("U metodi pripremiZaDostavljaca");

	}

	public void setDostavljac(Dostavljac dostavljac) {
		// TODO Auto-generated method stub

	}
}
