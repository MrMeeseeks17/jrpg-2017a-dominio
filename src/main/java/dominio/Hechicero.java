package dominio;

/**
 * Es uno de las distintas Casta que existen, por lo cual reciben mismos metodos
 * ( habilidad1,habilidad2 ) y atributos de la clase abstracta Casta.
 */
public class Hechicero extends Casta {

	public Hechicero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Hechicero";
	}

	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}

	//
	/**
	 * Primera habilidad de la Casta "Bola de Fuego":En caso de que el invocador
	 * poseea energía, la disminuye en 10 (el costo de realizar la habilidad)
	 * luego el daño que causa es igual a los puntos de magia del caster
	 * (invocador de la habilidad) multiplicado por 1.5
	 * 
	 * @return Devuelve verdadero en caso de causarle daño al objetivo o falso
	 *         en caso contrario
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}

	//
	/**
	 * Segunda habilidad de la Casta "Curar Aliado":En caso de que el invocador
	 * poseea energía, la disminuye en 10 (el costo de realizar la habilidad)
	 * luego el caster restaura los puntos de salud de un aliado como tantos
	 * puntos de magia disponga
	 * 
	 * @return Devuelve false en caso de no tener energía suficiente y verdadero
	 *         en caso contrario
	 */
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	/**
	 * Tercera habilidad de la Casta "Robar Energia y Salud":En caso de que el
	 * invocador poseea energía la disminuye en 10 (el costo de realizar la
	 * habilidad) posteriormente disminuye tanto la energía como la salud del
	 * atacado dependiendo de la defensa de este último y los puntos de magia
	 * del caster. Luego incrementa sus atributos en cuantos puntos robo de los
	 * atributos correspondientes del atacado
	 * 
	 * @return Devuelve false en caso de no poseer energía sufiencte y verdadero
	 *         en caso contrario
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}
}
