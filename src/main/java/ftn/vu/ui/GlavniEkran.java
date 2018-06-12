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
import ftn.vu.model.Kupac;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniEkran extends JFrame {
	
	private Administrator administrator = null;
	private Kupac kupac = null;
	private Dostavljac dostavljac = null;
	
	
	JButton btnDodajDostavljaca = new JButton("Dostavljaci");
	JButton dodajKupcaBtn = new JButton("Kupci");
	JButton listaPorudzbinaBtn = new JButton("Porudzbine");
	JButton btnRestorani = new JButton("Restorani");
	JButton btnJela = new JButton("Jela");
	JButton btnPice = new JButton("Pice");

	public GlavniEkran(final RadSaFajlom radSaFajlom, final IzvorPodataka izvorPodataka) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		dodajDogadjaje(radSaFajlom, izvorPodataka);
		
		sakriSveElemente();
	}

	private void sakriSveElemente() {
		btnDodajDostavljaca.setEnabled(false);
		dodajKupcaBtn.setEnabled(false);
		listaPorudzbinaBtn.setEnabled(false);
		btnRestorani.setEnabled(false);
		btnJela.setEnabled(false);
		btnPice.setEnabled(false);
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
				ListaDostavljacaEkran listaDostavljacaEkran = new ListaDostavljacaEkran(izvorPodataka);
				listaDostavljacaEkran.setVisible(true);
			}
		});
		
		btnDodajDostavljaca.setBounds(10, 29, 147, 23);
		getContentPane().add(btnDodajDostavljaca);

		dodajKupcaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListaKupacaEkran listaKupacaEkran = new ListaKupacaEkran(izvorPodataka);
				listaKupacaEkran.setVisible(true);
				
			}
		});
		dodajKupcaBtn.setBounds(10, 63, 147, 23);
		getContentPane().add(dodajKupcaBtn);
		
		
		listaPorudzbinaBtn.setBounds(10, 97, 147, 23);
		listaPorudzbinaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPorudzbinaEkran porudzbine = new ListaPorudzbinaEkran(izvorPodataka);
				porudzbine.setVisible(true);
			}
		});
		
		btnRestorani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaRestoranaEkran listaRestoranaEkran = new ListaRestoranaEkran(izvorPodataka);
				listaRestoranaEkran.setVisible(true);
			}
		});
		
		btnJela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaJelaEkran listaJelaEkran = new ListaJelaEkran(izvorPodataka);
				listaJelaEkran.setVisible(true);
			}
		});
		
		btnPice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPicaEkran listaPicaEkran = new ListaPicaEkran(izvorPodataka);
				listaPicaEkran.setVisible(true);
			}
		});
		
		getContentPane().add(listaPorudzbinaBtn);
		
		
		btnRestorani.setBounds(10, 132, 147, 23);
		getContentPane().add(btnRestorani);
		
		
		btnJela.setBounds(10, 166, 147, 23);
		getContentPane().add(btnJela);
		
		
		btnPice.setBounds(10, 200, 147, 23);
		getContentPane().add(btnPice);
		
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public void pripremiZaAdmina() {
		System.out.println("U metodi pripremiZaAdmina");
		btnDodajDostavljaca.setEnabled(true);
		listaPorudzbinaBtn.setEnabled(true);
		dodajKupcaBtn.setEnabled(true);
		btnRestorani.setEnabled(true);
		btnJela.setEnabled(true);
		btnPice.setEnabled(true);
	}

	public void setDostavljac(Dostavljac dostavljac) {
		this.dostavljac = dostavljac;
	}
	
	public void pripremiZaDostavljaca() {
		System.out.println("U metodi pripremiZaDostavljaca");
		listaPorudzbinaBtn.setEnabled(true);
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public void pripremiZaKupca() {
		System.out.println("U metodi pripremiZaKupca");
		listaPorudzbinaBtn.setEnabled(true);
	}
}
