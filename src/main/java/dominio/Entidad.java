package dominio;

public abstract class Entidad {
	protected int salud;
	private int defensa;// depende de la destreza
	private String nombre;// hay que agregarlo a todos los constructores
	private int fuerza;
	private int nivel;

	/**
	 * Constructor.
	 * @param nombre Nombre de la entidad
	 * @param nivel Nivel de la entidad
	 */
	public Entidad(String nombre, int nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
	}

	public Entidad(String nombre, int salud, int fuerza, int nivel) {
		this.nombre = nombre;
		this.salud = salud;
		this.fuerza = fuerza;
		this.nivel = nivel;
	}

	public Entidad(String nombre, int nivel, int fuerza) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.fuerza = fuerza;
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public abstract int otorgarExp();

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFuerza() {
		return fuerza;
	}

	/**
	 * Setea el atributo fuerza del objeto llamador con el entero fuerza pasado
	 * por parametro
	 */
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
}
