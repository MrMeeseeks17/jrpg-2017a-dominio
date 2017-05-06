package dominio;

/**
 * Es uno de las distintas razas de personajes que existen, por lo cual reciben
 * mismos metodos ( habilidadRaza1,habilidadRaza2 ) y atributos de la clase
 * abstracta Personaje.
 */
public class Humano extends Personaje {

/**Constructor.
 * @param nombre Contiene el nombre del Personaje
 * @param casta Contiene la Casta del Personaje
 * @param id Contiene el id del Personaje*/
public Humano(final String nombre, final Casta casta, final int id) {
super(nombre, casta, id, 5, 5, "Humano");

String[] aux = {"Incentivar", "Golpe Fatal"};
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
 * @param idPersonaje Identificador del Personaje*/
public Humano(final String nombre, final int salud, final int energia,
final int fuerza, final int destreza, final int inteligencia, final Casta casta,
final int experiencia, final int nivel, final int idPersonaje) {
super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
experiencia, nivel, idPersonaje, "Humano");

String[] aux = {"Incentivar", "Golpe Fatal"};
this.setHabilidadesRaza(aux);
}

@Override
/**Primera habilidad del personaje "Incentivar":Es una habilidad de apoyo,
 * en caso de que el invocador poseea energía, la disminuye en 10 (el costo
 * de realizar la habilidad) luego obtiene el atributo ataque del aliado
 * objetivo y lo incrementa con sus puntos de magia aumentando el daño del
 * objetivo.*/
public boolean habilidadRaza1(final Peleable atacado) {
if (this.getEnergia() > 10) {
this.setEnergia(this.getEnergia() - 10);
atacado.setAtaque(atacado.getAtaque() + this.getMagia());
return true;
}
return false;
}

@Override
/**Segunda habilidad del personaje "Golpe Fatal": En caso de que el
 * invocador poseea energía, ataca con tantos puntos de ataque como la mitad
 * de la salud del objetivo y en caso de causarle daño disminuye la energía
 * del caster a la mitad, si no le resta los 10 puntos de costo
 * tradicionales.*/
public boolean habilidadRaza2(final Peleable atacado) {
if (this.getEnergia() > 10) {
if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
this.setEnergia(this.getEnergia() / 2);
return true;
}
this.setEnergia(this.getEnergia() - 10);
}
return false;
}
}
