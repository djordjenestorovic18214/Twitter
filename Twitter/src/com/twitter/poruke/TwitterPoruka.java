package com.twitter.poruke;

/**
 * Ovo je klasa koja predstavlja poruku na Twitteru.
 * @author Djordje Nestorovic
 *
 */
public class TwitterPoruka {
	
	/**
	 * Ime korisnika u vidu Stringa.
	 */
	private String korisnik;
	
	/**
	 * Sadrzaj poruke u vidu Stringa.
	 */
	private String poruka;
	
	/**
	 * Metoda vraca vrednost atributa korisnik.
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja novu vrednost za atibut korisnik.
	 * @param korisnik Novo ime korisnika.
	 * @throws java.lang.RuntimeException ako je uneto ime:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan string</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
			this.korisnik = korisnik;
			}

	/**
	 * Vraca vrednost atributa poruka.
	 * @return sadrzaj poruke
	 */
	public String getPoruka() {
			return poruka;
			}

	/**
	 * Metoda postavlja novu vrednost za atribut poruka.
	 * @param poruka Nova vrednost za atribut poruka.
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * <ul>
	 * <li>null</li>
	 * <li>duza od 140 znakova</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
			if (poruka==null || poruka.length()>140)
			throw new RuntimeException(
			"Poruka mora biti uneta i mora imati najvise 140 znakova");
			this.poruka = poruka;
			}
	/** 
	 * Metoda vraca sadrzaj atributa korisnik i poruka u vidu Stringa.
	 */
	public String toString(){
			return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
			}
}