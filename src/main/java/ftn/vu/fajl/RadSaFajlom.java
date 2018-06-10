package ftn.vu.fajl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.Jelo;
import ftn.vu.model.Kategorija;
import ftn.vu.model.Kupac;
import ftn.vu.model.Pice;
import ftn.vu.model.Pol;
import ftn.vu.model.Porudzbina;
import ftn.vu.model.Restoran;
import ftn.vu.model.TipVozila;

public class RadSaFajlom {
	
	public static final String ADMINISTRATOR_FAJL = "src/main/resources/administrator.txt";
	public static final String DOSTAVLJAC_FAJL = "src/main/resources/dostavljac.txt";
	public static final String KUPAC_FAJL = "src/main/resources/kupac.txt";
	public static final String JELO_FAJL = "src/main/resources/jelo.txt";
	public static final String PICE_FAJL = "src/main/resources/pice.txt";
	public static final String RESTORAN_FAJL = "src/main/resources/restoran.txt";
	public static final String PORUDZBINA_FAJL = "src/main/resources/porudzbina.txt";
	
	long maxId = 0;
	
	IzvorPodataka izvorPodataka;
	
	public RadSaFajlom() {
	}

	public IzvorPodataka citajFajlove() throws Exception {
		
		System.out.println("Ucitavanje fajlova START!");
		
	    izvorPodataka = new IzvorPodataka();
	    
	    List<String> linijeAdmin = citajFajl(ADMINISTRATOR_FAJL);
		
	    List<Administrator> administratori = parsirajAdministratore(linijeAdmin);
	    
	    izvorPodataka.setAdministratori(administratori);
	    
	    
	    List<String> linijeDostavljac = citajFajl(DOSTAVLJAC_FAJL);
	    
	    List<Dostavljac> dostavljaci = parsirajDostavljace(linijeDostavljac);
	    
	    izvorPodataka.setDostavljaci(dostavljaci);
	    
	    
	    List<String> linijeKupac = citajFajl(KUPAC_FAJL);
	    
	    List<Kupac> kupci = parsirajKupce(linijeKupac);
	    
	    izvorPodataka.setKupci(kupci);
	    
	    List<String> linijeRestorani = citajFajl(RESTORAN_FAJL);
	    
	    List<Restoran> restoran = parsirajRestorane(linijeRestorani);
	    
	    izvorPodataka.setRestorani(restoran);
	    
	    
	    List<String> linijeJela = citajFajl(JELO_FAJL);
	    
	    List<Jelo> jela = parsirajJela(linijeJela);
	    
	    izvorPodataka.setJela(jela);
	    
	    List<String> linijePice = citajFajl(PICE_FAJL);
	    
	    List<Pice> pica = parsirajPica(linijePice);
	    
	    izvorPodataka.setPice(pica);
	    
	    List<String> linijePorudzbine = citajFajl(PORUDZBINA_FAJL);
	    
	    List<Porudzbina> porudzbine = parsirajPorudzbine(linijePorudzbine);
	    
	    izvorPodataka.setPorudzbine(porudzbine);
	    
	    
	    izvorPodataka.setMaxId(this.maxId);
	    
	    System.out.println("Ucitavanje fajlova KRAJ!");
	    
		return izvorPodataka;
	}


	public void pisiFajlove(IzvorPodataka izvorPodataka) throws IOException {
		
		System.out.println("Pisanje u fajlove START!");
		
		pisiPodatke(izvorPodataka.getAdministratori(), ADMINISTRATOR_FAJL);
		
		pisiPodatke(izvorPodataka.getDostavljaci(), DOSTAVLJAC_FAJL);
		
		pisiPodatke(izvorPodataka.getKupci(), KUPAC_FAJL);
		
		pisiPodatke(izvorPodataka.getJela(), JELO_FAJL);
		
		pisiPodatke(izvorPodataka.getPice(), PICE_FAJL);
		
		pisiPodatke(izvorPodataka.getRestorani(), RESTORAN_FAJL);
		
		pisiPodatke(izvorPodataka.getPorudzbine(), PORUDZBINA_FAJL);
		
		System.out.println("Pisanje u fajlove KRAJ!");
	
	} 

