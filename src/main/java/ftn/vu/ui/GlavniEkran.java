package ftn.vu.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;

public class GlavniEkran extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel glavniPanel;

	public GlavniEkran() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		glavniPanel = new JPanel();
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		glavniPanel.setLayout(null);
		setContentPane(glavniPanel);
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
