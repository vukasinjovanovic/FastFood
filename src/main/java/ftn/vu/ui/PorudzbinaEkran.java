package ftn.vu.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.Jelo;
import ftn.vu.model.Kupac;
import ftn.vu.model.Pice;
import ftn.vu.model.Porudzbina;
import ftn.vu.model.Restoran;
import ftn.vu.ui.pomoc.DostavljacConboItem;
import ftn.vu.ui.pomoc.JeloComboItem;
import ftn.vu.ui.pomoc.KupacComboItem;
import ftn.vu.ui.pomoc.PiceComboItem;
import ftn.vu.ui.pomoc.RestoranComboItem;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

public class PorudzbinaEkran extends JDialog {

	private IzvorPodataka izvorPodataka;

	private ListaPorudzbinaEkran listaPorudzbinaEkran;

	private JComboBox restoranComboBox;

	private JComboBox jeloComboBox;

	private JComboBox piceComboBox;

	private JComboBox kupacComboBox;

	private JComboBox dostavljacComboBox;

	private Porudzbina porudzbina;

	private JButton btnSacuvaj;
	
	private JButton btnOdustani;


	public PorudzbinaEkran(IzvorPodataka izvorPodataka,
			ListaPorudzbinaEkran listaPorudzbinaEkran, Porudzbina porudzbina) {
		this.izvorPodataka = izvorPodataka;
		this.listaPorudzbinaEkran = listaPorudzbinaEkran;
		this.porudzbina = porudzbina;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sacuvajPorudzbinu();
			}
		});
		btnSacuvaj.setBounds(10, 228, 89, 23);
		getContentPane().add(btnSacuvaj);

		btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(111, 228, 89, 23);
		getContentPane().add(btnOdustani);

		JLabel lblRestoran = new JLabel("Restoran:");
		lblRestoran.setBounds(10, 26, 100, 14);
		getContentPane().add(lblRestoran);

		JLabel lblJelo = new JLabel("Jelo:");
		lblJelo.setBounds(10, 51, 100, 14);
		getContentPane().add(lblJelo);

		JLabel lblPice = new JLabel("Pice:");
		lblPice.setBounds(10, 76, 100, 14);
		getContentPane().add(lblPice);

		JLabel lblKupac = new JLabel("Kupac:");
		lblKupac.setBounds(10, 129, 100, 14);
		getContentPane().add(lblKupac);

		JLabel lblDostavljac = new JLabel("Dostavljac:");
		lblDostavljac.setBounds(10, 154, 100, 14);
		getContentPane().add(lblDostavljac);

		restoranComboBox = new JComboBox();
		restoranComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restoranPromenjenDogadjaj();
			}
		});
		restoranComboBox.setBounds(120, 23, 150, 20);
		getContentPane().add(restoranComboBox);

		jeloComboBox = new JComboBox();
		jeloComboBox.setBounds(120, 48, 150, 20);
		getContentPane().add(jeloComboBox);

		piceComboBox = new JComboBox();
		piceComboBox.setBounds(120, 73, 150, 20);
		getContentPane().add(piceComboBox);

		kupacComboBox = new JComboBox();
		kupacComboBox.setBounds(120, 126, 150, 20);
		getContentPane().add(kupacComboBox);

		dostavljacComboBox = new JComboBox();
		dostavljacComboBox.setBounds(120, 151, 150, 20);
		getContentPane().add(dostavljacComboBox);
		setModal(true);

		popuniPocetnePodatke();

		pripremiZaIzmenu();
	}

	protected void restoranPromenjenDogadjaj() {

		Restoran restoran = ((RestoranComboItem) restoranComboBox
				.getSelectedItem()).getRestoran();

		List<Jelo> jela = izvorPodataka.pronadjiJela(restoran);

		jeloComboBox.removeAllItems();
		for (Jelo jelo : jela) {
			jeloComboBox.addItem(new JeloComboItem(jelo));
		}

		List<Pice> pica = izvorPodataka.pronadjiPica(restoran);

		piceComboBox.removeAllItems();
		for (Pice pice : pica) {
			piceComboBox.addItem(new PiceComboItem(pice));
		}

		piceComboBox.setSelectedIndex(-1);

		pripremiZaIzmenu();

	}

	private void popuniPocetnePodatke() {

		for (Restoran restoran : izvorPodataka.getRestorani()) {
			restoranComboBox.addItem(new RestoranComboItem(restoran));
		}

		if (izvorPodataka.getUlogovaniAdministrator() != null) {

			for (Kupac kupac : izvorPodataka.getKupci()) {
				kupacComboBox.addItem(new KupacComboItem(kupac));
			}

			for (Dostavljac dostavljac : izvorPodataka.getDostavljaci()) {
				dostavljacComboBox.addItem(new DostavljacConboItem(dostavljac));
			}

			dostavljacComboBox.setSelectedIndex(-1);

		} else if (izvorPodataka.getUlogovaniKupac() != null) {
			kupacComboBox.addItem(new KupacComboItem(izvorPodataka
					.getUlogovaniKupac()));

			// kupac ne bira dostavljaca
			dostavljacComboBox.setEnabled(false);
		} else if (izvorPodataka.getUlogovaniDostavljac() != null) {

			dostavljacComboBox.addItem(new DostavljacConboItem(izvorPodataka
					.getUlogovaniDostavljac()));
			
			for (Kupac kupac : izvorPodataka.getKupci()) {
				kupacComboBox.addItem(new KupacComboItem(kupac));
			}

			// dostavljac ne bira kupca
			kupacComboBox.setEnabled(false);
		}

	}

	private void sacuvajPorudzbinu() {
		Restoran restoran = ((RestoranComboItem) restoranComboBox
				.getSelectedItem()).getRestoran();

		Jelo jelo = null;
		if (jeloComboBox.getSelectedIndex() != -1) {
			jelo = ((JeloComboItem) jeloComboBox.getSelectedItem())
					.getJelo();
		}

		Pice pice = null;
		if (piceComboBox.getSelectedIndex() != -1) {
			pice = ((PiceComboItem) piceComboBox.getSelectedItem())
					.getPice();
		}

		Kupac kupac = ((KupacComboItem) kupacComboBox.getSelectedItem())
				.getKupac();

		Dostavljac dostavljac = null;
		if (dostavljacComboBox.getSelectedIndex() != -1) {
			dostavljac = ((DostavljacConboItem) dostavljacComboBox
					.getSelectedItem()).getDostavljac();
		}
		
		if (this.porudzbina != null) {
			
			try {
				Porudzbina test = new Porudzbina(this.porudzbina.getId(), restoran, jelo, pice, new Date(), kupac, dostavljac);
				
				int index = izvorPodataka.getPorudzbine().indexOf(this.porudzbina);
				izvorPodataka.getPorudzbine().remove(index);
				izvorPodataka.getPorudzbine().add(index , test);	
				this.porudzbina = test;
				
				listaPorudzbinaEkran.postaviPorudzbneUTabelu();
				
				JOptionPane.showMessageDialog(null, "Porudzbina izmenjena!", "OK",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Greška",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {

			try {
				Porudzbina porudzbina = new Porudzbina(
						izvorPodataka.dajSledeciId(), restoran, jelo, pice,
						new Date(), kupac, dostavljac);

				izvorPodataka.getPorudzbine().add(porudzbina);
				listaPorudzbinaEkran.postaviPorudzbneUTabelu();
				JOptionPane.showMessageDialog(null, "Porudzbina dodata!", "OK",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Greška",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	private void pripremiZaIzmenu() {
		if (this.porudzbina != null) {
			btnSacuvaj.setText("Sacuvaj izmene");
			btnSacuvaj.setBounds(btnSacuvaj.getX(), btnSacuvaj.getY(),
					btnSacuvaj.getWidth() + 15, btnSacuvaj.getHeight());
			btnOdustani.setBounds(btnOdustani.getX() + 15, btnOdustani.getY(),
					btnOdustani.getWidth(), btnOdustani.getHeight());
			

			// selektuj restoran
			restoranComboBox.setSelectedItem(new RestoranComboItem(porudzbina
					.getRestoran()));

			// selektuj jelo
			jeloComboBox
					.setSelectedItem(new JeloComboItem(porudzbina.getJelo()));

			// selektuj pice
			if (porudzbina.getPice() == null) {
				piceComboBox.setSelectedIndex(-1);
			} else {
				piceComboBox.setSelectedItem(new PiceComboItem(porudzbina
						.getPice()));
			}

			// selektuj kupca
			kupacComboBox.setSelectedItem(new KupacComboItem(porudzbina
					.getKupac()));

			// selektuj dostavljaca
			if (porudzbina.getDostavljac() == null) {
				dostavljacComboBox.setSelectedIndex(-1);
			} else {
				dostavljacComboBox.setSelectedItem(new DostavljacConboItem(
						porudzbina.getDostavljac()));
			}

			if (izvorPodataka.getUlogovaniAdministrator() != null) {
				restoranComboBox.setEnabled(true);
				jeloComboBox.setEnabled(true);
				piceComboBox.setEnabled(true);
				kupacComboBox.setEnabled(false);
				dostavljacComboBox.setEnabled(true);
			} else if (izvorPodataka.getUlogovaniKupac() != null) {
				restoranComboBox.setEnabled(true);
				jeloComboBox.setEnabled(true);
				piceComboBox.setEnabled(true);
				kupacComboBox.setEnabled(false);
				dostavljacComboBox.setEnabled(false);
			} else if (izvorPodataka.getUlogovaniDostavljac() != null) {
				restoranComboBox.setEnabled(false);
				jeloComboBox.setEnabled(false);
				piceComboBox.setEnabled(false);
				kupacComboBox.setEnabled(false);
				dostavljacComboBox.setEnabled(true);
			}

		}

	}
}
