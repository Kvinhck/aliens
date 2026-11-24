package com.krakedev.alien;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestAlienJUnitIA {

	// Tolerancia definida para comparaciones de valores double y evitar fallos por precision flotante
	private static final double DELTA = 0.0001;

	@Test
	public void testLimiteInferiorExacto() {
		// [Caso de prueba] Valida el valor frontera exacto minimo permitido (5 cm).
		// [Cobertura] Cubre la rama valida del constructor y el calculo de precios sobre el limite inferior.
		// [Calidad] Usa un valor frontera critico y comprueba todos los atributos afectados junto con un delta fijo.
		Alien alien = new Alien(5, "Amarillo");

		assertEquals(5, alien.getTamanio());
		assertEquals("Amarillo", alien.getColor());
		assertEquals(1.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(0.5, alien.getPrecioExtremidad(), DELTA);
		assertEquals(0.25, alien.getPrecioOjo(), DELTA);
	}

	@Test
	public void testLimiteSuperiorExacto() {
		// [Caso de prueba] Valida el valor frontera exacto maximo permitido (30 cm)[cite: 4, 8].
		// [Cobertura] Cubre el extremo superior del rango valido y los calculos porcentuales (20%, 10%, 5%)[cite: 4, 8].
		// [Calidad] Verifica el comportamiento exacto en el borde superior para prevenir errores de "<" vs "<="[cite: 4, 8].
		Alien alien = new Alien(30, "Morado");

		assertEquals(30, alien.getTamanio());
		assertEquals("Morado", alien.getColor());
		assertEquals(6.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(3.0, alien.getPrecioExtremidad(), DELTA);
		assertEquals(1.5, alien.getPrecioOjo(), DELTA);
	}

	@Test
	public void testTamanioNegativoAjustaAlMinimo() {
		// [Caso de prueba] Valida que un tamanio negativo (-10) se ajuste automaticamente a 5 cm[cite: 4, 8].
		// [Cobertura] Cubre la rama de ajuste por debajo del minimo y los precios derivados del tamanio corregido[cite: 4, 8].
		// [Calidad] Aisla el escenario de entrada negativa para confirmar que los precios se calculan tras el ajuste[cite: 4, 8].
		Alien alien = new Alien(-10, "Gris");

		assertEquals(5, alien.getTamanio());
		assertEquals("Gris", alien.getColor());
		assertEquals(1.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(0.5, alien.getPrecioExtremidad(), DELTA);
		assertEquals(0.25, alien.getPrecioOjo(), DELTA);
	}

	@Test
	public void testPuntoMedioDelRango() {
		// [Caso de prueba] Valida un tamanio intermedio dentro del rango permitido (20 cm)[cite: 4, 8].
		// [Cobertura] Cubre particion equivalente interna del rango [5..30] y los tres calculos de precio[cite: 4, 8].
		// [Calidad] Prueba independiente, repetible y legible con valores numericos claros y aserciones explicitas[cite: 4, 8].
		Alien alien = new Alien(20, "Naranja");

		assertEquals(20, alien.getTamanio());
		assertEquals("Naranja", alien.getColor());
		assertEquals(4.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(2.0, alien.getPrecioExtremidad(), DELTA);
		assertEquals(1.0, alien.getPrecioOjo(), DELTA);
	}
}