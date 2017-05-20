package dominio;

/**
 * Clase NonPlayableCharacter: Esta clase crea un NPC (NonPlayableCharacter) de
 * dificultad aleatoria y a mayor dificultad sus atributos son mayores.
 */
public class NonPlayableCharacter extends Entidad implements Peleable {
	/** dificultadAleatoria Valor de dificultad del NPC. */
	private static final int dificultadAleatoria = -1;

	/**
	 * Constructor. Asigna un valor y crea un objeto NonPlayableCharacter.
	 * Recibe valor de los atributos nombre, nivel y dificultadNPC.
	 * @param nombre Nombre del NCP.
	 * @param nivel Nivel del NCP.
	 * @param dificultadNPC Dificultad del NCP.
	 */
	public NonPlayableCharacter(final String nombre,
			final int nivel, final int dificultadNPC) {
		super(nombre, nivel);
		int dificultad;
		if (dificultadNPC == dificultadAleatoria) {
			dificultad = this.getRandom().nextInt(3);
		} else {
			dificultad = dificultadNPC;
		}

		switch (dificultad) {
			case 0:
				this.incrementarFuerza(10 + (nivel - 1) * 3
						- this.getFuerza()); // 30%
				this.incrementarSalud(30 + (nivel - 1) * 15
						- this.getSalud());
				//setDefensa(2 + (nivel - 1) * 1)
				this.incrementarDefensa(2 + (nivel - 1) * 1
						- this.getDefensa());
				break;
			case 1:
				this.incrementarFuerza(20 + (nivel - 1) * 6
						- this.getFuerza()); // 50%
				this.incrementarSalud(40 + (nivel - 1) * 20
						- this.getSalud());
				this.incrementarDefensa(5 + (nivel - 1) * 2
						- this.getDefensa());
				break;
			case 2:
				this.incrementarFuerza(30 + (nivel - 1) * 10
						- this.getFuerza()); // 50%
				this.incrementarSalud(50 + (nivel - 1) * 25
						- this.getSalud());
				this.incrementarDefensa(4 + (nivel - 1) * 4
						- this.getDefensa());
				break;
			default:
				break;
		}
	}

	@Override
	/**
	 * Método otorgarExp: Otorga una experiencia equivalente a su nivel
	 * multiplicado por 30.
	 * @return Valor de la experiencia nueva.
	 */
	public int otorgarExp() {
		return this.getNivel() * 30;
	}

	@Override
	/**
	 * Metodo atacar: Calcula el daño infligido
	 * al Objeto de Entrada. Tienen 15% de golpes criticos
	 * @return Valor entero del daño que recibe
	 * el objeto de Entrada Peleable
	 * @param atacado Peleable que recibe el ataque.
	 */
	public int atacar(final Peleable atacado) {
		if (this.getRandom().nextDouble() <= 0.15) {
			return atacado.serAtacado((int)
					(this.getAtaque() * 1.5));
		} else {
			return atacado.serAtacado(this.getAtaque());
		}
	}

	@Override
	/**
	 * Metodo serAtacado: Calcula el daño que recibe el Objeto llamador.
	 * @return Valor Entero del daño que recibe el objeto llamador.
	 * @param daño Valor del daño recibido.
	 */
	public int serAtacado(final int daño) {
		if (this.getRandom().nextDouble() >= 0.15) {
			int dañorecibido = daño - this.getDefensa() / 2;
			if (dañorecibido > 0) {
				this.incrementarSalud(-dañorecibido);
				return dañorecibido;
			}
			return 0; // no le hace daño ya que la defensa fue mayor
		}
		return 0; // esquivo el golpe
	}

	/** Método despuesDeTurno:. */
	public void despuesDeTurno() { }

	/**
	 * Método ganarExperiencia:.
	 * @param exp Valor de experiencia recibida.
	 */
	public void ganarExperiencia(final int exp) { }

	/**
	 * Getter de Ataque: Devuelve los puntos de
	 * ataque que son los de fuerza.
	 * @return Valor de los puntos de ataque según la fuerza.
	 */
	public int getAtaque() {
		return getFuerza();
	}

	/**
	 * Setter de Ataque: Recibe y setea los puntos de ataque.
	 * @param ataque Valor de los puntos de ataque según la fuerza.
	 */
	public void setAtaque(final int ataque) {
		this.incrementarFuerza(ataque - this.getFuerza());
	}

	@Override
	public final boolean serAtacadoPorGuerreroh3(final int ataqueRecibido) {
		int defensaOriginal = this.getDefensa();
		//this.setDefensa(0);
		this.incrementarDefensa(-this.getDefensa());
		if (this.serAtacado(ataqueRecibido) > 0) {
//			this.setDefensa(defensaOriginal);
			this.incrementarDefensa(defensaOriginal);
			return true;
		}
		return false;
	}

	@Override
	public final boolean serAsistidoPorHechicero(final int puntosCurados) {
		return false;
	}

	@Override
	public final int[] serRobadoPorHechicero(final Personaje caster) {
		int[] aux = {0, 0 };
		return aux;
	}
}
