package com.krakedev.alien;

public class Alien {
	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPies;
	private double precioExtremidad;
	private double precioOjo;
	private double precioCuerpo;
	private double precioTotal;

	public Alien(int tamanio, String color) {
		if (tamanio < 5) {
			this.tamanio = 5;
		} else if (tamanio > 30) {
			this.tamanio = 30;
		} else {
			this.tamanio = tamanio;
		}

		this.color = color;

		this.precioCuerpo = this.tamanio * 0.20;
		this.precioExtremidad = this.tamanio * 0.10;
		this.precioOjo = this.tamanio * 0.05;
		this.precioTotal = 0;
	}

	public int getTamanio() {
		return tamanio;
	}

	public String getColor() {
		return color;
	}

	public int getNumeroOjos() {
		return numeroOjos;
	}

	public int getNumeroBrazos() {
		return numeroBrazos;
	}

	public int getNumeroPies() {
		return numeroPies;
	}

	public double getPrecioExtremidad() {
		return precioExtremidad;
	}

	public double getPrecioOjo() {
		return precioOjo;
	}

	public double getPrecioCuerpo() {
		return precioCuerpo;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void calcularPrecioTotal() {
		int totalExtremidades = this.numeroBrazos + this.numeroPies;
		this.precioTotal = this.precioCuerpo + (totalExtremidades * this.precioExtremidad)
				+ (this.numeroOjos * this.precioOjo);
	}

	public boolean agregarBrazos(int cantidad) {
		int totalExtremidades = this.numeroBrazos + this.numeroPies;
		if (totalExtremidades + cantidad <= 10) {
			this.numeroBrazos += cantidad;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}

	public boolean agregarPiernas(int cantidad) {
		int totalExtremidades = this.numeroBrazos + this.numeroPies;
		if (totalExtremidades + cantidad <= 10) {
			this.numeroPies += cantidad;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}

	public boolean agregarOjos(int cantidad) {
		int maximoOjos;
		if (this.tamanio <= 10) {
			maximoOjos = 3;
		} else if (this.tamanio <= 20) {
			maximoOjos = 5;
		} else {
			maximoOjos = 7;
		}

		if (this.numeroOjos + cantidad <= maximoOjos) {
			this.numeroOjos += cantidad;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}

	public void imprimir() {
		String mensaje = "Tamanio: " + tamanio + ", Color: " + color + ", Numero Ojos: " + numeroOjos
				+ ", Numero Brazos: " + numeroBrazos + ", Numero Pies: " + numeroPies
				+ ", Precio Extremidad: " + precioExtremidad + ", Precio Ojo: " + precioOjo
				+ ", Precio Cuerpo: " + precioCuerpo + ", Precio Total: " + precioTotal;

		System.out.println(mensaje);
	}
}