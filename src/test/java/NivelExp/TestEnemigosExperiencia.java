package NivelExp;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;
/**
 * COMPRUEBA QUE AL MATAR LOS PERSONAJES GANEN EXPERIENCIA SEGUN EL NIVEL
 * Y A MAYOR NIVEL DE MAS EXPERIENCIA
 */
public class TestEnemigosExperiencia {

	@Test
	public void testPjvsNPC() {

		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0);
		Personaje.cargarTablaNivel();
		Assert.assertEquals(0, h.getExperiencia());
		while (npc.estaVivo())
			h.atacar(npc);
		h.ganarExperiencia(npc.otorgarExp());
		
	}

	@Test
	public void testMasFuerteMasExperiencia() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante", 2, 0);
		
		Assert.assertEquals(30,npc.otorgarExp());
		Assert.assertEquals(60,npc2.otorgarExp());
	
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
