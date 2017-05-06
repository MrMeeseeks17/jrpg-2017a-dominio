package dominio;

import java.io.Serializable;

/** Clase abstracta que hereda a Elfo, Humano y Orco. Esta clase define las
 * estadísticas,id,niveles, clanes ,posición del personaje */
public abstract class Personaje extends Entidad
implements Peleable, Serializable {
/** energia Contiene los puntos de energía del personaje. */
private int energia;
/** ataque Contiene el poder de ataque dependiendo de la fuerza del
 * personaje. */
private int ataque;
/** magia Contiene los puntos de magia del personaje. */
private int magia;
/** nombreRaza Contiene el nombre de raza del personaje. */
private String nombreRaza;
/** saludTope Contiene los puntos máximos de salud del personaje. */
private int saludTope;
/** energiaTope Contiene los puntos máximos de energía del personaje. */
private int energiaTope;
/** destreza Contiene los puntos de destreza del personaje. */
private int destreza;
/** inteligencia Contiene los puntos de inteligencia del personaje. */
private int inteligencia;
/** casta Contiene el tipo de casta del personaje. */
private Casta casta;

/** x Contiene la posición en el eje x del personaje. */
private int x;
/** y Contiene la posición en el eje y del personaje. */
private int y;

/** experiencia Contiene los puntos de experiencia del personaje. */
private int experiencia;
/** idPersonaje Contiene el identificador del personaje. */
private int idPersonaje;

/** clan Contiene el clan al que pertenece el personaje. */
private Alianza clan = null;
/** tablaDeNiveles Contiene la tabla de niveles del personaje. */
public static int[] tablaDeNiveles;
/** habilidadesRaza Contiene las habilidades de la raza a la que pertenece
 * el personaje. */
private String[] habilidadesRaza;

/**Setter de Habilidades de raza.
 * @param habilRaza Devuelvelas habilidades de la raza a la que pertenece el
 *         personaje. */
public void setHabilidadesRaza(final String[] habilRaza) {
this.habilidadesRaza = habilRaza;
}
/** Getter de Habilidades de raza.
 * @return String[] Devuelvelas habilidades de la raza a la que pertenece el
 *         personaje. */
public String[] getHabilidadesRaza() {
return habilidadesRaza;
}
/** Getter de Habilidades de casta.
 * @return String[] Devuelve las habilidades de la casta a la que pertenece el
 *         personaje. */
public String[] getHabilidadesCasta() {
return casta.getHabilidadesCasta();
}
/** Carga de tabla de niveles. Carga la tabla de niveles del personaje. */
public static void cargarTablaNivel() {
Personaje.tablaDeNiveles = new int[101];
Personaje.tablaDeNiveles[0] = 0;
Personaje.tablaDeNiveles[1] = 0;
for (int i = 2; i < 101; i++) {
Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
}
}

/** Constructor.
 * Asigna un valor y crea un objeto Personaje.
 * Recibe valor del atributo nombre, Casta e id
 * @param nombre2 Nombre del personaje
 * @param casta2 Clasificacion de personaje
 * @param id2 Identificador del Personaje
 * @param incrementoEnergia Valor de incremento de la energía
 * @param incrementoSalud Valor de incremento de la salud
 * @param nombRaza Nombre de raza del personaje*/
public Personaje(final String nombre2, final Casta casta2, final int id2,
final int incrementoSalud, final int incrementoEnergia, final String nombRaza) {
super(nombre2, 1, 10);
this.casta = casta2;
this.idPersonaje = id2;
this.experiencia = 0;
this.inteligencia = 10;
this.destreza = 10;
casta.aumentarAtributos(this);
x = 0;
y = 0;
saludTope = 100 + incrementoSalud;
energiaTope = 100 + incrementoEnergia;
this.setSalud(saludTope);
this.setEnergia(energiaTope);
nombreRaza = nombRaza;
ataque = this.calcularPuntosDeAtaque();
setDefensa(this.calcularPuntosDeDefensa());
magia = this.calcularPuntosDeMagia();
}

/**Constructor.
 * @param nombre Nombre del Personaje
 * @param salud Puntos de salud del Personaje
 * @param energ Puntos de energía del Personaje
 * @param fuerza Puntos de fuerza del Personaje
 * @param destre Destreza del Personaje
 * @param intel Inteligencia del Personaje
 * @param cast Clasificación del Personaje
 * @param exp Experiencia del Personaje
 * @param nivel NIvel del Personaje
 * @param id Identificador del Personaje
 * @param nombRaza */

public Personaje(final String nombre, final int salud, final int energ,
final int fuerza, final int destre, final int intel,
final Casta cast, final int exp, final int nivel,
final int id, final String nombRaza) {
super(nombre, salud, fuerza, nivel);

this.energia = energ;
this.destreza = destre;
this.inteligencia = intel;
this.casta = cast;
this.experiencia = exp;
nombreRaza = nombRaza;
this.saludTope = getSalud();
this.energiaTope = this.energia;

this.idPersonaje = id;
setDefensa(this.calcularPuntosDeDefensa());
this.ataque = this.calcularPuntosDeAtaque();
this.magia = this.calcularPuntosDeMagia();
}

/**Getter del nombre de raza.
 * @return String Devuelve el nombre de raza del presonaje*/
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
public int atacar(final Peleable atacado) {
if (getSalud() == 0) {
return 0;
}
if (atacado.getSalud() > 0) {
if (MyRandom.nextDouble()
<= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
return atacado.serAtacado(this.golpeCritico());
} else {
return atacado.serAtacado(this.ataque);
}
}
return 0;
}
/** Método golpeCritico: Calcula el daño crítico que hará el personaje. El
 * cálculo se realiza a partir de la casta y fuerza de ataque del personaje
 * @return Valor de golpe crítico hecho por el personaje. */
public int golpeCritico() {
return (int) (this.ataque * this.getCasta().getDañoCritico());
}
/** Método despuesDeTurno: . */
public void despuesDeTurno() {

}
/** Método puedeAtacar: Verifica si tiene la energía suficiente para atacar.
 * @return True si la energía es mayor a la mínima necesaria, de lo contrario
 *         devuelve False. */
public boolean puedeAtacar() {
return energia > 10;
}
/** Método calcularPuntosDeAtaque: calcula el ataque según los puntos de fuerza.
 * @return Valor de la fuerza multiplicado por 1,5. */
public int calcularPuntosDeAtaque() {
return (int) (this.getFuerza() * 1.5);
}
/** Método calcularPuntosDeDefensa: calcula la defensa según la destreza.
 * @return Valor de los puntos de defensa. */
public int calcularPuntosDeDefensa() {
return (int) (this.getDestreza());
}
/** Método calcularPuntosDeMagia: calcula la magia según la inteligencia.
 * @return Valor de la inteligencia multiplicado por 1,5. */
public int calcularPuntosDeMagia() {
return (int) (this.getInteligencia() * 1.5);
}
/** Método restablecerSalud: restaura la salud del personaje a su estado
 * inicial. */
public void restablecerSalud() {
setSalud(this.saludTope);
}
/** Método restablecerEnergia: restaura la energia del personaje a su estado
 * inicial. */
public void restablecerEnergia() {
this.energia = this.energiaTope;
}
/** Método modificarAtributos: Modifica los puntos de ataque según la fuerza,
 * defensa según la destreza y magia según la inteligencia del personaje. */
public void modificarAtributos() {
this.ataque = this.calcularPuntosDeAtaque();
setDefensa(this.calcularPuntosDeDefensa());
this.magia = this.calcularPuntosDeMagia();
}

@Override
/** Metodo serAtacado: Calcula el daño que recibe el Objeto que llama al metodo.
 * @return Valor Entero del daño que recibe el objeto llamador.
 * @param daño Valor Entero. Cantidad de daño recibido. */
public int serAtacado(final int daño) {
if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
int dañoRecibido =  daño - getDefensa();
if (dañoRecibido > 0) {
if (getSalud() <= dañoRecibido) {
dañoRecibido = getSalud();
setSalud(0);
} else {
setSalud(getSalud() - dañoRecibido);
}
return dañoRecibido;
}
return 0;
}
return 0;
}


