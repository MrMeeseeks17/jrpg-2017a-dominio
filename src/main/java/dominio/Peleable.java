package dominio;

/**
 * Interfaz en la que se especifican los métodos a implementar por las clases
 * NPC y Personaje.
 */

public interface Peleable {

    int serAtacado(int daño);

	int getSalud();

	void despuesDeTurno();

	int atacar(Peleable atacado);

	int otorgarExp();

	int getAtaque();

	void setAtaque(int ataque);

	boolean estaVivo();

	String getNombre();

	boolean serAtacadoPorGuerreroh3(int ataqueRecibido);

	boolean serAsistidoPorHechicero(int puntosCurados);

	int[] serRobadoPorHechicero(Personaje caster);

}