	private void pisiPodatke(Collection list, String imeFajla) throws IOException {
		
		String sadrzaj = konvertujUTxt(list);
		
		pisiUFajl(sadrzaj, imeFajla);
		
	}
	
	private void pisiUFajl(String sadrzaj, String imeFajla) throws IOException {
		File artikliFile = new File(imeFajla);
		BufferedWriter writer = new BufferedWriter(new FileWriter(artikliFile));
		writer.write(sadrzaj);
		writer.close();
	}

	private String konvertujUTxt(Collection list) {
		String rezultat = "";
		for (Object obj: list) {
			rezultat = rezultat + obj.toString() + "\n";
		}
		System.out.println(rezultat);
		return rezultat;
	}

	private List<String> citajFajl(String fajl) throws IOException {
		
		List<String> linije = new ArrayList<String>();
		File file = new File(fajl);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String linija;
			while ((linija = reader.readLine()) != null) {
				System.out.println(linija);
				linije.add(linija);
			}
			
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		
		return linije;
	}
	
	
	private List<Administrator> parsirajAdministratore(List<String> linijeAdmin) {
		List<Administrator> admini = new ArrayList<Administrator>();
		
		for (String adminString : linijeAdmin) {
			Administrator administrator = new Administrator();
			String [] polja = adminString.split("\\|");
			administrator.setId(Long.parseLong(polja[0]));
			administrator.setIme(polja[1]);
			administrator.setPrezime(polja[2]);
			administrator.setPol(Pol.valueOf(polja[3]));
			administrator.setKorisnickoIme(polja[4]);
			administrator.setLozinka(polja[5]);
			administrator.setJmbg(Long.parseLong(polja[6]));
			administrator.setPlata(Double.parseDouble(polja[7]));
			
			postaviMaxId(administrator.getId());
			
			admini.add(administrator);
		}
		
		return admini;
	}
	
	
	private void postaviMaxId(long id) {
		if(id > maxId) {
			maxId = id;
		}
	}

	private List<Dostavljac> parsirajDostavljace(List<String> linijeDostavljac) {
		List<Dostavljac> dostavljaci = new ArrayList<Dostavljac>();
		
		for (String dostavljacString : linijeDostavljac) {
			Dostavljac dostavljac = new Dostavljac();
			String [] polja = dostavljacString.split("\\|");
			dostavljac.setId(Long.parseLong(polja[0]));
			dostavljac.setIme(polja[1]);
			dostavljac.setPrezime(polja[2]);
			dostavljac.setPol(Pol.valueOf(polja[3]));
			dostavljac.setKorisnickoIme(polja[4]);
			dostavljac.setLozinka(polja[5]);
			dostavljac.setJmbg(Long.parseLong(polja[6]));
			dostavljac.setPlata(Double.parseDouble(polja[7]));
			
			dostavljac.setTipVozila(TipVozila.valueOf(polja[8]));
			dostavljac.setRegistarskaOznakaVozila(polja[9]);
			
			postaviMaxId(dostavljac.getId());
			
			dostavljaci.add(dostavljac);
		}
		
		return dostavljaci;
	}
	
	private List<Kupac> parsirajKupce(List<String> linijeKupac) {
		List<Kupac> kupci = new ArrayList<Kupac>();
		
		for (String kupacString : linijeKupac) {
			Kupac kupac = new Kupac();
			String [] polja = kupacString.split("\\|");
			kupac.setId(Long.parseLong(polja[0]));
			kupac.setIme(polja[1]);
			kupac.setPrezime(polja[2]);
			kupac.setPol(Pol.valueOf(polja[3]));
			kupac.setKorisnickoIme(polja[4]);
			kupac.setLozinka(polja[5]);
			kupac.setAdresa(polja[6]);
			kupac.setBrojTelefona(polja[7]);
			
			postaviMaxId(kupac.getId());
			
			kupci.add(kupac);
		}
		return kupci;
	}

	private List<Jelo> parsirajJela(List<String> linijeJela) {
		List<Jelo> jela = new ArrayList<Jelo>();
		
		for (String strJelo : linijeJela) {
			Jelo jelo = new Jelo();
			String [] polja = strJelo.split("\\|");
			jelo.setId(Long.parseLong(polja[0]));
			jelo.setNaziv(polja[1]);
			jelo.setCena(Double.parseDouble(polja[2]));
			jelo.setOpis(polja[3]);
			jelo.setRestoran(pronadjiRestoran(polja[4]));
			jelo.setKolicina(Integer.parseInt(polja[5]));
			
			postaviMaxId(jelo.getId());
			
			jela.add(jelo);
			
		}
		return jela;
	}
	
