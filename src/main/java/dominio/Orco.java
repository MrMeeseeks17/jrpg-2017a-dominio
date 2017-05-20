package dominio;

/**
 * Es una de las distintas razas de personajes que existen, por lo cual reciben
 * mismos metodos ( habilidadRaza1,habilidadRaza2 ) y atributos de la clase
 * abstracta Personaje.
 */
public class Orco extends Personaje {

	/**
	 * Constructor.
	 * @param nombre Contiene el nombre del Personaje
	 * @param casta Contiene la Casta del Personaje
	 * @param id Contiene el id del Personaje
	 */
	public Orco(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id, 10, 0, "Orco");

		String[] aux = {"Golpe Defensa", "Mordisco de Vida" };
		this.setHabilidadesRaza(aux);
	}

	/**Constructor.
	* @param nombre Nombre del Personaje
	 * @param salud Puntos de salud del Personaje
	 * @param energia Puntos de energía del Personaje
	 * @param fuerza Puntos de fuerza del Personaje
	 * @param destreza Destreza del Personaje
	 * @param inteligencia Inteligencia del Personaje
	 * @param casta Clasificación del Personaje
	 * @param experiencia Experiencia del Personaje
	 * @param nivel NIvel del Personaje
	 * @param idPersonaje Identificador del Personaje
	 */
	public Orco(final String nombre, final int salud, final int energia,
			final int fuerza, final int destreza,
			final int inteligencia, final Casta casta,
			final int experiencia, final int nivel,
			final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza,
				inteligencia, casta, experiencia, nivel,
				idPersonaje, "Orco");

		String[] aux = {"Golpe Defensa", "Mordisco de Vida" };
		this.setHabilidadesRaza(aux);
	}

	@Override
	/**
	 * Primera habilidad del personaje "Golpe Defensa":En caso de que el
	 * invocador poseea energía, la disminuye en 10 (el costo de realizar la
	 * habilidad) y luego ataca al objetivo, pero en vez de hacerlo con sus
	 * puntos de ataque lo hace con el doble de sus puntos de defensa.
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.disminuirEnergia(10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
				return true;
				}
		}
		return false;
	}

	@Override
	/**
	 * Segunda habilidad del personaje "Mordisco de Vida":En caso de que el
	 * invocador poseea energía, la disminuye en 10 (el costo de realizar la
	 * habilidad)y luego recupera tantos puntos de salud como puntos
	 * de daño le causó a su oponente.
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.disminuirEnergia(10);
			int dañoCausado = atacado.serAtacado(this.getFuerza());
			if (dañoCausado > 0) {
				this.serCurado(dañoCausado);
				return true;
			}
		}
		return false;
	}
}