/** Método serRobadoSalud: Calcula la cantidad de puntos de salud que le son
 * quitados al Personaje atacado según el daño infligido. Si la cantidad de daño
 * es mayor a los puntos de salud, el daño real será igual a los mismos.
 * @param daño Valor del daño recibido.
 * @return Valor real del daño hecho. */
public int serRobadoSalud(final int daño) {
int dañoRecibido =  daño - this.getDefensa();
if (dañoRecibido <= 0) {
return 0;
}
if ((getSalud() - dañoRecibido) >= 0) {
setSalud(getSalud() - dañoRecibido);
} else {
dañoRecibido = getSalud();
setSalud(0);
}
return dañoRecibido;
}


/** Método serDesernegizado: Calcula la cantidad de energía que se le quita a un
 * Personaje según la cantidad de daño infligido.
 * @param daño Valor de daño infligido.
 * @return Valor de energía quitada si el daño supera a la defensa. Si el daño
 *         también supera la energía, entonces el valor del daño hecho es igual
 *         a la energía poseída y la energía queda en 0. */
public int serDesernegizado(final int daño) {
int dañoRecibido = daño - this.getDefensa();
if (dañoRecibido <= 0) {
return 0;
}
if ((energia - dañoRecibido) >= 0) {
energia -= dañoRecibido;
} else {
dañoRecibido = energia;
energia = 0;
}
return dañoRecibido;
}

