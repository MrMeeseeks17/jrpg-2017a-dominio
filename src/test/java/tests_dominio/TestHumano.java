package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

public class TestHumano {

	@Test
	public void testIncentivar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(37,e.getAtaque());
		h.habilidadRaza1(e);
		Assert.assertTrue(e.getAtaque() > 37);
	}

	@Test
	public void testGolpeFatal() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(100,h.getEnergia());
		Assert.assertEquals(100,e.getSalud());
		if (h.habilidadRaza2(e)) {
			Assert.assertEquals(70,e.getSalud());	
			Assert.assertEquals(50,h.getEnergia());
		} else {
			Assert.assertEquals(100,e.getSalud());	
			Assert.assertEquals(90,h.getEnergia());
		}
	}
	
	
	@Test
	public void TestDisminucionEnergia() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		Assert.assertEquals(1,h.getNivel());
		
	}
	
	@Test
	public void TestSuperHumano() {
		Humano h = new Humano("Nico", new Hechicero(0.2, 0.3, 1.5),1);
		Elfo e = new Elfo("Nico2", new Hechicero(0.2, 0.3, 1.5),1);

		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		h.habilidadRaza2(e);
		h.habilidadRaza1(e);
		Assert.assertEquals(1,h.getNivel());
		
	}
}
