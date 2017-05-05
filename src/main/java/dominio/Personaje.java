package dominio;

import java.io.Serializable;

/** Clase abstracta que hereda a Elfo, Humano y Orco. Esta clase define las
 * estadísticas,id,niveles, clanes ,posición del personaje */
public abstract class Personaje extends Entidad implements Peleable, Serializable {
// Campos de la clase.
protected int energia;
protected int ataque; // depende de la fuerza
protected int magia; // depende de la inteligencia

protected String nombreRaza;

protected int saludTope;
protected int energiaTope;

protected int destreza;
protected int inteligencia;
protected Casta casta;

protected int x;
protected int y;

protected int experiencia;
protected int idPersonaje;

protected Alianza clan = null;
public static int tablaDeNiveles[];

protected String[] habilidadesRaza;

public String[] getHabilidadesRaza() {
	return habilidadesRaza;
}

public String[] getHabilidadesCasta() {
	return casta.getHabilidadesCasta();
}

public static void cargarTablaNivel() {
	Personaje.tablaDeNiveles = new int[101];
	Personaje.tablaDeNiveles[0] = 0;
	Personaje.tablaDeNiveles[1] = 0;
	for (int i = 2; i < 101; i++)
		Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
}

/** Constructor.
 * Asigna un valor y crea un objeto Personaje.
 * Recibe valor del atributo nombre, Casta e id
 * @param nombre2 Nombre del personaje
 * @param casta2 Clasificacion de personaje
 * @param id2 Identificador del Personaje */
public Personaje(final String nombre2, final Casta casta2, final int id2) {
	super(nombre2, /* nivel */1, /* fuerza */10);
	this.casta = casta2;
	this.idPersonaje = id2;
	this.experiencia = 0;
	this.inteligencia = 10;
	this.destreza = 10;
	if (casta2 instanceof Guerrero) {
		setFuerza(getFuerza() + 5);
	}
	if (casta2 instanceof Hechicero) {
		inteligencia += 5;
	}
	if (casta2 instanceof Asesino) {
		destreza += 5;
	}

	x = 0;
	y = 0;
	saludTope = 100;
	energiaTope = 100;

	ataque = this.calcularPuntosDeAtaque();
	setDefensa(this.calcularPuntosDeDefensa());
	magia = this.calcularPuntosDeMagia();

}

/**
 * Constructor.
 * Asigna un valor y crea un objeto Personaje.
 * Recibe valor del atributo nombre, Casta e id
 * @param nombre2 Nombre del Personaje
 * @param salud2 Puntos de salud del Personaje
 * @param energia2 Puntos de energía del Personaje
 * @param fuerza2 Puntos de fuerza del Personaje
 * @param destreza2 Destreza del Personaje
 * @param inteligencia2 Inteligencia del Personaje
 * @param casta2 Clasificación del Personaje
 * @param experiencia2 Experiencia del Personaje
 * @param nivel2 NIvel del Personaje
 * @param idPersonaje2 Identificador del Personaje
 */
public Personaje(final String nombre2, final int salud2, final int energia2,
		final int fuerza2, final int destreza2, final int inteligencia2,
		final Casta casta2, final int experiencia2, final int nivel2,
		final int idPersonaje2) {

	super(nombre2, salud2, fuerza2, nivel2);

	this.energia = energia2;
	this.destreza = destreza2;
	this.inteligencia = inteligencia2;
	this.casta = casta2;

	this.experiencia = experiencia2;

	this.saludTope = getSalud();
	this.energiaTope = this.energia;

	this.idPersonaje = idPersonaje2;
	setDefensa(this.calcularPuntosDeDefensa());
	this.ataque = this.calcularPuntosDeAtaque();
	this.magia = this.calcularPuntosDeMagia();
}
/**Getter del nombre de raza.
 * @return String Devuelve el nombre de raza del presonaje
 */
public String getNombreRaza() {
	return nombreRaza;
}
/**Setter del nombre de raza.
 * @param nombreRaza2 Nombre de raza del presonaje
 */
public void setNombreRaza(final String nombreRaza2) {
	this.nombreRaza = nombreRaza2;
}
/**Getter de Ataque.
 * @return int Devuelve cantidad de poder de ataque del personaje
 */
public int getAtaque() {
	return ataque;
}
/**Setter de Ataque.
 * @param ataque2 Poder de ataque del personaje
 */
public void setAtaque(final int ataque2) {
	this.ataque = ataque2;
}
/**Getter de Magia.
 * @return int Devuelve cantidad de magia del personaje
 */
public int getMagia() {
	return magia;
}
/**Setter de Magia.
 * @param magia2 Magia del personaje
 */
public void setMagia(final int magia2) {
	this.magia = magia2;
}
/**Getter de Clan.
 * @return Alianza Devuelve la alianza a la que pertenece el personaje
 */
public Alianza getClan() {
	return clan;
}
/**Setter de Clan.
 * @param clan2 Alianza a la que pertenece el personaje
 */
public void setClan(final Alianza clan2) {
	this.clan = clan2;
	clan2.añadirPersonaje(this);
}
/**Getter de Energia.
 * @return int Devuelve la cantidad de energía del personaje
 */
public int getEnergia() {
	return energia;
}
/**Setter de Energia.
 * @param energia2 Recibe la cantidad de energía del personaje
 */
public void setEnergia(final int energia2) {
	this.energia = energia2;
}
/**Getter de Destreza.
 * @return int Devuelve la destreza del personaje
 */
public int getDestreza() {
	return destreza;
}
/**Setter de Destreza.
 * @param destreza2 Recibe la destreza del personaje
 */
public void setDestreza(final int destreza2) {
	this.destreza = destreza2;
}
/**Getter de Inteligencia.
 * @return int Devuelve la inteligencia del personaje
 */
public int getInteligencia() {
	return inteligencia;
}
/**Setter de Inteligencia.
 * @param inteligencia2 Recibe la inteligencia del personaje
 */
public void setInteligencia(final int inteligencia2) {
	this.inteligencia = inteligencia2;
}
/**Getter de Casta.
 * @return Casta Devuelve la clasificación a la que pertenece el personaje
 */
public Casta getCasta() {
	return casta;
}
/**Setter de Casta.
 * @param casta2 Recibe la clasificación a la que pertenece el personaje
 */
public void setCasta(final Casta casta2) {
	this.casta = casta2;
}
/**Getter de Experiencia.
 * @return int Devuelve los puntos de experiencia del personaje
 */
public int getExperiencia() {
	return experiencia;
}
/**Setter de Experiencia.
 * @param experiencia2 Recibe los puntos de experiencia del personaje
 */
public void setExperiencia(final int experiencia2) {
	this.experiencia = experiencia2;
}
/**Getter de IdPersonaje.
 * @return int Devuelve el identificador del personaje
 */
public int getIdPersonaje() {
	return idPersonaje;
}
/**Setter de IdPersonaje.
 * @param idPersonaje2 Recibe el identificador del personaje
 */
public void setIdPersonaje(final int idPersonaje2) {
	this.idPersonaje = idPersonaje2;
}
/**Getter de SaludTope.
 * @return int Devuelve el tope de salud del personaje
 */
public int getSaludTope() {
	return saludTope;
}
/**Setter de SaludTope.
 * @param saludTope2 Recibe el tope de salud del personaje
 */
public void setSaludTope(final int saludTope2) {
	this.saludTope = saludTope2;
}
/**Getter de EnergiaTope.
 * @return int Devuelve el tope de energia del personaje
 */
public int getEnergiaTope() {
	return energiaTope;
}
/**Setter de EnergiaTope.
 * @param energiaTope2 Recibe el tope de energia del personaje
 */
public void setEnergiaTope(final int energiaTope2) {
	this.energiaTope = energiaTope2;
}

/** Metodo atacar: Calcula el daño recibido al Objeto de Entrada.
 * @return Valor entero del daño que recibe el objeto de Entrada Peleable
 * @param atacado Peleable que recibe el ataque. */
public int atacar(Peleable atacado) {
	if (getSalud() == 0)
		return 0;
	if (atacado.getSalud() > 0) {
		if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
			return atacado.serAtacado(this.golpe_critico());
		} else {
			return atacado.serAtacado(this.ataque);
		}
	}
	return 0;
}

