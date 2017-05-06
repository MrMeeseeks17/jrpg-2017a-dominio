package dominio;

/**
 * Es una de las distintas razas de personajes que existen, por lo cual reciben
 * mismos metodos ( habilidadRaza1,habilidadRaza2 ) y atributos de la clase
 * abstracta Personaje.
 */
public class Elfo extends Personaje {

/**Constructor.
 * @param nombre Contiene el nombre del Personaje
 * @param casta Contiene la Casta del Personaje
 * @param id Contiene el id del Personaje
 */
public Elfo(final String nombre, final Casta casta, final int id) {
super(nombre, casta, id, 0, 10, "Elfo");
String[] aux = {"Golpe Level", "Ataque Bosque"};
this.setHabilidadesRaza(aux);
}

/**Constructor.
 * @param nombre Nombre del Personaje
 * @param salud Puntos de salud del Personaje
 * @param energia Puntos de energía del Personaje
 * @param fuerza Puntos de fuerza del Personaje
 * @param destreza Destreza del Personaje
 * @param inteligencia Inteligencia del Personaje
 * @param casta Clasificación del Personaje
 * @param experiencia Experiencia del Personaje
 * @param nivel NIvel del Personaje
 * @param idPersonaje Identificador del Personaje
 */
public Elfo(final String nombre, final  int salud, final int energia,
final int fuerza, final int destreza, final int inteligencia, final Casta casta,
final int experiencia, final int nivel, final int idPersonaje) {
super(nombre, salud, energia, fuerza, destreza,
inteligencia, casta, experiencia, nivel, idPersonaje, "Elfo");
String[] aux = {"Golpe Level", "Ataque Bosque"};
this.setHabilidadesRaza(aux);
}

@Override
/**Primera habilidad del personaje "Golpe Level": El daño que causa es igual
 * a su nivel multiplicado por 10 + la fuerza del personaje.*/
public boolean habilidadRaza1(final Peleable atacado) {
if (this.getEnergia() > 10) {
this.setEnergia(this.getEnergia() - 10);
if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0) {
return true;
}
}
return false;
}

@Override
/** Primera habilidad del personaje "Ataque Bosque": ataca a un objetivo con
 * un daño equivalente a su magia.*/
public boolean habilidadRaza2(final Peleable atacado) {
if (this.getEnergia() > 10) {
this.setEnergia(this.getEnergia() - 10);
if (atacado.serAtacado((int) (this.getMagia())) > 0) {
return true;
}
}
return false;
}
}
