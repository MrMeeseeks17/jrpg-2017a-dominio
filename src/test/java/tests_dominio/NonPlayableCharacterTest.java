package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;
import dominio.NonPlayableCharacter;
import dominio.Personaje;


public class NonPlayableCharacterTest {

	@Test
	public void DificultadesNPCNivelDefault() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,-1);
		Assert.assertEquals(30,npc.getFuerza());
		Assert.assertEquals(50,npc.getSalud());
		Assert.assertEquals(4,npc.getDefensa());
	}
	
	@Test
	public void DificultadesNPCNivel1() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		Assert.assertEquals(20,npc.getFuerza());
		Assert.assertEquals(40,npc.getSalud());
		Assert.assertEquals(5,npc.getDefensa());
	}
	
	@Test
	public void DificultadesNPCNivel2() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,2);
		Assert.assertEquals(30,npc.getFuerza());
		Assert.assertEquals(50,npc.getSalud());
		Assert.assertEquals(4,npc.getDefensa());
	}
	
	//no hay nivel 3 de dificultad o mayor
	@Test
	public void DificultadesNPCNivel3() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,3);
		Assert.assertEquals(0,npc.getFuerza());
		Assert.assertEquals(0,npc.getSalud());
		Assert.assertEquals(0,npc.getDefensa());
	}
	@Test
	public void DificultadesNPCNivelMayorA3() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,40);
		Assert.assertEquals(0,npc.getFuerza());
		Assert.assertEquals(0,npc.getSalud());
		Assert.assertEquals(0,npc.getDefensa());
	}
	
	@Test
	public void getSetFuerzaTest() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		Assert.assertEquals(20,npc.getFuerza());
		npc.setFuerza(30);
		Assert.assertEquals(30,npc.getFuerza());
	}
	
	@Test
	public void getSetNombreTest() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		Assert.assertEquals("Troll",npc.getNombre());
		npc.setNombre("Yordle");
		Assert.assertEquals("Yordle",npc.getNombre());
	}
	
	@Test
	public void getSetNivelTest() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		Assert.assertEquals(1,npc.getNivel());
		npc.setNivel(30);
		Assert.assertEquals(30,npc.getNivel());
	}
	
	@Test
	public void getSetDefensaTest() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		Assert.assertEquals(5,npc.getDefensa());
		npc.setDefensa(30);
		Assert.assertEquals(30,npc.getDefensa());
	}
	
	@Test
	public void getSetSaludTest() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		Assert.assertEquals(40,npc.getSalud());
		npc.setSalud(30);
		Assert.assertEquals(30,npc.getSalud());
	}
	
	@Test
	public void getSetAtaqueTest() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		Assert.assertEquals(20,npc.getAtaque());
		npc.setAtaque(30);
		Assert.assertEquals(30,npc.getAtaque());
	}
	
	
	@Test
	public void despuesDeTurnoTest() {
		//ESTA CLASE NO HACE NADA
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		npc.despuesDeTurno();
	}
	
	@Test
	public void ganarExperienciaTest() {
		//ESTA CLASE NO HACE NADA
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		npc.ganarExperiencia(0);
	}

	
	@Test
	public void AtacarSiPuedeTest() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Troll2", 1,1);
		npc.atacar(npc2);
		Assert.assertEquals(22,npc2.getSalud());
	}
	
	@Test
	public void serAtacadoPorGerreroh3Test() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Troll", 1,1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 3, 1);
		//Hace 35 de daño, el npc tiene 40 , por lo tanto queda en 5
		e.atacar(npc);
		Assert.assertEquals(5,npc.getSalud());
	}
}