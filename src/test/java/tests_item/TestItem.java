package tests_item;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Guerrero;
import dominio.Humano;
import dominio.Item;

public class TestItem {

	@Test
	public void CrearItemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		Assert.assertEquals(1, i.getIdItem());
		Assert.assertEquals("pechera", i.getNombre());
		Assert.assertEquals(11, i.getBonusSalud());
		Assert.assertEquals(12, i.getBonusEnergia());
		Assert.assertEquals(13, i.getBonusFuerza());
		Assert.assertEquals(14, i.getBonusDestreza());
		Assert.assertEquals(15, i.getBonusInteligencia());

	}

	@Test
	public void CrearItemTestFoto() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "../../jrpg-2017a-cliente/recursos/items/AprendizHechicero.png");
		Assert.assertEquals(15, i.getBonusInteligencia());
	}
	
	@Test
	public void setIdItemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		i.setIdItem(2);
		Assert.assertEquals(2, i.getIdItem());
	}
	
	public void setFotoItemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		i.setFoto("asd");
		Assert.assertEquals(2, i.getIdItem());
	}

	@Test
	public void setNombreITemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		i.setNombre("Pechera Druida");
		Assert.assertEquals("Pechera Druida", i.getNombre());
	}

	@Test
	public void setBonusSaludITemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		i.setBonusSalud(20);
		Assert.assertEquals(20, i.getBonusSalud());
	}

	@Test
	public void setBonusEnergiaITemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		i.setBonusEnergia(20);
		Assert.assertEquals(20, i.getBonusEnergia());
	}

	@Test
	public void setBonusFuerzaITemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		i.setBonusFuerza(20);
		Assert.assertEquals(20, i.getBonusFuerza());
	}

	@Test
	public void setBonusDestrezaITemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		i.setBonusDestreza(20);
		Assert.assertEquals(20, i.getBonusDestreza());
	}

	@Test
	public void setBonusInteligenciaITemTest() throws IOException {
		Item i;
		i = new Item(1, "pechera", 11, 12, 13, 14, 15, "");
		i.setBonusInteligencia(20);
	}
}
