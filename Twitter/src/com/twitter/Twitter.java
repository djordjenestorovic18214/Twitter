package com.twitter;

import java.util.LinkedList; 
import com.twitter.poruke.TwitterPoruka;
/**
 * Ovo je klasa koja predstavlja Twitter.
 * @author Djordje Nestorovic
 *
 */
public class Twitter { 
	
	/**
	 * Lista objekata klase TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda koja vraca vrednost atributa poruke.
	 * @return lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
		}
	
	/**
	 * Metoda prima kao parametre atribute 'korisnik' i 'poruka' klase TwitterPoruka,
	 * pa pravi jedan objekat te klase i dodaje mu prosledjene podatke.
	 * Zatim taj objekat dodaje na kraj liste poruke.
	 * @param korisnik Nova vrednost za atribut korisnik klase TwitterPoruka.
	 * @param poruka Nova vrednost za atribut poruka klase TwitterPoruka.
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
		}
	
	/**
	 * Metoda koja kao parametre prima tag i maxBroj,
	 * pa u listi poruke pretrazuje sve poruke i trazi one koje u sebi sadrze tag.
	 * Te poruke zatim skladisti u niz rezultat koji je napravljen, sve dok se ne pretraze
	 * sve poruke, ili sve dok se ne napuni niz. Kapacitet niza je prosledjen parametrom maxBroj.
	 * Na kraju se taj niz vraca kao povratna vrednost metode.
	 * @param maxBroj Kapacitet niza u koji se skladiste poruke koje sadrzie tag.
	 * @param tag String koji se trazi u porukama.
	 * @return niz sa porukama
	 * @throws java.lang.RuntimeException ako je uneti tag:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan string</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
		throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
		maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
	
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
			TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
			
			//Pretrazuju se poruke i traze se one koje sadrze tag.
			//Ako se nadje neka takva, i ako nije prekoracen maxBroj
			//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
			//se prekida.
			for (int i = 0; i < poruke.size(); i++)
				if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
					if (brojac < maxBroj){
						rezultat[brojac]=poruke.get(i);
						brojac++;
					}
					else break;
			return rezultat;
	}
	
}