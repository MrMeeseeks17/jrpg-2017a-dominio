package dominio;
import java.util.LinkedList;
/**
 * Esta clase contiene una lista enlazada de aliados/clanes con su nombre correspondiente
 */
public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;

	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}
	/**
	 * Devuelve una lista de aliados de una alianza especifica
	 */
	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}
	/**
	 * Devuelve el nombre de la alianza
	 */
	public String obtenerNombre(){
		return nombre;
	}
	
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
