package dominio;

/**
 * Entidad: Clase abstracta que hereda a Personaje y NonPlayableCharacter.
 * Define los atributos y métodos compartidos por ambas clases.
 */
public abstract class Entidad {
	/** salud Valor de salud de la Entidad. */
	private int salud;
	/** defensa Valor de defensa de la Entidad. */
	private int defensa;
	/** nombre Nombre de la Entidad. */
	private String nombre;
	/** fuerza Valor de fuerza de la Entidad. */
	private int fuerza;
	/** nivel Valor de nivel de la Entidad. */
	private int nivel;
	private RandomGenerador random;

	/**
	 * Constructor. Asigna valores a la Entidad.
	 * Recibe valor de los atributos nombre y nivel.
	 * @param nomb Nombre de la entidad
	 * @param lvl Nivel de la entidad
	 */
	public Entidad(final String nomb, final int lvl) {
		this.nombre = nomb;
		this.nivel = lvl;
		this.random = new ActualRandomGenerador();
	}

	/**
	 * Constructor.
	 * Asigna valores a la Entidad. Recibe valor de los atributos
	 * nombre, salud, fuerza y nivel.
	 * @param nomb Nombre de la entidad
	 * @param sal Puntos de salud de la entidad
	 * @param fuer Puntos de fuerza de la entidad
	 * @param lvl Nivel de la entidad
	 */
	Entidad(final String nomb, final int sal, final int fuer,
			final int lvl) {
		this.nombre = nomb;
		this.salud = sal;
		this.fuerza = fuer;
		this.nivel = lvl;
		this.random = new ActualRandomGenerador();
	}

	/**
	 * Constructor.
	 * Asigna valores a la Entidad. Recibe valor de los atributos
	 * nombre, nivel y fuerza.
	 * @param nomb Nombre de la entidad
	 * @param lvl Nivel de la entidad
	 * @param fuer Puntos de fuerza de la entidad
	 */
	public Entidad(final String nomb, final int lvl, final int fuer) {
		this.nombre = nomb;
		this.nivel = lvl;
		this.fuerza = fuer;
		this.random = new ActualRandomGenerador();
	}

	/**
	 * Método estaVivo: Verifica si los puntos de salud son mayores que 0.
	 * @return True or False.
	 */
	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * Método otorgarExp: Otorga experiencia.
	 * @return Valor de experiencia otrogada.
	 */
	public abstract int otorgarExp();

	/**
	 * Getter de Nivel.
	 * @return Valor del nivel de la entidad.
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Setter de Nivel.
	 * @param lvl Recibe el nivel de la entidad.
	 */
	public void incrementarNivel(final int lvl) {
		this.nivel += lvl;
	}

	/**
	 * Getter de Nombre.
	 * @return Nombre de la entidad.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de Nombre.
	 * @param nomb Recibe el nombre de la entidad.
	 */
	public void setNombre(final String nomb) {
		this.nombre = nomb;
	}

	/**
	 * Getter de Fuerza.
	 * @return Valor de la fuerza de la entidad.
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * Setter de Fuerza. Setea el atributo fuerza del objeto llamador con el
	 * entero fuerza pasado por parametro.
	 * @param fuer Recibe el valor de fuerza de la entida.
	 */
	public void incrementarFuerza(final int fuer) {
		this.fuerza += fuer;
	}

	/**
	 * Getter de Salud.
	 * @return Valor de la salud de la entidad.
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * Setter de Salud.
	 * @param sal Recibe el valor de la salud de la entidad.
	 */
	public void incrementarSalud(final int sal) {
		this.salud += sal;
	}

	/**
	 * Getter de Defensa.
	 * @return Valor de la defensa de la entidad.
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Setter de Defensa.
	 * @param def Recibe el valor de la defensa de la entidad.
	 */
	public void incrementarDefensa(final int def) {
		this.defensa += def;
	}

	public RandomGenerador getRandom() {
		return random;
	}
	public void setRandom(final RandomGenerador rand) {
		this.random = random;
	}


	/**Declara el metodo serAtacado.
	 * @param ataqueRecibido Int con el poder de ataque
	 * @return int con la cantidad de daño recibido*/
	public abstract int serAtacado(int ataqueRecibido);

	/**Declara el método atacar.
	 * @param atacado Peleable que recibe el ataque
	 * @return Int con la cantidad de daño realizado
	 */
	public abstract int atacar(Peleable atacado);
}
