package tests_dominio.Casta;

import junit.framework.Assert;

import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;


public class CastaTest {
	@Test
	public void getCastaTest(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getCasta().getNombreCasta(), "Asesino");
	}
	
	@Test
	public void getHabilidadesCastaTest(){
		String[] aux = {"Golpe Critico", "Aumentar Evasion", "Robar"};
		Humano h = new Humano("Juanca", new Asesino(), 1);
		for(int i = 0 ; i < aux.length ; i++)
			Assert.assertEquals(aux[i], h.getCasta().getHabilidadesCasta()[i]);
	}
	
	
	
	@Test
	public void setProbabilidadGolpeCriticoTest(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getCasta().getProbabilidadGolpeCritico(), 0.2);
		h.getCasta().setProbabilidadGolpeCritico(0.5);
		Assert.assertEquals(h.getCasta().getProbabilidadGolpeCritico(), 0.5);
	}
	
	@Test
	public void setDañoCriticoTest(){
		Humano h = new Humano("Juanca", new Asesino(), 1);
		Assert.assertEquals(h.getCasta().getDañoCritico(), 1.5);
		h.getCasta().setDañoCritico(0.5);
		Assert.assertEquals(h.getCasta().getDañoCritico(), 0.5);
	}
	
}
