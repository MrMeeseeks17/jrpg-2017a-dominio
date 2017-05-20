package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

public class TestHechicero {

	@Test
	public void testCurar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		e.incrementarSalud(65 - e.getSalud());
//		e.setSalud(65);
		Assert.assertTrue(e.getSalud() == 65);
		h.habilidadCasta2(e);
		Assert.assertTrue(e.getSalud() > 65);
	}

	@Test
	public void testBolaDeFuego() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta1(e))
			Assert.assertTrue(e.getSalud() < 100);
		else
			Assert.assertTrue(e.getSalud() == 100);
	}

	@Test
	public void testRobarEnergia_y_Salud() {
		Humano h = new Humano("NicoHumano", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("NicoElfo", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		//h.setSalud(50);
		//h.setEnergia(50);
		int enerHum = h.getEnergia();
		int salHum = h.getSalud();
		int salElf = e.getSalud();
		
		if (h.habilidadCasta3(e)) {

			Assert.assertTrue(e.getSalud() < salElf);
			
			if(h.getEnergia()==h.getEnergiaTope())
				Assert.assertTrue(h.getEnergia() <= enerHum);
			else
				Assert.assertTrue(h.getEnergia() > enerHum);
			
			if(h.getSalud()==h.getSaludTope())
				Assert.assertTrue(h.getSalud() <= salHum);
			else
				Assert.assertTrue(h.getSalud() > salHum);
			
		} else {
			Assert.assertTrue(h.getSalud() == salHum);
			Assert.assertTrue(h.getEnergia() < enerHum);
			Assert.assertTrue(e.getSalud() == salElf);
		}
	}
}
