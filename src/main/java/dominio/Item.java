package dominio;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
/**
 * Es el Item que los personajes pueden llevar en el inventario.
 * Sus atributos corresponden con las estadisticas que el mismo dará.
 */
public class Item implements Serializable {
	/** Id del Item. */
	private int idItem;
	/** Foto del Item. */
	private String foto;
	/** Nombre  del Item. */
	private String nombre;
	/** Bonus de Salud  del Item. */
	private int bonusSalud;
	/** Bonus de Energia  del Item. */
	private int bonusEnergia;
	/** Bonus de Fuerza  del Item. */
	private int bonusFuerza;
	/** Bonus de Destrez  del Item. */
	private int bonusDestreza;
	/** Bonus de Inteligencia  del Item. */
	private int bonusInteligencia;
	/**
	 * Constructor.
	 * @param idItem2 Contiene el id que adiciona el Item
	 * @param nombre2 Contiene el nombre que adiciona el Item
	 * @param bonusSalud2 Contiene la salud que adiciona el Item
	 * @param bonusEnergia2 Contiene la Energia que adiciona el Item
	 * @param bonusAtaque2 Contiene la Fuerza que adiciona el Item
	 * @param bonusDefensa2 Contiene la Defensa que adiciona el Item
	 * @param bonusMagia2 Contiene la Inteligencia que adiciona el Item
	 * @param foto2 Contiene el nombre del archivo imagen del Item
	 * @throws IOException excepcion que puede provocar File e ImageIO
	 */
	public Item(final int idItem2, final String nombre2, final int bonusSalud2,final int bonusEnergia2,final int bonusAtaque2,final int bonusDefensa2, final int bonusMagia2,final String foto2) throws IOException {
		this.foto = foto2;
		this.idItem = idItem2;
		this.nombre = nombre2;
		this.bonusSalud = bonusSalud2;
		this.bonusEnergia = bonusEnergia2;
		this.bonusFuerza = bonusAtaque2;
		this.bonusDestreza = bonusDefensa2;
		this.bonusInteligencia = bonusMagia2;
	}

	/** Getter de Imagen.
	 * @return retorna un Image IO que enlaza a la foto
	 * @throws IOException excepcion que puede provocar File e ImageIO
	 */
	public final BufferedImage getFoto() throws IOException {
		return ImageIO.read(new File("recursos/items/" + foto));
	}

	/** Getter de Nombre.
	 * @return retorna el nombre del Item
	 */
	public String getNombre() {
		return nombre;
	}

	/** Getter de BonusSalud.
	 * @return retorna la salud adicional del Item
	 */
	public int getBonusSalud() {
		return bonusSalud;
	}

	/** Getter de BonusEnergia.
	 * @return retorna la Energia adicional del Item
	 */
	public int getBonusEnergia() {
		return bonusEnergia;
	}

	/** Getter de BonusFuerza.
	 * @return retorna la Fuerza adicional del Item
	 */
	public int getBonusFuerza() {
		return bonusFuerza;
	}

	/** Getter de BonusDestreza.
	 * @return retorna la Defensa adicional del Item
	 */
	public int getBonusDestreza() {
		return bonusDestreza;
	}

	/** Getter de BonusInteligencia.
	 * @return retorna la Inteligencia adicional del Item
	 */
	public int getBonusInteligencia() {
		return bonusInteligencia;
	}

	/** Getter de Id.
	 * @return retorna id del Item
	 */
	public int getIdItem() {
		return idItem;
	}

	/**
	 * Setter de Id.
	 * @param idItem2 Recibe el Id del Item.
	 */
	public void setIdItem(final int idItem2) {
		this.idItem = idItem2;
	}

	/**
	 * Setter de foto.
	 * @param foto2 Recibe la foto del Item.
	 */
	public void setFoto(final String foto2) {
		this.foto = foto2;
	}

	/**
	 * Setter de Nombre.
	 * @param nombre2 Recibe el nombre del Item.
	 */
	public void setNombre(final String nombre2) {
		this.nombre = nombre2;
	}

	/**
	 * Setter de Salud.
	 * @param bonusSalud2 Recibe la Salud del Item.
	 */
	public void setBonusSalud(final int bonusSalud2) {
		this.bonusSalud = bonusSalud2;
	}

	/**
	 * Setter de Energia.
	 * @param bonusEnergia2 Recibe la Energia del Item.
	 */
	public void setBonusEnergia(final int bonusEnergia2) {
		this.bonusEnergia = bonusEnergia2;
	}

	/**
	 * Setter de Fuerza.
	 * @param bonusFuerza2 Recibe la Fuerza del Item.
	 */
	public void setBonusFuerza(final int bonusFuerza2) {
		this.bonusFuerza = bonusFuerza2;
	}

	/**
	 * Setter de Destreza.
	 * @param bonusDestreza2 Recibe la Destreza del Item.
	 */
	public void setBonusDestreza(final int bonusDestreza2) {
		this.bonusDestreza = bonusDestreza2;
	}

	/**
	 * Setter de Inteligencia.
	 * @param bonusInteligencia2 Recibe la Inteligencia del Item.
	 */
	public void setBonusInteligencia(final int bonusInteligencia2) {
		this.bonusInteligencia = bonusInteligencia2;
	}
}