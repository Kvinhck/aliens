package com.krakedev.alien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestFinalAlien {

	@Test
	public void testPrecioTotal() {
		Alien alien = new Alien(10, "Verde");

		assertEquals(0.0, alien.getPrecioTotal(), 0.0001);

		assertTrue(alien.agregarBrazos(2));
		assertEquals(4.0, alien.getPrecioTotal(), 0.0001);

		assertTrue(alien.agregarPiernas(3));
		assertEquals(7.0, alien.getPrecioTotal(), 0.0001);

		assertTrue(alien.agregarOjos(2));
		assertEquals(8.0, alien.getPrecioTotal(), 0.0001);
	}

	@Test
	public void testRestricciones() {
		Alien alien = new Alien(10, "Rojo");

		assertTrue(alien.agregarBrazos(6));
		assertTrue(alien.agregarPiernas(4));
		double precioAntesDeRechazo = alien.getPrecioTotal();

		assertFalse(alien.agregarBrazos(1));
		assertEquals(6, alien.getNumeroBrazos());
		assertEquals(precioAntesDeRechazo, alien.getPrecioTotal(), 0.0001);

		assertTrue(alien.agregarOjos(3));
		double precioConTresOjos = alien.getPrecioTotal();

		assertFalse(alien.agregarOjos(1));
		assertEquals(3, alien.getNumeroOjos());
		assertEquals(precioConTresOjos, alien.getPrecioTotal(), 0.0001);
	}

	@Test
	public void testLimites() {
		Alien alien = new Alien(40, "Azul");
		assertEquals(30, alien.getTamanio());

		assertTrue(alien.agregarOjos(7));
		assertEquals(7, alien.getNumeroOjos());
		assertFalse(alien.agregarOjos(1));
		assertEquals(7, alien.getNumeroOjos());

		assertEquals(16.5, alien.getPrecioTotal(), 0.0001);
	}
}