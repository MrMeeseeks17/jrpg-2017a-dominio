package dominio;

/**
 * Es una de las distintas razas de personajes que existen, por lo cual reciben
 * mismos metodos ( habilidadRaza1,habilidadRaza2 ) y atributos de la clase
 * abstracta Personaje.
 */
public class Orco extends Personaje {

	public Orco(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * Primera habilidad del personaje "Golpe Defensa":En caso de que el
	 * invocador poseea energía, la disminuye en 10 (el costo de realizar la
	 * habilidad) y luego ataca al objetivo, pero en vez de hacerlo con sus
	 * puntos de ataque lo hace con el doble de sus puntos de defensa.
	 * 
	 * @return Devuelve verdadero en caso de tener energía suficiente y haberle
	 *         causado daño al objetivo, y falso en caso contrario.
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Segunda habilidad del personaje "Mordisco de Vida":En caso de que el
	 * invocador poseea energía, la disminuye en 10 (el costo de realizar la
	 * habilidad)y luego recupera tantos puntos de salud como puntos de daño le
	 * causó a su oponente
	 * 
	 * @return Devuelve verdadero en caso de tener energía y haberle causado
	 *         daño al objetivo, falso en caso contrario
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int daño_causado = atacado.serAtacado(this.getFuerza());
			if (daño_causado > 0) {
				this.serCurado(daño_causado);
				return true;
			}
		}
		return false;
	}
}
