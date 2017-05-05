package dominio;
/**
 * Esta clase crea un NPC (NonPlayableCharacter) de dificultad aleatoria y a mayor dificultad sus
 * atributos son mayores 
 */
public class NonPlayableCharacter extends Entidad implements Peleable {

	private static final int dificultadAleatoria = -1;

	public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC) {
		super(nombre,nivel);
		int dificultad;
		if (dificultadNPC == dificultadAleatoria)
			dificultad = MyRandom.nextInt(3);
		else
			dificultad = dificultadNPC;

		switch (dificultad) {
		case 0:
			setFuerza(10 + (nivel - 1) * 3);// 30%
			setSalud(30 + (nivel - 1) * 15);
			setDefensa(2 + (nivel - 1) * 1);
			break;
		case 1:
			setFuerza(20 + (nivel - 1) * 6);// 50%
			setSalud(40 + (nivel - 1) * 20);
			setDefensa(5 + (nivel - 1) * 2);
			break;
		case 2:
			setFuerza(30 + (nivel - 1) * 10);// 50%
			setSalud(50 + (nivel - 1) * 25);
			setDefensa(4 + (nivel - 1) * 4);
			break;

		}
	}
	/**
	 * Otorga una experiencia equivalente a su nivel multiplicado por 30
	 */
	
	public int otorgarExp() {
		return this.getNivel() * 30;
	}

	public int atacar(Peleable atacado) {
		if (MyRandom.nextDouble() <= 0.15) {// los NPC tienen 15% de golpes criticos
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else
			return atacado.serAtacado(this.getAtaque());
	}

	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= 0.15) {
			daño -= this.getDefensa() / 2;
			if (daño > 0) {
				setSalud(getSalud() - daño);
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
	}

	public void despuesDeTurno() { }

	public void ganarExperiencia(int exp) {

	}

	public int getAtaque() {
		return getFuerza();
	}

	public void setAtaque(int ataque) {
		setFuerza(ataque);
	}
}
