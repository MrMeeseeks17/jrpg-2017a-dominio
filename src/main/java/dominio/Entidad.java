package dominio;

import java.util.HashMap;

/**
 * Entidad: Clase abstracta que hereda a Personaje y NonPlayableCharacter.
 * Define los atributos y métodos compartidos por ambas clases.
 */
public abstract class Entidad {
	/**
	 * Atributos HASH
	 */
	public static final String ATTR_SALUD = "salud";
	public static final String ATTR_FUERZA = "fuerza";
	public static final String ATTR_DEFENSA = "defensa";
	public static final String ATTR_NOMBRE = "nombre";
	public static final String ATTR_NIVEL = "nivel";
	
	/** salud Valor de salud de la Entidad. */
	protected int salud;
	/** defensa Valor de defensa de la Entidad. */
	protected int defensa;
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
		this.random = this.random;
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

	/**
	 * Actualizar datos desde hashmap
	 * @param datos salud,fuerza,defensa,nombre,nivel
	 */
	public void actualizar(final HashMap<String, Object> datos) {
		setSalud((Integer) datos.get(ATTR_SALUD));
		setFuerza((Integer) datos.get(ATTR_FUERZA));
		setDefensa((Integer) datos.get(ATTR_DEFENSA));
		setNombre((String) datos.get(ATTR_NOMBRE));
		setNivel((Integer) datos.get(ATTR_NIVEL));
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Devuelve hashmap con datos.
	 * @return datos en hashmap
	 */
	public HashMap<String, Object> getTodo() {
		HashMap<String, Object> datos = new HashMap<>();
		datos.put(ATTR_SALUD, getSalud());
		datos.put(ATTR_FUERZA, getFuerza());
		datos.put(ATTR_DEFENSA, getDefensa());
		datos.put(ATTR_NOMBRE, getNombre());
		datos.put(ATTR_NIVEL, getNivel());
		return datos;
	}
}
