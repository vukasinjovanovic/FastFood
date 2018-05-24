package ftn.vu.fajl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.model.Administrator;
import ftn.vu.model.Dostavljac;
import ftn.vu.model.TipVozila;

public class RadSaFajlom {
	
	
	public RadSaFajlom() {
	}

	public IzvorPodataka citajFajlove() throws IOException {
		
	    IzvorPodataka izvorPodataka = new IzvorPodataka();
	    
	    List<String> linijeAdmin = citajFajl("src/main/resources/administrator.txt");
		
	    List<Administrator> administratori = parsirajAdministratore(linijeAdmin);
	    
	    izvorPodataka.setAdministratori(administratori);
	    
	    
	    List<String> linijeDostavljac = citajFajl("src/main/resources/dostavljac.txt");
	    
	    List<Dostavljac> dostavljaci = parsirajDostavljace(linijeDostavljac);
	    
	    izvorPodataka.setDostavljaci(dostavljaci);
	    
		return izvorPodataka;
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
			
			dostavljaci.add(dostavljac);
		}
		
		return dostavljaci;
	}

}
