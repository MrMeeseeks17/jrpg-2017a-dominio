package tests_dominio.Personaje;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Humano;

/**
 * COMPRUEBA QUE LAS HABILIDADES ELFICAS FUNCIONEN CORRECTAMENTE
 */
public class TestElfo {

	@Test
	public void testGolpeLevelTrue() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(100 , h.getSalud());
		if(e.habilidadRaza1(h)) {
			Assert.assertEquals(65, h.getSalud());
		} else {
			Assert.assertEquals(100, h.getSalud());
		}
	}

	@Test
	public void testGolpeLevelFalse() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(100 , h.getSalud());
		e.disminuirEnergia(e.getEnergia());
		e.habilidadRaza1(h);
			Assert.assertEquals(100 , h.getSalud());
	}
	@Test
	public void testAtaqueBosqueTrue() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		if(e.habilidadRaza2(h)) {
			Assert.assertEquals(75 , h.getSalud());
		} else {
			Assert.assertEquals(100, h.getSalud());
		}
	}
	
	@Test
	public void testAtaqueBosqueFalse() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

		Assert.assertEquals(100 , h.getSalud());
		e.disminuirEnergia(e.getEnergia());
		e.habilidadRaza2(h);
			Assert.assertEquals(100 , h.getSalud());
	}
}