/** Método serCurado: Incrementa la salud del Personaje según el valor recibido,
 * teniendo en cuenta el tope de puntos de salud.
 * @param salud Valor de salud recibida. */
public void serCurado(final int salud) {
if ((this.getSalud() + salud) <= this.saludTope) {
setSalud(getSalud() + salud);
} else {
setSalud(this.saludTope);
}
}
/** Método serEnergizado: Incrementa la energía del Personaje según el valor
 * recibido, teniendo en cuenta el tope de puntos de energía.
 * @param energ Valor de energía recibida. */
public void serEnergizado(final int energ) {
if ((this.energia + energ) <= this.energiaTope) {
this.energia += energ;
} else {
this.energia = this.energiaTope;
}
}
/** Método crearAlianza: Crea una alianza nueva y agrega al Personaje como
 * miembro.
 * @param nombreAlianza Nombre de la nueva alianza creada. */
public void crearAlianza(final String nombreAlianza) {
this.clan = new Alianza(nombreAlianza);
this.clan.añadirPersonaje(this);
}
/** Método salirDeAlianza: Elimina al Personaje de su Alianza. */
public void salirDeAlianza() {
if (this.clan != null) {
this.clan.eliminarPersonaje(this);
this.clan = null;
}
}
/** Método aliar: Alía dos personajes si estos no tienen alianza, el llamador y
 * el que recibe por parámetro.
 * @param nuevoAliado Recibe el Personaje que se agrega a la Alianza.
 * @return True si ambos Personajes no tenía ninguna Alianza y se pudo agregar
 *         realizar la misma. False si algún personaje ya tenía Alianza. */
public boolean aliar(final Personaje nuevoAliado) {
if (this.clan == null) {
Alianza a = new Alianza("Alianza 1");
this.clan = a;
a.añadirPersonaje(this);
}

if (nuevoAliado.clan == null) {
nuevoAliado.clan = this.clan;
this.clan.añadirPersonaje(nuevoAliado);
return true;
} else {
return false;
}
}
/** Método asignarPuntosSkills: Incrementa los puntos de fuerza, destreza e
 * inteligencia mientras no superen los 200 puntos.
 * @param fuerza Cantidad de puntos de fuerza recibidos.
 * @param dest Cantidad de puntos de destreza recibidos.
 * @param intel Cantidad de puntos de inteligencia recibidos. */
public void AsignarPuntosSkills(final int fuerza, final int dest,
final int intel) {
if (this.getFuerza() + fuerza <= 200) {
setFuerza(this.getFuerza() + fuerza);
}
if (this.destreza + dest <= 200) {
this.destreza += dest;
}
if (this.inteligencia + intel <= 200) {
this.inteligencia += intel;
}
this.modificarAtributos();
}
/** Método subirNivel: Sube el nivel del personaje mientras no sea el nivel
 * máximo y si la experiencia del personaje es suficiente para avanzar al
 * siguiente nivel en la tabla de niveles. Además se modifican los atributos por
 * nivel y se incrementan los topes de salud y energía. Se resta la experiencia
 * usada para subir de nivel. */
