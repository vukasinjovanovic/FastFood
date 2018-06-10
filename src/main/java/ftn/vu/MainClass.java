package ftn.vu;

import java.text.SimpleDateFormat;
import java.util.Date;

import ftn.vu.fajl.RadSaFajlom;
import ftn.vu.izvor.podataka.IzvorPodataka;
import ftn.vu.ui.Login;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Vreme pokretanja: " + format.format(new Date()).toString());
		
		
		RadSaFajlom radSaFajlom = new RadSaFajlom();
		IzvorPodataka izvorPodataka = radSaFajlom.citajFajlove();
		Login loginProzor = new Login(radSaFajlom, izvorPodataka);
		loginProzor.setVisible(true);
		
	}
	
}
