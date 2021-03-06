package NivelExp;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Personaje;
/**
 * COMPRUEBA QUE LOS PERSONAJES SUBAN DE NIVEL A PARTIR DE LA EXPERIENCIA
 */
public class TestNivelExp {

	@Test
	public void testGanarExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		h.ganarExperiencia(45);
		Assert.assertEquals(45, h.getExperiencia());
		//Assert.assertTrue(h.getExperiencia() == 45);
	}

	@Test
	public void testSubirNivel() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		h.ganarExperiencia(300);
		Assert.assertEquals(4, h.getNivel());
	}
	
	@Test
	public void testSubirNivelYControlarExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		h.ganarExperiencia(300);
		Assert.assertEquals(0, h.getExperiencia());
	}

	@Test
	public void testLevel100() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 99, 1);
		h.ganarExperiencia(10000);
		Assert.assertEquals(100, h.getNivel());
	}
}