public void subirNivel() {

int acumuladorExperiencia = 0;
if (this.getNivel() == 100) {
return;
}
while (this.getNivel() != 100
&& (this.experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1]
+ acumuladorExperiencia)) {
acumuladorExperiencia += Personaje.tablaDeNiveles[this.getNivel() + 1];
setNivel(this.getNivel() + 1);
this.modificarAtributos();
this.saludTope += 25;
this.energiaTope += 20;
}
this.experiencia -= acumuladorExperiencia;
}
/** Método ganarExperiencia: Incrementa la experiencia según el valor recibido y
 * sube de nivel si la experiencia incrementada es mayor o igual a la necesaria
 * para estar en el siguiente nivel.
 * @param exp Valor de experiencia recibida.
 * @return True si el Personaje subió de nivel, False en caso contrario. */
public boolean ganarExperiencia(final int exp) {
this.experiencia += exp;

if (experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1]) {
subirNivel();
return true;
}
return false;
}
/** Método otorgarExp: Otorga una experiencia equvalente a su nivel multiplicado
 * por 40.
 * @return Valor de la experiencia nueva. */
public int otorgarExp() {
return this.getNivel() * 40;
}
/** Método clone: Se hereda de Entidad. */
@Override
protected Object clone() throws CloneNotSupportedException {
return super.clone();
}
/** Método distanciaCon: Calcula la distancia con un Personaje recibido.
 * @param p Personaje distanciado.
 * @return Valor de la distancia. */
public double distanciaCon(final Personaje p) {
return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
}
/** Método habilidadCasta1: Pide calcular la posibilidad de efectuar la
 * habilidad 1, según la casta del personaje.
 * @param atacado Objeto peleable al que se ataca.
 * @return True si hay posibilidad de ocurrencia, False en caso contrario. */
public boolean habilidadCasta1(final Peleable atacado) {
return this.getCasta().habilidad1(this, atacado);
}
/** Método habilidadCasta2: Pide calcular la posibilidad de efectuar la
 * habilidad 2, según la casta del personaje.
 * @param atacado Objeto peleable al que se ataca.
 * @return True si hay posibilidad de ocurrencia, False en caso contrario. */
public boolean habilidadCasta2(final Peleable atacado) {
return this.getCasta().habilidad2(this, atacado);
}
/** Método habilidadCasta3: Pide calcular la posibilidad de efectuar la
 * habilidad 3, según la casta del personaje.
 * @param atacado Objeto peleable al que se ataca.
 * @return True si hay posibilidad de ocurrencia, False en caso contrario. */
public boolean habilidadCasta3(final Peleable atacado) {
return this.getCasta().habilidad3(this, atacado);
}
/** Método habilidadRaza1: Habilidad 1 implementada por la raza del Personaje.
 * @param atacado Objeto peleable al que se ataca.
 * @return boolean */
public abstract boolean habilidadRaza1(Peleable atacado);
/** Método habilidadRaza2: Habilidad 2 implementada por la raza del Personaje.
 * @param atacado Objeto peleable al que se ataca.
 * @return boolean */
public abstract boolean habilidadRaza2(Peleable atacado);

public final boolean serAtacadoPorGerreroh3(int ataqueRecibido) {
int defensaOriginal = this.getDefensa();
this.setDefensa(0);
if (this.serAtacado(ataqueRecibido)  > 0) {
this.setDefensa(defensaOriginal);
return true;
}
return false;
}

public final boolean serAsistidoPorHechicero(int puntosCurados) {
this.serCurado(puntosCurados);
return true;
}

public final boolean serRobadoPorHechicero(final Personaje caster) {
int energiaRobada =
this.serDesernegizado(caster.calcularPuntosDeMagia());
int saludRobada =
this.serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
caster.serEnergizado(energiaRobada);
caster.serCurado(saludRobada);
return true;
}

}