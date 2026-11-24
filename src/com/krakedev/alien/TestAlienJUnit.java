package com.krakedev.alien;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestAlienJUnit {

	@Test
	public void testCreacionTamañoValido() {
		Alien alien = new Alien(10, "Verde");

		assertEquals(10, alien.getTamanio());
		assertEquals("Verde", alien.getColor());
		assertEquals(0, alien.getNumeroOjos());
		assertEquals(0, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPies());
		assertEquals(2.0, alien.getPrecioCuerpo(), 0.0001);
		assertEquals(1.0, alien.getPrecioExtremidad(), 0.0001);
		assertEquals(0.5, alien.getPrecioOjo(), 0.0001);
	}

	@Test
	public void testAjusteTamañoMinimo() {
		Alien alien = new Alien(2, "Rojo");

		assertEquals(5, alien.getTamanio());
		assertEquals("Rojo", alien.getColor());
		assertEquals(1.0, alien.getPrecioCuerpo(), 0.0001);
		assertEquals(0.5, alien.getPrecioExtremidad(), 0.0001);
		assertEquals(0.25, alien.getPrecioOjo(), 0.0001);
	}

	@Test
	public void testAjusteTamañoMaximo() {
		Alien alien = new Alien(50, "Azul");

		assertEquals(30, alien.getTamanio());
		assertEquals("Azul", alien.getColor());
		assertEquals(6.0, alien.getPrecioCuerpo(), 0.0001);
		assertEquals(3.0, alien.getPrecioExtremidad(), 0.0001);
		assertEquals(1.5, alien.getPrecioOjo(), 0.0001);
	}
}