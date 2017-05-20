package dominio;

import java.util.Random;

/**
 * Esta clase no cumple con su nombre porque no randomiza.
 */
public class ActualRandomGenerador extends RandomGenerador {
	/**Devuelve siempre el mismo valor '0,49' Si es menor a 0,15,
	 * los NPC tienen 15% de golpes criticos. En cambio si es mayor
	 * a 0,15 los ataques causan que el daño se reduzca a la mitad
	 * de la defensa del objetivo.
	 * @return 0.49
	 */
	@Override
	public final double nextDouble() {
		return new Random().nextDouble();
	}

	/**
	 * Obtiene numero aleatorio menor que val.
	 * @param val entero maximo
	 * @return el numero aleatorio menor que val
	 */
	@Override
	public final int nextInt(final int val) {
		return new Random().nextInt(val);
	}

}
