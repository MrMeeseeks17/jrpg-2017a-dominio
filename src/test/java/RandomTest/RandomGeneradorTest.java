package RandomTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.RandomGenerador;

public class RandomGeneradorTest {
	
	@Test
	public void nextIntTest() {
		RandomGenerador rg = new RandomGenerador();
		Assert.assertEquals(0, rg.nextInt(0));
	}
	@Test
	public void nextDoubleTest() {
		RandomGenerador rg = new RandomGenerador();
		Assert.assertEquals(0, rg.nextDouble(),0000.1);
	}
	
	/*
	@Test
	public void nextDoubleTest() {
		RandomGenerador rg = new RandomGenerador();
		Assert.assertEquals(0, rg.nextDouble());
		rg.
		
	}*/

}
