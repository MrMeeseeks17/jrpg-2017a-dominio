package dominio;

/**
 * Es uno de las distintas Casta que existen, por lo cual reciben mismos metodos
 * ( habilidad1,habilidad2 ) y atributos de la clase abstracta Casta.
 */
public class Guerrero extends Casta {

	/**
	 * Constructor.
	 * @param probCrit Recibe valor del atributo de probabilidad de golpe
	 *        critico.
	 * @param evasion Recibe valor del atributo de evasión.
	 * @param dañoCrit Recibe valor del atributo de daño crítico.
	 */
	public Guerrero(final double probCrit, final double evasion,
			final double dañoCrit) {
		super(probCrit, evasion, dañoCrit);
		this.setNombreCasta("Guerrero");
	}

	/** Constructor. */
	public Guerrero() {
		super();
		this.setNombreCasta("Guerrero");

		String[] aux = {"Ataque Doble",
				"Aumentar Defensa", "Ignorar Defensa"};
		this.setHabilidadesCasta(aux);
	}

	@Override
	/**
	 * Primera habilidad de la Casta "Ataque Doble":
	 * En caso de que el invocador poseea energía,
	 * la disminuye en 10 (el costo de realizar la habilidad)
	 * luego el daño que le causa al atacado es igual al ataque del caster
	 * multiplicado por 2.
	 */
	public boolean habilidad1(final Personaje caster,
			final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.disminuirEnergia(10);
			if (atacado.serAtacado(caster.getAtaque() * 2) > 0) {
				return true;
				}
		}
		return false;
	}

	@Override
	/**
	 * Segunda habilidad de la Casta "Aumentar Defensa":En caso de que el
	 * invocador poseea energía, la disminuye en 10 (el costo de realizar la
	 * habilidad) luego aumenta los puntos de defensa del caster
	 * equivalente a sus puntos de magia.
	 */
	public boolean habilidad2(final Personaje caster,
			final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.disminuirEnergia(10);
			caster.incrementarDefensa(caster.getMagia());
			return true;
		}
		return false;
	}

	@Override
	/**
	 * Tercera habilidad de la Casta "Ignorar Defensa": En caso de que el
	 * atacante poseea energía, la disminuye en 10 (el costo de realizar la
	 * habilidad) y setea momenteneamente la defensa del objetivo a
	 * cero previo al ataque, posteriormente la vuelve a su valor original
	 */
	public boolean habilidad3(final Personaje caster,
			final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.disminuirEnergia(10);
			if (atacado.serAtacadoPorGuerreroh3(
					caster.getAtaque())) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected final int bonusDestreza() {
		return 0;
	}

	@Override
	protected final int bonusFuerza() {
		return 5;
	}

	@Override
	protected final int bonusInteligencia() {
		return 0;
	}
}
