package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;

import java.util.LinkedList;

/**
 * Interfaccia che appresenta un poligono( una figura geometrica piana delimitata da una linea spezzata chiusa).
 * Un poligono e' formato da una lista di Segment.
 * @param <S> tipo di segmento che compone il poligono.
 */
public interface Polygon<S extends Segment> {
    /**
     * Ritorna la lista di segmenti.
     *
     * @return la lista di segmenti.
     */
    LinkedList<S> segments();

    /**
     * Ritorna il colore di riempiemento del poligono.
     *
     * @return il colore di riempiemento del poligono.
     */

    ColorRGB fillColor();
}
