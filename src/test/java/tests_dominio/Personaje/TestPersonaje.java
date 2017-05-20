package tests_dominio.Personaje;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

/**
 * COMPRUEBA QUE LAS ESTADISTICAS DE LOS PERSONAJES SEAN CORRECTAS
 */
public class TestPersonaje {

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getSalud() == 105);
		Assert.assertTrue(h.getEnergia() == 105);
		Assert.assertTrue(h.getFuerza() == 15);
		Assert.assertTrue(h.getDestreza() == 10);
		Assert.assertTrue(h.getInteligencia() == 10);

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(h2.getSalud() == 105);
		Assert.assertTrue(h2.getEnergia() == 105);
		Assert.assertTrue(h2.getFuerza() == 10);
		Assert.assertTrue(h2.getDestreza() == 10);
		Assert.assertTrue(h2.getInteligencia() == 15);

		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertTrue(h3.getSalud() == 105);
		Assert.assertTrue(h3.getEnergia() == 105);
		Assert.assertTrue(h3.getFuerza() == 10);
		Assert.assertTrue(h3.getDestreza() == 15);
		Assert.assertTrue(h3.getInteligencia() == 10);
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(e.getSalud() == 100);
		Assert.assertTrue(e.getEnergia() == 110);
		Assert.assertTrue(e.getFuerza() == 15);
		Assert.assertTrue(e.getDestreza() == 10);
		Assert.assertTrue(e.getInteligencia() == 10);

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(e2.getSalud() == 100);
		Assert.assertTrue(e2.getEnergia() == 110);
		Assert.assertTrue(e2.getFuerza() == 10);
		Assert.assertTrue(e2.getDestreza() == 10);
		Assert.assertTrue(e2.getInteligencia() == 15);

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertTrue(e3.getSalud() == 100);
		Assert.assertTrue(e3.getEnergia() == 110);
		Assert.assertTrue(e3.getFuerza() == 10);
		Assert.assertTrue(e3.getDestreza() == 15);
		Assert.assertTrue(e3.getInteligencia() == 10);
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(o.getSalud() == 110);
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getFuerza() == 15);
		Assert.assertTrue(o.getDestreza() == 10);
		Assert.assertTrue(o.getInteligencia() == 10);

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(o2.getSalud() == 110);
		Assert.assertTrue(o2.getEnergia() == 100);
		Assert.assertTrue(o2.getFuerza() == 10);
		Assert.assertTrue(o2.getDestreza() == 10);
		Assert.assertTrue(o2.getInteligencia() == 15);

		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		Assert.assertTrue(o3.getSalud() == 110);
		Assert.assertTrue(o3.getEnergia() == 100);
		Assert.assertTrue(o3.getFuerza() == 10);
		Assert.assertTrue(o3.getDestreza() == 15);
		Assert.assertTrue(o3.getInteligencia() == 10);
	}
	
	
	//GETTERS Y SETTERS TEST
	@Test
	public void getSetNombreRazaTest(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getNombreRaza(), "Humano");
		h.setNombreRaza("humano2");
		Assert.assertEquals(h.getNombreRaza(), "humano2");
	}
	@Test
	public void getSetNombreTest(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getNombre(), "Juanca");
		h.setNombre("Juanca2");
		Assert.assertEquals(h.getNombre(), "Juanca2");
	}
//	@Test
//	public void getSetIdPersonaje(){
//		Humano h = new Humano("Juanca", new Asesino(), 1);
//		Assert.assertEquals(h.getIdPersonaje(), 1);
//		h.setIdPersonaje(5);
//		Assert.assertEquals(h.getIdPersonaje(),5);
//	}
	
	@Test
	public void getIncrementarSaludTope(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getSaludTope(), 105);
		h.incrementarSaludTope(200 - h.getSaludTope());
		Assert.assertEquals(h.getSaludTope(),200);
	}
	
	@Test
	public void getIncrementarEnergiaTope(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getEnergiaTope(), 105);
		h.incrementarEnergiaTope(500 - h.getEnergiaTope());
		Assert.assertEquals(h.getEnergiaTope(),500);
	}
	
	@Test
	public void getIncrementarExperiencia(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getExperiencia(), 0);
		h.incrementarExperiencia(100 - h.getExperiencia());
		Assert.assertEquals(h.getExperiencia(),100);
	}
	
	@Test
	public void getSetMagia(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getMagia(), 15);
		h.setMagia(100);
		Assert.assertEquals(h.getMagia(),100);
	}
	
	//Restablecer Estadisticas
	@Test
	public void RestablecerSaludTope(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getSalud(),105);
		h.incrementarSalud(-70);
		Assert.assertEquals(h.getSalud(),35);
		h.restablecerSalud();
		Assert.assertEquals(h.getSalud(),105);
	}
	
	@Test
	public void RestablecerEnergiaTope(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Humano h2 = new Humano("Carla", new Asesino(), 1);
		Assert.assertEquals(h.getEnergia(),105);
		h.habilidadCasta1(h2);
		Assert.assertEquals(h.getEnergia(),95);
		h.restablecerEnergia();
		Assert.assertEquals(h.getEnergia(),105);
	}
}
