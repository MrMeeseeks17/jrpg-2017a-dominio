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
		h.setNivel(100);
		h.subirNivel();
		Assert.assertEquals(100,h.getNivel());

	}

	@Test
	public void testGanarMuchaExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.setNivel(1);
		//Assert.assertTrue(h.getNivel() == 1);
		h.ganarExperiencia(150);
		Assert.assertEquals(3,h.getNivel());
	}
}
