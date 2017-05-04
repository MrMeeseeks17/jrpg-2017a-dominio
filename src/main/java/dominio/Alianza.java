package dominio;

import java.util.LinkedList;

/** Esta clase contiene una lista enlazada de aliados/clanes con su nombre
 * correspondiente. */

public class Alianza {
/**Contiene el nombre de la Alianza.*/
private String nombre;
/**Contiene el listado de objetos Personaje aliados.*/
private LinkedList<Personaje> aliados;

/** Constructor.
 * @param nom String con el nombre a asignar a la Alianza */
public Alianza(final String nom) {
this.nombre = nom;
this.aliados = new LinkedList<Personaje>();
}

/** Devuelve una lista de aliados de una alianza especifica.
 * @return Listado de los objetos personajes aliados */
public LinkedList<Personaje> getAliados() {
return aliados;
}

/** Define los miembros de la alianza.
 * @param alia2 Es la lista de elementos Personaje que conforman la alianza */
public void setAliados(final LinkedList<Personaje>  alia2) {
this.aliados = alia2;
}

/** Devuelve el nombre de la alianza.
 * @return String con el nombre de la Alianza*/
public String obtenerNombre() {
return nombre;
}

/** Elimina un miembro de la Alianza.
 * @param pj Es el objeto Personaje que se
 * desea sacar del listado de miembros*/
public void eliminarPersonaje(final Personaje pj) {
aliados.remove(pj);
}

/**Agrega un mimebro a la Alianza.
 * @param pj Es el objeto Personaje que se deaseea
 * incorporar al listado de miembros */
public void añadirPersonaje(final Personaje pj) {
aliados.add(pj);
}
}