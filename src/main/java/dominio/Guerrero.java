package dominio;

/**
 * Es uno de las distintas Casta que existen, por lo cual reciben mismos metodos
 * ( habilidad1,habilidad2 ) y atributos de la clase abstracta Casta.
 */
public class Guerrero extends Casta {

	public Guerrero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Guerrero";
	}

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	//
	/**
	 * Primera habilidad de la Casta "Ataque Doble":En caso de que el invocador
	 * poseea energía, la disminuye en 10 (el costo de realizar la habilidad)
	 * luego el daño que le causa al atacado es igual al ataque del caster
	 * multiplicado por 2
	 * 
	 * @return Devuelve verdadero en caso de tener energía suficiente y de haber
	 *         realizado daño al atacado, falso en caso contrario
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}

	//
	/**
	 * Segunda habilidad de la Casta "Aumentar Defensa":En caso de que el
	 * invocador poseea energía, la disminuye en 10 (el costo de realizar la
	 * habilidad) luego aumenta los puntos de defensa del caster equivalente a
	 * sus puntos de magia
	 * 
	 * @return Devuelve verdadero en caso de poder haber realizado la habilidad
	 *         o falso en caso contrario
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	/**
	 * Tercera habilidad de la Casta "Ignorar Defensa": En caso de que el
	 * atacante poseea energía, la disminuye en 10 (el costo de realizar la
	 * habilidad) y setea momenteneamente la defensa del objetivo a cero (0)
	 * previo al ataque, posteriormente la vuelve a su valor original
	 * 
	 * @return Devuelve verdadero en caso de que el objetivo sufrió daño y falso
	 *         en caso contrario
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
