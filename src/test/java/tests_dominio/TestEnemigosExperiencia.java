package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestEnemigosExperiencia {

@Test
	public void testPjvsNPC() {

		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0);
		Personaje.cargarTablaNivel();
		Assert.assertEquals(0,h.getExperiencia());
		while (npc.estaVivo())
			h.atacar(npc);
		h.ganarExperiencia(npc.otorgarExp());
		Assert.assertEquals(30,h.getExperiencia());
	}

	@Test
	public void testMasFuerteMasExperiencia() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante", 2, 0);

		Assert.assertTrue(npc.otorgarExp() < npc2.otorgarExp());
	}

	@Test
	public void testPjvsPj() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Guerrero(), 2);
		Personaje.cargarTablaNivel();
		Assert.assertEquals(0,h.getExperiencia());
		Assert.assertEquals(0,h2.getExperiencia());

		while (h2.estaVivo())
			h.atacar(h2);

		h.ganarExperiencia(h2.otorgarExp());
		Assert.assertEquals(40,h.getExperiencia());
		Assert.assertEquals(0,h2.getExperiencia());

	}
}
