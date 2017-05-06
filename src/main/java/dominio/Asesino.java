package dominio;

/** Es uno de las distintas Casta que existen,
 * por lo cual reciben mismos metodos (habilidad1,habilidad2)
 * y atributos de la clase abstracta Casta.*/

public class Asesino extends Casta {
/** Constructor.
 * @param probCrit Contiene el porcentaje de probabilidad
 * de hacer un daño crítico
 * @param evasion  Contiene el porcentaje de probabilidad de evitar daÃ±o
 * @param dañoCrit Contiene el porcentaje de aumento de
 * ataque al hacer un daÃ±o crÃ­tico
 */

public Asesino(final double probCrit, final double evasion,
final double dañoCrit) {
super(probCrit, evasion, dañoCrit);
this.setNombreCasta("Asesino");
}

/**Constructor.*/
public Asesino() {
super();
this.setNombreCasta("Asesino");
String[] aux = {"Golpe Critico", "Aumentar Evasion", "Robar"};
this.setHabilidadesCasta(aux);
}

@Override
/**Primera habilidad de la Casta "Golpe CrÃ­tico": En caso de que el
 * invocador poseea energÃ­a, la disminuye en 10 (el costo de realizar la
 * habilidad); y luego ataca con los puntos de ataque del caster
 * incrementados por el porcentaje de golpe critico de su Casta.*/

public boolean habilidad1(final Personaje caster, final Peleable atacado) {
if (caster.getEnergia() > 10) {
caster.setEnergia(caster.getEnergia() - 10);
if (atacado.serAtacado((int) (caster.getAtaque() * caster.getCasta()
.getDañoCritico())) > 0) {
return true;
}
}
return false;
}

@Override
/**Segunda habilidad de la Casta "Aumentar Evasion":En caso de que el
 * invocador poseea energÃ­a, la disminuye en 10 (el costo de realizar la
 * habilidad) y aumenta en 15% la probabilidad de evitar daÃ±o siendo el
 * maximo total 50%.*/
public boolean habilidad2(final Personaje caster, final Peleable atacado) {
if (caster.getEnergia() > 10) {
caster.setEnergia(caster.getEnergia() - 10);
if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5) {
this.setProbabilidadEvitarDaño(this.getProbabilidadEvitarDaño() + 0.15);
} else {
this.setProbabilidadEvitarDaño(0.5);
return true;
}
}
return false;
}

@Override
/**Devuelve siempre falso.*/
public boolean habilidad3(final Personaje caster, final Peleable atacado) {
return false;
}

@Override
protected final void aumentarAtributos(final Personaje personaje) {
personaje.setDestreza(personaje.getDestreza() + 5);

}
}
