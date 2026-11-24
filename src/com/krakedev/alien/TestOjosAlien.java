package com.krakedev.alien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestOjosAlien {

	@Test
	public void testRangoPequeMaxTresOjos() {
		Alien alien = new Alien(10, "Verde");

		assertTrue(alien.agregarOjos(3));
		assertEquals(3, alien.getNumeroOjos());

		assertFalse(alien.agregarOjos(1));
		assertEquals(3, alien.getNumeroOjos());
	}

	@Test
	public void testRangoMedianoMaxCincoOjos() {
		Alien alien = new Alien(15, "Morado");

		assertTrue(alien.agregarOjos(2));
		assertTrue(alien.agregarOjos(3));
		assertEquals(5, alien.getNumeroOjos());

		assertFalse(alien.agregarOjos(1));
		assertEquals(5, alien.getNumeroOjos());
	}

	@Test
	public void testRangoGrandeMaxSieteOjos() {
		Alien alien = new Alien(25, "Azul");

		assertTrue(alien.agregarOjos(7));
		assertEquals(7, alien.getNumeroOjos());

		assertFalse(alien.agregarOjos(2));
		assertEquals(7, alien.getNumeroOjos());
	}
}