package RandomTest;

import org.junit.Assert;
import org.junit.Test;

import dominio.RandomGenerador;
import dominio.RandomGeneratorStub;

public class RandomGeneradorTest {
	
	@Test
	public void ConstructorTest() {
		RandomGeneratorStub rg = new RandomGeneratorStub((double)0);
		Assert.assertEquals(0.5, rg.getValorD(),0);
	}
	
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
