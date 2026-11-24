package com.krakedev.alien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestExtremidadesAlien {

	@Test
	public void testAgregarBrazosValido() {
		Alien alien = new Alien(10, "Verde");

		boolean resultado = alien.agregarBrazos(2);

		assertTrue(resultado);
		assertEquals(2, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPies());
	}

	@Test
	public void testAgregarPiernasLimiteExacto() {
		Alien alien = new Alien(12, "Azul");

		boolean resultado = alien.agregarPiernas(10);

		assertTrue(resultado);
		assertEquals(10, alien.getNumeroPies());
	}

	@Test
	public void testExcedeLimiteNoAgregaBrazos() {
		Alien alien = new Alien(10, "Rojo");

		boolean resultado = alien.agregarBrazos(11);

		assertFalse(resultado);
		assertEquals(0, alien.getNumeroBrazos());
	}

	@Test
	public void testCombinadoBrazosYPiernasValidoYExceso() {
		Alien alien = new Alien(15, "Morado");

		assertTrue(alien.agregarBrazos(4));
		assertEquals(4, alien.getNumeroBrazos());

		assertTrue(alien.agregarPiernas(6));
		assertEquals(6, alien.getNumeroPies());

		assertFalse(alien.agregarPiernas(1));
		assertEquals(6, alien.getNumeroPies());
	}
}