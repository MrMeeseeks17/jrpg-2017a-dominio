package tests_dominio.Casta;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

/**
 * COMPRUEBA QUE LAS HABILIDADES HECHICERO FUNCIONEN CORRECTAMENTE
 */
public class TestHechicero {

	@Test
	public void testCurar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(100 , e.getSalud());
		e.setSalud(65);
		Assert.assertEquals(65 , e.getSalud());
		h.habilidadCasta2(e);
		Assert.assertEquals(100 , e.getSalud());
	}

	@Test
	public void testBolaDeFuegoTrue() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(100 , e.getSalud());
		h.habilidadCasta1(e);
			Assert.assertEquals(53 , e.getSalud());
	}

	@Test
	public void testBolaDeFuegoFalse() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(100 , e.getSalud());
		h.setEnergia(0);
		h.habilidadCasta1(e);
			Assert.assertEquals(100 , e.getSalud());
	}
	@Test
	public void testRobarEnergia_y_SaludTrue() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(100 , e.getSalud());
		h.setSalud(50);
		h.setEnergia(50);
		
		h.habilidadCasta3(e);
			Assert.assertEquals(83 , e.getSalud());
			Assert.assertEquals(95 , h.getEnergia());
			Assert.assertEquals(67 , h.getSalud());
	}
	
	@Test
	public void testRobarEnergia_y_SaludFalse() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(100 , e.getSalud());
		
		h.setSalud(50);
		h.setEnergia(50);
		h.setEnergia(0);
		h.habilidadCasta3(e);
			Assert.assertEquals(50 , h.getSalud());
			Assert.assertEquals(0 , h.getEnergia());
			Assert.assertEquals(0 , h.getEnergia());
	}
}
