package tests_dominio.Casta;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;

/**
 * COMPRUEBA QUE LAS HABILIDADES DEL ASESINO FUNCIONEN CORRECTAMENTE
 */
public class TestAsesino {

	@Test
	public void testRobar() {
	}

	@Test
	public void testCriticoTrue() {
		Humano h = new Humano("Nicolas", new Asesino(), 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);

		Assert.assertEquals(105 , h2.getSalud());
		if(h.habilidadCasta1(h2)){
			Assert.assertEquals(93 , h2.getSalud());
		} else {
			Assert.assertEquals(105 , h2.getSalud());
		}
	}
	@Test
	public void testCriticoFalso() {
		Humano h = new Humano("Nicolas", new Asesino(), 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);

		Assert.assertEquals(105 , h2.getSalud());
		h.disminuirEnergia(h.getEnergia());;
		h.habilidadCasta1(h2);
		Assert.assertEquals(105, h2.getSalud());
	}
	
	@Test
	public void testProbEvasion() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(0.3, h.getCasta().getProbabilidadEvitarDaño(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDaño(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertEquals(0.5, h.getCasta().getProbabilidadEvitarDaño(), 0.01);
	}
	@Test
	public void testHab3() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

		
		Assert.assertFalse(h.getCasta().habilidad3(null, null));
	}
}
