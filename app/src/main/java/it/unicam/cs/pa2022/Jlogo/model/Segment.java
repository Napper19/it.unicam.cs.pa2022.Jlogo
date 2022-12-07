package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;

/**
 * Interfaccia che rappresenta un segmento generico. Un segmento una volta tracciato, a rigore di logica,
 * non puo' essere modificato.Ha un punto di inizio e un punto di fine, un colore,e una dimensione(size)
 *
 */
public interface Segment {

    /**
     * Ritorna il punto iniziale del segmento.
     * @return il punto iniziale del segmento.
     */
    CartesianCordinate getStart();

    /**
     * Ritorna il punto finale del segmento.
     * @return il punto finale del segmento.
     */
    CartesianCordinate getEnd();

    /**
     * Ritorna il colore del segmento.
     * @return il colore del segmento.
     */
    ColorRGB getColor();

    /**
     * Ritorna la dimensione del segmento.
     * @return la dimensione del segmento.
     */
    int getSize();

}
