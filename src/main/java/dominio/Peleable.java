package dominio;

/**
 * Interfaz en la que se especifican los métodos a implementar por las clases
 * NPC y Personaje
 */

public interface Peleable {
	public int serAtacado(int daño);

	public int getSalud();

	public void despuesDeTurno();

	public int atacar(Peleable atacado);

	public int otorgarExp();

	public int getAtaque();

	public void setAtaque(int ataque);

	public boolean estaVivo();

	public String getNombre();
}
