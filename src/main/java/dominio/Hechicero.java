package dominio;

/**
 * Es uno de las distintas Casta que existen, por lo cual reciben mismos metodos
 * ( habilidad1,habilidad2 ) y atributos de la clase abstracta Casta.
 */
public class Hechicero extends Casta {

	/**Constructor.
	 * @param prob_crit double con la probabilidad
	 * de realizar un ataque critico
	 * @param evasion double con la probabilidad de
	 * evitar un ataque
	 * @param daño_crit double con el incremento de ataque
	 * al realizar ataques criticos
	 */
	public Hechicero(final double prob_crit,
			final double evasion, final double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.setNombreCasta("Hechicero");
	}

	/**Constructor.*/
	public Hechicero() {
		super();
		this.setNombreCasta("Hechicero");

		String[] aux = {"Bola de Fuego",
				"Curar Aliado", "Robar Energia y Salud"};
		this.setHabilidadesCasta(aux);
	}

	@Override
	/**
	 * Primera habilidad de la Casta "Bola de Fuego":
	 * En caso de que el invocador poseea energía, la disminuye
	 * en 10 (el costo de realizar la habilidad) luego el daño
	 * que causa es igual a los puntos de magia del caster (invocador
	 * de la habilidad) multiplicado por 1.5.
	 */
	public boolean habilidad1(final Personaje caster,
			final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.disminuirEnergia(10);
			if (atacado.serAtacado((int)
					(caster.calcularPuntosDeMagia()
							* 1.5)) > 0) {
				return true;
				}
		}
		return false;
	}

	@Override
	/**
	 * Segunda habilidad de la Casta "Curar Aliado":
	 * En caso de que el invocador poseea energía, la disminuye
	 * en 10 (el costo de realizar la habilidad) luego el caster
	 * restaura los puntos de salud de un aliado como tantos
	 * puntos de magia disponga.
	 */
	public boolean habilidad2(final Personaje caster,
			final Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.disminuirEnergia(10);
			aliado.serAsistidoPorHechicero(
					caster.calcularPuntosDeMagia());
		}
		return false;
	}

	@Override
	/**
	 * Tercera habilidad de la Casta "Robar Energia y Salud":
	 * En caso de que el invocador poseea energía la disminuye
	 * en 10 (el costo de realizar la habilidad) posteriormente
	 * disminuye tanto la energía como la salud del atacado
	 * dependiendo de la defensa de este último y los puntos de magia
	 * del caster. Luego incrementa sus atributos en cuantos puntos
	 * robo de los atributos correspondientes del atacado.
	 */
	public boolean habilidad3(final Personaje caster,
			final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.disminuirEnergia(10);
			int[] vec = atacado.serRobadoPorHechicero(caster);
			caster.serEnergizado(vec[0]);
			caster.serCurado(vec[1]);
			return true;
		}
		return false;
	}

	@Override
	protected final int bonusDestreza() {
		return 0;
	}

	@Override
	protected final int bonusFuerza() {
		return 0;
	}

	@Override
	protected final int bonusInteligencia() {
		return 5;
	}
}