public int golpe_critico() {
	return (int) (this.ataque * this.getCasta().getDañoCritico());
}

public void despuesDeTurno() {

}

public boolean puedeAtacar() {
	return energia > 10;
}

public int calcularPuntosDeAtaque() {
	return (int) (this.getFuerza() * 1.5);
}

public int calcularPuntosDeDefensa() {
	return (int) (this.getDestreza());
}

public int calcularPuntosDeMagia() {
	return (int) (this.getInteligencia() * 1.5);
}

public void restablecerSalud() {
	setSalud(this.saludTope);
}

public void restablecerEnergia() {
	this.energia = this.energiaTope;
}

public void modificarAtributos() {
	this.ataque = this.calcularPuntosDeAtaque();
	setDefensa(this.calcularPuntosDeDefensa());
	this.magia = this.calcularPuntosDeMagia();
}

/** Metodo atacar: Calcula el daño que recibe el Objeto que llama al metodo.
 * 
 * @return Valor Entero del daño que recibe el objeto llamador.
 * @param Valor Entero. Cantidad de daño recibido. */
public int serAtacado(int daño) {
	if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
		daño -= getDefensa();
		if (daño > 0) {
			if (getSalud() <= daño) {
				daño = getSalud();
				setSalud(0);
			} else {
				setSalud(getSalud() - daño);
			}
			return daño;
		}
		return 0;
	}
	return 0;
}

