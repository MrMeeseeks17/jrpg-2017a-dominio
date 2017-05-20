package tests_dominio.Personaje;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;

/**
 * COMPRUEBA QUE LAS HABILIDADES RACIALES FUNCIONEN CORRECTAMENTE
 */
public class TestHabilidadesDePersonaje {
	@Test
	public void testHabilidad1RazaOrcoTrue() {
		Orco o = new Orco("Thrall", new Asesino(), 1);
		Orco o2 = new Orco("Durotar", new Hechicero(), 2);
		//La  defensa de un asesino es 15 ( defensa base 10 sumado 5 por ser asesino )
		Assert.assertEquals(15 , o.getDefensa());
		/**La habilidad de raza 1 Orca Golpea con un equivalente al doble de su defensa
		//Por lo tanto deberia golpear:
		 * Daño o sobre o2 = ((defensaDeOrc*2) - (DefensaDeO) ))
		 * 	20 = ( (15*2) - 10))
		*/
		if(o.habilidadRaza1(o2)) {
			Assert.assertEquals(90, o2.getSalud());
		} else {
			Assert.assertEquals(110, o2.getSalud());
		}
	}
	
	@Test
	public void testHabilidad1RazaOrcoFalse() {
		Orco o = new Orco("Thrall", new Asesino(), 1);
		Orco o2 = new Orco("Durotar", new Hechicero(), 2);
		//La  defensa de un asesino es 15 ( defensa base 10 sumado 5 por ser asesino )
		Assert.assertEquals(15 , o.getDefensa());
		o.disminuirEnergia(o.getEnergia());;
		o.habilidadRaza1(o2);
			Assert.assertEquals(110, o2.getSalud());
	}
	
	
	
	@Test
	public void testHabilidad2RazaOrcoControlDaño() {
		Orco o = new Orco("Thrall", new Guerrero(), 1);
		Orco o2 = new Orco("Durotar", new Guerrero(), 2);
		//Orco o3 = new Orco("Durotar", new Hechicero(), 2);
		//La  fuerza de una asesino orco es 10( fuerza base 10 + 5 por ser Guerrero )
		/**La habilidad de raza 2 Orca "Mordisco de Vida" 
		 * Absorbe vida equivalente al daño que causa equivalente a su fuerza como daño
		//Por lo tanto deberia golpear:
		 * Daño o sobre o2 = ((fuerza) - (DefensaDeO) ))
		 * 	5 = ( (15) - 10))
		*/
		//Comprobamos daño de habilidad y el lanzamiento de la habilidad:
		if(o.habilidadRaza2(o2)) {
			Assert.assertEquals(105, o2.getSalud());
		} else {
			Assert.assertEquals(110, o2.getSalud());
		}
	}
	

	@Test
	public void testHabilidad2RazaOrcoControlCuracionPositiva() {
		Orco o = new Orco("Thrall", new Guerrero(), 1);
		Orco o2 = new Orco("Durotar", new Guerrero(), 2);
		//Orco o3 = new Orco("Durotar", new Hechicero(), 2);
		//La  fuerza de una asesino orco es 10( fuerza base 10 + 5 por ser Guerrero )
		//Comprobamos daño de habilidad y el lanzamiento de la habilidad:
		o.incrementarSalud(-10);
		if(o.habilidadRaza2(o2)) {
			Assert.assertEquals(105, o.getSalud());
			Assert.assertEquals(105, o2.getSalud());
		} else {
			Assert.assertEquals(100, o.getSalud());
			Assert.assertEquals(110, o2.getSalud());
		}
	}
	
	

	@Test
	public void testHabilidad2RazaOrcoControlCuracionHacerSinDaño() {
		Orco o = new Orco("Thrall", new Guerrero(), 1);
		Orco o3 = new Orco("Durotar", new Hechicero(), 2);
		
		o3.incrementarSalud(80 - o3.getSalud());
//		o3.setSalud(80);
		//Comprobamos que si la defensa sea igual al daño , no golpee
		Assert.assertFalse(o3.habilidadRaza2(o));
	}
	
	
	
	
	
