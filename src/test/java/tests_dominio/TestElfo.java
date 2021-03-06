package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Humano;

public class TestElfo {

	@Test
	public void testGolpeLevel() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

		Assert.assertEquals(100,h.getSalud());
		if (e.habilidadRaza1(h))
			Assert.assertTrue(h.getSalud() < 100);
		else
			Assert.assertEquals(100,h.getSalud());
	}

	@Test
	public void testAtaqueBosque() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		
		Assert.assertEquals(100,h.getSalud());
		if (e.habilidadRaza2(h))
			Assert.assertTrue(h.getSalud() < 100);
		else
			Assert.assertEquals(100,h.getSalud());
	}
}