	private List<Pice> parsirajPica(List<String> linijePice) {
		List<Pice> pica = new ArrayList<Pice>();
		
		for (String piceStr : linijePice) {
			Pice pice = new Pice();
			String [] polja = piceStr.split("\\|");
			pice.setId(Long.parseLong(polja[0]));
			pice.setNaziv(polja[1]);
			pice.setCena(Double.parseDouble(polja[2]));
			pice.setOpis(polja[3]);
			pice.setRestoran(pronadjiRestoran(polja[4]));
			pice.setKolicina(Double.parseDouble(polja[5]));
			
			postaviMaxId(pice.getId());
			
			pica.add(pice);
		}
		
		return pica;
	}
	


	private List<Restoran> parsirajRestorane(List<String> linijeRestorani) {
		List<Restoran> restorani = new ArrayList<Restoran>();
		
		for (String string : linijeRestorani) {
			Restoran restoran = new Restoran();
			String [] polja = string.split("\\|");
			restoran.setId(Long.parseLong(polja[0]));
			restoran.setNaziv(polja[1]);
			restoran.setAdresa(polja[2]);
			restoran.setKategorija(Kategorija.valueOf(polja[3]));
			
			postaviMaxId(restoran.getId());
			
			restorani.add(restoran);
			
		}
		return restorani;
	}
	
	private List<Porudzbina> parsirajPorudzbine(List<String> linijePorudzbine) throws Exception {
		List<Porudzbina> porudzbine = new ArrayList<Porudzbina>();
		
		for (String string : linijePorudzbine) {
			String [] polja = string.split("\\|");
			long id = Long.parseLong(polja[0]);
			Restoran restoran = pronadjiRestoran(polja[1]);
			Jelo jelo = pronadjiJelo(polja[2]);
			Pice pice = pronadjiPice(polja[3]);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date vreme = format.parse(polja[4]);
			
		    Kupac kupac = pronadjuKupca(polja[5]);
		    
		    Dostavljac dostavljac = pronadjuDostavljaca(polja[6]);
		    
			Porudzbina porudzbina = new Porudzbina(id, restoran, jelo, pice, vreme, kupac, dostavljac);
			
			postaviMaxId(porudzbina.getId());
			
			porudzbine.add(porudzbina);
		}
		return porudzbine;
	}

	private Dostavljac pronadjuDostavljaca(String string) {
		long dostavljacId = Long.parseLong(string.replace("dostavljac ", ""));
		
		for (Dostavljac dostavljac: izvorPodataka.getDostavljaci()) {
			if(dostavljac.getId() == dostavljacId) {
				return dostavljac;
			}
		}
		
		return null;
	}

	private Kupac pronadjuKupca(String string) {
		long kupacId = Long.parseLong(string.replace("kupac ", ""));
		
		for (Kupac kupac: izvorPodataka.getKupci()) {
			if(kupac.getId() == kupacId) {
				return kupac;
			}
		}
		
		return null;
	}

	private Pice pronadjiPice(String piceStr) {
		long piceId = Long.parseLong(piceStr.replace("pice ", ""));
		
		for (Pice pice : izvorPodataka.getPice()) {
			if(pice.getId() == piceId) {
				return pice;
			}
		}
		
		return null;
	}

	private Jelo pronadjiJelo(String jeloStr) {
		long jeloId = Long.parseLong(jeloStr.replace("jelo ", ""));
		
		for (Jelo jelo : izvorPodataka.getJela()) {
			if(jelo.getId() == jeloId) {
				return jelo;
			}
		}
		
		return null;
	}

	private Restoran pronadjiRestoran(String restoranStr) {
		long restoranId = Long.parseLong(restoranStr.replace("restoran ", ""));
		
		for (Restoran restoran : izvorPodataka.getRestorani()) {
			if(restoran.getId() == restoranId) {
				return restoran;
			}
		}
		
		return null;
	}

}
