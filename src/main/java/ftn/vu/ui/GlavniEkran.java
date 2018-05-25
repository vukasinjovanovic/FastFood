package ftn.vu.ui;

import javax.swing.JFrame;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;

public class GlavniEkran extends JFrame {


	public GlavniEkran() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
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
