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

public class GlavniEkran extends JFrame {

	public GlavniEkran(final RadSaFajlom radSaFajlom, final IzvorPodataka izvorPodataka) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
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
	}

	public void setAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub

	}

	public void setIzvorPodataka(IzvorPodataka izvorPodataka) {
		// TODO Auto-generated method stub

	}

	public void pripremiZaAdmina() {
		System.out.println("pripremiZaAdmina");

	}

	public void pripremiZaDostavljaca() {
		System.out.println("pripremiZaDostavljaca");

	}

	public void setDostavljac(Dostavljac dostavljac) {
		// TODO Auto-generated method stub

	}

}
