package MyRandomTest;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandom;
import dominio.NonPlayableCharacter;
import dominio.Personaje;


public class MyRandomTest {

	@Test
	public void nextIntTest() {
		Assert.assertEquals(2, MyRandom.nextInt(3));
	}
	@Test
	public void nextIntTest2() {
		Assert.assertEquals(1, MyRandom.nextInt(2));
	}
	@Test
	public void nextIntTest3() {
		Assert.assertEquals(0, MyRandom.nextInt(1));
	}
	/*
	@SuppressWarnings("deprecation")
	@Test
	public void nextDoubleTest() {
		Assert.assertEquals(0.49, MyRandom.nextDouble());
	}*/
	@Test
	public void DeclaracionDeClaseTest() { 
		MyRandom m = new MyRandom();
		Assert.assertNotNull(m);
	}
 }
