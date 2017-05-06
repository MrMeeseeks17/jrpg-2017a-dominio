package tests_dominio.Casta;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;

/**
 * COMPRUEBA QUE LAS HABILIDADES DEL GUERRERO FUNCIONEN CORRECTAMENTE
 */
public class TestGuerrero {

	@Test
	public void testDobleGolpeTrue() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		
		h.habilidadCasta1(e);
		Assert.assertEquals(46 ,e.getSalud());
	}
	
	@Test
	public void testDobleGolpeFalse() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		h.setEnergia(0);
		h.habilidadCasta1(e);
		Assert.assertEquals(100 ,e.getSalud());
	}

	@Test
	public void testAutoDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(20 ,h.getDefensa());
		h.habilidadCasta2(null);
		Assert.assertEquals(65 , h.getDefensa());
	}

	@Test
	public void testIgnoraDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(100 , e.getSalud());
		h.habilidadCasta3(e);
			Assert.assertEquals(63 , e.getSalud());
	}

	@Test
	public void testIgnoraDefensa2() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(100 , e.getSalud());
		h.setEnergia(0);
		h.habilidadCasta3(e);
		Assert.assertEquals(100 , e.getSalud());
	}

}
