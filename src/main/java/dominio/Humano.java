package dominio;

/**
 * Es uno de las distintas razas de personajes que existen, por lo cual reciben
 * mismos metodos ( habilidadRaza1,habilidadRaza2 ) y atributos de la clase
 * abstracta Personaje.
 */
public class Humano extends Personaje {

	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	/**
	 * Primera habilidad del personaje "Incentivar":Es una habilidad de apoyo,
	 * en caso de que el invocador poseea energía, la disminuye en 10 (el costo
	 * de realizar la habilidad) luego obtiene el atributo ataque del aliado
	 * objetivo y lo incrementa con sus puntos de magia aumentando el daño del
	 * objetivo.
	 * 
	 * @return Devuelve falso en caso de no tener energía suficiente y verdadero
	 *         en caso contrario
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * Segunda habilidad del personaje "Golpe Fatal": En caso de que el
	 * invocador poseea energía, ataca con tantos puntos de ataque como la mitad
	 * de la salud del objetivo y en caso de causarle daño disminuye la energía
	 * del caster a la mitad, si no le resta los 10 puntos de costo
	 * tradicionales.
	 * 
	 * @return Devuelve verdadero en caso de tener energía y causarle daño al
	 *         objetivo, en caso contrario devuelve falso
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
			this.setEnergia(this.getEnergia() - 10);
		}
		return false;
	}
}
