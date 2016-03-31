/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Djole
 *
 */
public class TwitterTest {
	Twitter t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		t.unesi("Korisnik1", "Poruka1");
		t.unesi("Korisnik2", "Poruka2");
		
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		
		tp1.setKorisnik("Korisnik1");
		tp1.setPoruka("Poruka1");
		
		tp2.setKorisnik("Korisnik2");
		tp2.setPoruka("Poruka2");
		
		assertEquals(tp1, t.vratiSvePoruke().get(0));
		assertEquals(tp2, t.vratiSvePoruke().get(1));
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesiSveOK() {
		t.unesi("Korisnik1", "Poruka1");
		t.unesi("Korisnik2", "Poruka2");
		
		LinkedList<TwitterPoruka> testLista = new LinkedList<TwitterPoruka>();
		
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		
		tp1.setKorisnik("Korisnik1");
		tp1.setPoruka("Poruka1");
		tp2.setKorisnik("Korisnik2");
		tp2.setPoruka("Poruka2");
		
		testLista.addLast(tp1);
		testLista.addLast(tp2);
		
		assertEquals(testLista, t.vratiSvePoruke());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiNull() {
		t.unesi(null, "Poruka1");
		t.unesi("Korisnik2", null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiPrazanString() {
		t.unesi("", "Poruka1");
		t.unesi("Korisnik2", "");
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeSveOK() {
		t.unesi("Marko", "Ovo je Markova poruka.");
		t.unesi("Mirko", "Ovo je Mirkova poruka.");
		t.unesi("Fred", "This is Fred's message.");
		
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		
		tp1.setKorisnik("Marko");
		tp1.setPoruka("Ovo je Markova poruka.");
		tp2.setKorisnik("Mirko");
		tp2.setPoruka("Ovo je Mirkova poruka.");
		
		TwitterPoruka[] testNiz = new TwitterPoruka[3];
		testNiz[0] = tp1;
		testNiz[1] = tp2;
		testNiz[2] = null;
		
		assertArrayEquals(testNiz, t.vratiPoruke(3, "Ovo"));
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeSveNull() {
		t.vratiPoruke(3, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeSvePrazanString() {
		t.vratiPoruke(3, "");
	}
	
}
