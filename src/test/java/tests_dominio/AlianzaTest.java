package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Guerrero;
import dominio.Humano;
import dominio.Personaje;


public class AlianzaTest {
	
	@Test
	public void crearAlianzaTest() {
		Humano h = new Humano("juan", new Guerrero(), 1);
		Humano h2 = new Humano("Alan", new Guerrero(), 1);
		Alianza a1 = new Alianza("MrMesseks");

		Assert.assertNull(h.getClan());
		Assert.assertNull(h2.getClan());
		h.setClan(a1);
		Assert.assertNotNull(h.getClan());
		h.aliar(h2);
		Assert.assertEquals(h.getClan(), h2.getClan());
		}
	
	@Test
	public void añadirPlayerAAlianzaTest() {
		Humano h3 = new Humano("carla", new Guerrero(), 1);
		Alianza a1 = new Alianza("MrMesseks");
		Assert.assertNull(h3.getClan());
		a1.añadirPersonaje(h3);
		Assert.assertNotNull(a1.getAliados());
		Assert.assertTrue(a1.getAliados().contains(h3));
	}

	@Test
	public void eliminarPlayerAAlianzaTest() {
		Humano h = new Humano("alan", new Guerrero(), 1);
		Alianza a1 = new Alianza("MrMesseks");
		a1.añadirPersonaje(h);
		Assert.assertTrue(a1.getAliados().contains(h));
		a1.eliminarPersonaje(h);
		Assert.assertFalse(a1.getAliados().contains(h));
	}
	
	@Test
	public void setAliadosAlianzaTest() {
		Alianza a1 = new Alianza("alianza");
		Humano h = new Humano("Juan", new Guerrero(), 1);
		a1.añadirPersonaje(h);
		Alianza a2 = new Alianza("MrMesseks");
		a2.setAliados(a1.getAliados());
		Assert.assertTrue(a2.getAliados().contains(h));
	}
	
	
	@Test
	public void obtenerNombreTest() {
		Alianza a1 = new Alianza("MrMesseks");
		Assert.assertEquals("MrMesseks", a1.obtenerNombre());
		
	}
	@Test
	public void crearAlianzaTest2() {
		Alianza a1 = new Alianza("MrMesseks");
		Assert.assertNotNull(a1.getAliados());
	}
	@Test
	public void salirDeAlianzaTest() {
		Humano h = new Humano("Juan", new Guerrero(), 1);
		h.crearAlianza("MrMesseks");
		Assert.assertNotNull(h.getClan());
		h.salirDeAlianza();
		Assert.assertNull(h.getClan());
	}
}