	/*El daño que causa es igual
	 * a su nivel multiplicado por 10 + la fuerza del personaje.*/
	@Test
	public void testHabilidad1RazaElfoTrue() {
		Elfo e = new Elfo("Illidan", new Asesino(), 1);
		Elfo e2 = new Elfo("Elune", new Hechicero(), 2);
		//La  defensa de un asesino es 15 ( defensa base 10 sumado 5 por ser asesino )
		Assert.assertEquals(1, e.getNivel());
		if(e.getNivel()!=5)
			e.incrementarNivel(5 - e.getNivel());
//		e.setNivel(5);
		Assert.assertEquals(5, e.getNivel());

		if(e.habilidadRaza1(e2)) {
			Assert.assertEquals(50, e2.getSalud());
		} else {
			Assert.assertEquals(100, e2.getSalud());
		}
	}
	@Test
	public void testHabilidad1RazaElfoFalse() {
		Elfo e = new Elfo("Illidan", new Asesino(), 1);
		Elfo e2 = new Elfo("Elune", new Hechicero(), 2);
		//La  defensa de un asesino es 15 ( defensa base 10 sumado 5 por ser asesino )
		Assert.assertEquals(1, e.getNivel());
		if(e.getNivel()!=5)
			e.incrementarNivel(5 - e.getNivel());
//		e.setNivel(5);
		Assert.assertEquals(5, e.getNivel());
		e.disminuirEnergia(e.getEnergia());
		e.habilidadRaza1(e2);
			Assert.assertEquals(100, e2.getSalud());
	}
	
	
	
	/*"Ataque Bosque": ataca a un objetivo con
	 * un daño equivalente a su magia.*/
	@Test
	public void testHabilidad2RazaElfoTrue() {
		Elfo e = new Elfo("Elune", new Hechicero(), 1);
		Elfo e2 = new Elfo("Illidan", new Asesino(), 2);
		//La  magia del hechicero => (int+5)*1.5 -> 15*1.5 = 22
		Assert.assertEquals(22, e.getMagia());

		//daño = ataque-defensa = 22-15 = 7
		if(e.habilidadRaza2(e2)) {
			Assert.assertEquals(93, e2.getSalud());
		} else {
			Assert.assertEquals(100, e2.getSalud());
		}
	}
	
	@Test
	public void testHabilidad2RazaElfoFalse() {
		Elfo e = new Elfo("Elune", new Hechicero(), 1);
		Elfo e2 = new Elfo("Illidan", new Asesino(), 2);
		Assert.assertEquals(22, e.getMagia());
		e.disminuirEnergia(e.getEnergia());
		e.habilidadRaza2(e2);
			Assert.assertEquals(100, e2.getSalud());
	}
	

	/*"Golpe Fatal":ataca con tantos puntos de ataque como la mitad
	 * de la salud del objetivo y en caso de causarle daño disminuye la energía
	 * del caster a la mitad
	 */
	@Test
	public void testHabilidad2RazaHumanoTrue() {
		Humano h = new Humano("Arthas", new Guerrero(), 1);
		Humano h2 = new Humano("Jaina", new Hechicero(), 2);
		Assert.assertEquals(105, h.getEnergia());
		//daño = ataque-defensa = (105/2) - defensa = (52) - 10 = 42
		if(h.habilidadRaza2(h2)) {
			Assert.assertEquals((105 - 42), h2.getSalud());
			Assert.assertEquals(52, h.getEnergia());
		} else {
			Assert.assertEquals(105, h2.getSalud());
			Assert.assertEquals(95, h.getEnergia());
		}
	}
	
	@Test
	public void testHabilidad2RazaHumanoFalse() {
		Humano h = new Humano("Arthas", new Guerrero(), 1);
		Humano h2 = new Humano("Jaina", new Hechicero(), 2);
		Assert.assertEquals(105, h.getEnergia());
		h.disminuirEnergia(h.getEnergia());
		h.habilidadRaza2(h2);
			Assert.assertEquals(105, h2.getSalud());
	}
	
	/*"Incentivar": Obtiene el atributo ataque del aliado
	 * objetivo y lo incrementa con sus puntos de magia aumentando el daño del
	 * objetivo.*/
	@Test
	public void testHabilidad1RazaHumanoTrue() {
		Humano h = new Humano("Arthas", new Guerrero(), 1);
		Humano h2 = new Humano("Jaina", new Hechicero(), 2);
		Assert.assertEquals(15, h2.getAtaque());
		Assert.assertEquals(15, h.getMagia());

		// 15 de magia + 15 de ataque = 30
		h.habilidadRaza1(h2);
			Assert.assertEquals(30,h2.getAtaque());
	}
	
	@Test
	public void testHabilidad1RazaHumanoFalse() {
		Humano h = new Humano("Arthas", new Guerrero(), 1);
		Humano h2 = new Humano("Jaina", new Hechicero(), 2);
		Assert.assertEquals(15, h2.getAtaque());
		Assert.assertEquals(15, h.getMagia());
		h.disminuirEnergia(h.getEnergia());
		h.habilidadRaza1(h2);
		Assert.assertEquals(15, h2.getAtaque());
	}
}
