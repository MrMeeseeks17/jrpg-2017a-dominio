package dominio;
/**
 * Esta clase no cumple con su nombre porque no randomiza
 */
public class MyRandom {

	/**
	 * devuelve siempre el mismo valor '0,49'
	 * Si es menor a 0,15, los NPC tienen 15% de golpes criticos. En cambio si es mayor a 0,15
	 * los ataques causan que el daño se reduzca a la mitad de la defensa del objetivo.
	 */
	public static double nextDouble() {
		return 0.49;
	}
	/**
	 * Devuelve el numero entero que recibe menos uno.
	 * @param numero entero a descontar.

	 */
	public static int nextInt(int val) {
		return val - 1;
	}
	
}
