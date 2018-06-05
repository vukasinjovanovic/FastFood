package ftn.vu.fajl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.TipVozila;

public class RadSaFajlom {
	
	public static final String ADMINISTRATOR_FAJL = "src/main/resources/administrator.txt";
	public static final String DOSTAVLJAC_FAJL = "src/main/resources/dostavljac.txt";
	
	
	
	public RadSaFajlom() {
	}

	public IzvorPodataka citajFajlove() throws IOException {
		
	    IzvorPodataka izvorPodataka = new IzvorPodataka();
	    
	    List<String> linijeAdmin = citajFajl(ADMINISTRATOR_FAJL);
		
	    List<Administrator> administratori = parsirajAdministratore(linijeAdmin);
	    
	    izvorPodataka.setAdministratori(administratori);
	    
	    
	    List<String> linijeDostavljac = citajFajl(DOSTAVLJAC_FAJL);
	    
	    List<Dostavljac> dostavljaci = parsirajDostavljace(linijeDostavljac);
	    
	    izvorPodataka.setDostavljaci(dostavljaci);
	    
		return izvorPodataka;
	}
	
	public void pisiFajlove(IzvorPodataka izvorPodataka) throws IOException {
		
		pisiPodatke(izvorPodataka.getAdministratori(), ADMINISTRATOR_FAJL);
		
		pisiPodatke(izvorPodataka.getDostavljaci(), DOSTAVLJAC_FAJL);
		
		//TODO: dodati pisanje za ostale entitete
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
			administrator.setPol(polja[3]);
			administrator.setKorisnickoIme(polja[4]);
			administrator.setLozinka(polja[5]);
			administrator.setJmbg(Long.parseLong(polja[6]));
			administrator.setPlata(Double.parseDouble(polja[7]));
			
			admini.add(administrator);
		}
		
		return admini;
	}
	
	
	private List<Dostavljac> parsirajDostavljace(List<String> linijeDostavljac) {
		List<Dostavljac> dostavljaci = new ArrayList<Dostavljac>();
		
		for (String adminString : linijeDostavljac) {
			Dostavljac dostavljac = new Dostavljac();
			String [] polja = adminString.split("\\|");
			dostavljac.setId(Long.parseLong(polja[0]));
			dostavljac.setIme(polja[1]);
			dostavljac.setPrezime(polja[2]);
			dostavljac.setPol(polja[3]);
			dostavljac.setKorisnickoIme(polja[4]);
			dostavljac.setLozinka(polja[5]);
			dostavljac.setJmbg(Long.parseLong(polja[6]));
			dostavljac.setPlata(Double.parseDouble(polja[7]));
			
			dostavljac.setTipVozila(TipVozila.valueOf(polja[8]));
			dostavljac.setRegistarskaOznakaVozila(polja[9]);
			
			dostavljaci.add(dostavljac);
		}
		
		return dostavljaci;
	}

}
