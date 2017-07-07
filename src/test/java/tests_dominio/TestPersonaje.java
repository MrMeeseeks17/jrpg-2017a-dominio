package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestPersonaje {

	@Test
	public void testHabilidadesPersonaje() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		
		String[] hab = h.getHabilidadesCasta();
		
		Assert.assertEquals("Ataque Doble", hab[0]);
		Assert.assertEquals("Aumentar Defensa", hab[1]);
		Assert.assertEquals("Ignorar Defensa", hab[2]);
		
		hab = h.getHabilidadesRaza();
		
		Assert.assertEquals("Incentivar", hab[0]);
		Assert.assertEquals("Golpe Fatal", hab[1]);
	}

	@Test
	public void testIdPersonaje() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(1, h.getIdPersonaje());
	}

	
	@Test
	public void testPuedeAtacarPersonaje() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.puedeAtacar());
		h.disminuirEnergia(100);
//		System.out.println(h.disminuirEnergia(100));
		Assert.assertFalse(h.puedeAtacar());
	}

	
	@Test
	public void testDistanciaConPersonaje() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Nicolas", new Guerrero(), 1);
		
		Assert.assertEquals(0, h.distanciaCon(h2),0);
		
	}
		
	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(105, h.getSalud());
		Assert.assertEquals(105, h.getEnergia());
		Assert.assertEquals(15, h.getFuerza());
		Assert.assertEquals(10, h.getDestreza());
		Assert.assertEquals(10, h.getInteligencia());

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(105, h2.getSalud());
		Assert.assertEquals(105, h2.getEnergia());
		Assert.assertEquals(10, h2.getFuerza());
		Assert.assertEquals(10, h2.getDestreza());
		Assert.assertEquals(15, h2.getInteligencia());

		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertEquals(105, h3.getSalud());
		Assert.assertEquals(105, h3.getEnergia());
		Assert.assertEquals(10, h3.getFuerza());
		Assert.assertEquals(15, h3.getDestreza());
		Assert.assertEquals(10, h3.getInteligencia());
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(100, e.getSalud());
		Assert.assertEquals(110, e.getEnergia());
		Assert.assertEquals(15, e.getFuerza());
		Assert.assertEquals(10, e.getDestreza());
		Assert.assertEquals(10, e.getInteligencia());

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(100, e2.getSalud());
		Assert.assertEquals(110, e2.getEnergia());
		Assert.assertEquals(10, e2.getFuerza());
		Assert.assertEquals(10, e2.getDestreza());
		Assert.assertEquals(15, e2.getInteligencia());

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertEquals(100, e3.getSalud());
		Assert.assertEquals(110, e3.getEnergia());
		Assert.assertEquals(10, e3.getFuerza());
		Assert.assertEquals(15, e3.getDestreza());
		Assert.assertEquals(10, e3.getInteligencia());
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(110, o.getSalud());
		Assert.assertEquals(100, o.getEnergia());
		Assert.assertEquals(15, o.getFuerza());
		Assert.assertEquals(10, o.getDestreza());
		Assert.assertEquals(10, o.getInteligencia());

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(110, o2.getSalud());
		Assert.assertEquals(100, o2.getEnergia());
		Assert.assertEquals(10, o2.getFuerza());
		Assert.assertEquals(10, o2.getDestreza());
		Assert.assertEquals(15, o2.getInteligencia());

		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		Assert.assertEquals(110, o3.getSalud());
		Assert.assertEquals(100, o3.getEnergia());
		Assert.assertEquals(10, o3.getFuerza());
		Assert.assertEquals(15, o3.getDestreza());
		Assert.assertEquals(10, o3.getInteligencia());
	}
}
