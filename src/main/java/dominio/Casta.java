package dominio;

import java.io.Serializable;

/**
 * Clase abstracta que hereda a Guerrero, Hechicero y Asesino. Añade a los
 * mismos los atributos de probabilidad, daño, evasión, daño critico,
 * nombreCasta y un vector llamado habilidadesCasta.*/

public abstract class Casta implements Serializable {
/**Contiene el porcentaje de probabilidad
 * de hacer un daño crítico.*/
private double probabilidadGolpeCritico;
/**Contiene el porcentaje de probabilidad
 * de evitar daño.*/
private double probabilidadEvitarDaño;
/**Contiene el porcentaje de aumento de
 * ataque al hacer un daño crítico.*/
private double dañoCritico;
/**Contiene el nombre de la Casta.*/
private String nombreCasta;
/**Contiene el arreglo de habilidades de la Casta.*/
private String[] habilidadesCasta;

/**Constructor.*/
public Casta() {
this.probabilidadGolpeCritico = 0.2;
this.probabilidadEvitarDaño = 0.2;
this.dañoCritico = 1.5;
}

/**Constructor.
 * @param probCrit Recibe valor del atributo de probabilidad de golpe critico.
 * @param evasion Recibe valor del atributo de evasión.
 * @param dañoCrit Recibe valor del atributo de daño crítico.*/
public Casta(final double probCrit, final double evasion,
final double dañoCrit) {
this.probabilidadGolpeCritico = probCrit;
this.probabilidadEvitarDaño = evasion;
this.dañoCritico = dañoCrit;
}

/**Especificación del método habilidad1 de la casta.
 * @param caster Objeto Personaje realizante de la habilidad
 * @param atacado Objeto Peleable objetivo de la habilidad
 * @return Devuelve verdadero en caso de haber realizado correctamente
 * la habilidad, falso en caso contrario*/
public abstract boolean habilidad1(Personaje caster, Peleable atacado);

/**Especificación del método habilidad2 de la casta.
 * @param caster Objeto Personaje realizante de la habilidad
 * @param atacado Objeto Peleable objetivo de la habilidad
 * @return Devuelve verdadero en caso de haber realizado correctamente
 * la habilidad, falso en caso contrario*/
public abstract boolean habilidad2(Personaje caster, Peleable atacado);

/**Especificación del método habilidad3 de la casta.
 * @param caster Objeto Personaje realizante de la habilidad
 * @param atacado Objeto Peleable el cual es atacado
 * @return Devuelve verdadero en caso de haber realizado correctamente
 * la habilidad, falso en caso contrario*/
public abstract boolean habilidad3(Personaje caster, Peleable atacado);

/**Define el nombre de la Casta.
 * @param nombrCasta String con el nombre de la Casta*/
public void setNombreCasta(final String nombrCasta) {
this.nombreCasta = nombrCasta;
}

/**Devuelve el nombre de la Casta (Hechicero, Guerrero o Asesino).
 * @return String con el nombre de Casta*/
public String getNombreCasta() {
return this.nombreCasta;
}

/**Define el arreglo de habilidades de la Casta.
 * @param habilCasta Contiene el arreglo de habilidades a asiganar
 */
public void setHabilidadesCasta(final String[] habilCasta) {
this.habilidadesCasta = habilCasta;
}

/** Devuelve las habilidades correspondientes a la Casta en cuestión.
 * @return array de String en en que se encuentran
 * las habilidades mencionadas*/
public String[] getHabilidadesCasta() {
return habilidadesCasta;
}

/** Devuelve la probabilidad de realizar un ataque crítico.
 * @return Double con el porcentaje de probabilidad*/
public double getProbabilidadGolpeCritico() {
return probabilidadGolpeCritico;
}

/** Define cual es la probabilidad de realizar un golpe crítico.
 * @param probabGolpeCritico Contiene el porcentaje de
 * probabilidad a asignar*/
public void setProbabilidadGolpeCritico(final double probabGolpeCritico) {
this.probabilidadGolpeCritico = probabGolpeCritico;
}

/**Devuelve la probabilidad de poder evitar ser dañado/afectado.
 * @return Double con el porcentaje de probabilidad*/
public double getProbabilidadEvitarDaño() {
return probabilidadEvitarDaño;
}

/** Define cual es la probabilidad de evitar ser dañado/afectado.
 * @param probabEvitarDaño Contine el porcentaje de probabilidad a asignar*/
public void setProbabilidadEvitarDaño(final double probabEvitarDaño) {
this.probabilidadEvitarDaño = probabEvitarDaño;
}

/** Devuelve el porcentaje de aumento en el ataque al hacer un daño crítico.
 * @return Porcentaje de aumento ofensivo*/
public double getDañoCritico() {
return dañoCritico;
}

/**Define el porcentaje de aumento en el ataque al hacer un daño crítico.
 * @param dañoCrit Contiene el porcentaje de aumento ofensivo*/
public void setDañoCritico(double dañoCrit) {
this.dañoCritico = dañoCrit;
}
}
