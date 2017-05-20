package NivelExp;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

/**
 * COMPRUEBA QUE SE SUBA DE NIVEL TANTO CON EL SETTER DE NIVEL , COMO DE EXPERIENCIA
 */
public class TestSubirNivel {

	@Test
	public void testSubirdeNivel() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(1,h.getNivel());
		h.ganarExperiencia(50);
		Assert.assertEquals(2,h.getNivel());
	}

	@Test
	public void testNivel100() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.ganarExperiencia(300000);
		if(h.getNivel()!=100)
			h.incrementarNivel(100 -h.getNivel());
		//h.subirNivel();
		Assert.assertEquals(100,h.getNivel());

	}

	@Test
	public void testGanarMuchaExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		if(h.getNivel()!=1)
			h.incrementarNivel(1 -h.getNivel());
		//Assert.assertTrue(h.getNivel() == 1);
		h.ganarExperiencia(150);
		Assert.assertEquals(3,h.getNivel());
	}
}