public int serRobadoSalud(int daño) {
	daño -= this.getDefensa();
	if (daño <= 0)
		return 0;
	if ((getSalud() - daño) >= 0)
		setSalud(getSalud() - daño);
	else {
		daño = getSalud();// le queda menos salud que el daño inflingido
		setSalud(0);
	}
	return daño;
}

public int serDesernegizado(int daño) {
	daño -= this.getDefensa();
	if (daño <= 0)
		return 0;
	if ((energia - daño) >= 0)
		energia -= daño;
	else {
		daño = energia;// le queda menos energia que el daño inflingido
		energia = 0;
	}
	return daño;
}

public void serCurado(int salud) {
	if ((this.getSalud() + salud) <= this.saludTope)
		setSalud(getSalud() + salud);
	else
		setSalud(this.saludTope);
}

public void serEnergizado(int energia) {
	if ((this.energia + energia) <= this.energiaTope)
		this.energia += energia;
	else
		this.energia = this.energiaTope;
}

public void crearAlianza(String nombre_alianza) {
	this.clan = new Alianza(nombre_alianza);
	this.clan.añadirPersonaje(this);
}

public void salirDeAlianza() {
	if (this.clan != null) {
		this.clan.eliminarPersonaje(this);
		this.clan = null;
	}
}

public boolean aliar(Personaje nuevo_aliado) {
	if (this.clan == null) {
		Alianza a = new Alianza("Alianza 1");
		this.clan = a;
		a.añadirPersonaje(this);
	}

	if (nuevo_aliado.clan == null) {
		nuevo_aliado.clan = this.clan;
		this.clan.añadirPersonaje(nuevo_aliado);
		return true;
	} else
		return false;
}

public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
	if (this.getFuerza() + fuerza <= 200)
		setFuerza(this.getFuerza() + fuerza);
	if (this.destreza + destreza <= 200)
		this.destreza += destreza;
	if (this.inteligencia + inteligencia <= 200)
		this.inteligencia += inteligencia;
	this.modificarAtributos();
}

public void subirNivel() {

	int acumuladorExperiencia = 0;
	if (this.getNivel() == 100) {
		return;
	}
	while (this.getNivel() != 100
			&& (this.experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1] + acumuladorExperiencia)) {
		acumuladorExperiencia += Personaje.tablaDeNiveles[this.getNivel() + 1];
		setNivel(this.getNivel() + 1);
		this.modificarAtributos();
		this.saludTope += 25;
		this.energiaTope += 20;
	}
	this.experiencia -= acumuladorExperiencia;
}

public boolean ganarExperiencia(int exp) {
	this.experiencia += exp;

	if (experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1]) {
		subirNivel();
		return true;
	}
	return false;
}

public int otorgarExp() {
	return this.getNivel() * 40;
}

@Override
protected Object clone() throws CloneNotSupportedException {
	return super.clone();
}

public double distanciaCon(Personaje p) {
	return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
}

public boolean habilidadCasta1(Peleable atacado) {
	return this.getCasta().habilidad1(this, atacado);
}

public boolean habilidadCasta2(Peleable atacado) {
	return this.getCasta().habilidad2(this, atacado);
}

public boolean habilidadCasta3(Peleable atacado) {
	return this.getCasta().habilidad3(this, atacado);
}

public abstract boolean habilidadRaza1(Peleable atacado);

public abstract boolean habilidadRaza2(Peleable atacado);
}
// Fin de la clase