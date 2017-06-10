package RandomTest;

import org.junit.Test;

import dominio.RandomGeneratorStub;
import junit.framework.Assert;

public class RandomGeneratorStubTest {

	@Test
	public void ConstructorTest() {
		RandomGeneratorStub rg = new RandomGeneratorStub();
		rg.setValor(3);
		Assert.assertEquals(3, rg.getValor());
	}

	
	@Test
	public void Constructor2Test() {
		RandomGeneratorStub rg = new RandomGeneratorStub();
		rg.setValorD(3.5);
		Assert.assertEquals(3.5, rg.getValorD());
	}

	

	@Test
	public void Constructor3Test() {
		RandomGeneratorStub rg = new RandomGeneratorStub(3,3);
		rg.setValor(3);
		rg.setValorD(3.5);
		Assert.assertEquals(3, rg.getValor());
		Assert.assertEquals(3.5, rg.getValorD(),0.000005);
	}
	
	@Test
	public void nextDoubleTest() {
		RandomGeneratorStub rg = new RandomGeneratorStub(3,3);
		rg.setValorD(3.5);
		Assert.assertEquals(3.5, rg.nextDouble(),0.000005);
	}
	

	
	@Test
	public void nextIntVoidTest() {
		RandomGeneratorStub rg = new RandomGeneratorStub();
		rg.setValor(3);
		Assert.assertEquals(3, rg.nextInt());
	}
	
	
	@Test
	public void nextIntTest() {
		RandomGeneratorStub rg = new RandomGeneratorStub();
		rg.setValor(3);
		Assert.assertEquals(3, rg.nextInt(3));
	}
	

}
