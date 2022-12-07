package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;

/**
 * Interfaccia che rappresenta un cursore. Il cursore si trova all'interno di un Field e ha una posizione,
 * l' angolo verso cui e' puntato,un colore  della linea che produce spostandosi,
 * un plot(un parametro che indica se il cursore sta toccando il foglio oppure no) e lo spessore del tratto.
 */
public interface Cursor {

    /**
     * Restituisce la coordinata del cursore.
     *
     * @return la coordinata del cursore.
     */
    CartesianCordinate getPosition();

    /**
     * Aggiorna la posizione del cursore.
     */
    void setPosition(CartesianCordinate position);

    /**
     * Restituisce l'angolo verso cui e' puntato il cursore.
     *
     * @return l'angolo verso cui e' puntato il cursore.
     */
    int getAngleValue();

    /**
     * Aggiorna l'angolo verso cui e' puntato il cursore. L'angolo e' un valore che puo' essere compreso
     * tra 0 e 360.
     */
    void setAngleValue(int direction);

    /**
     * Restituisce il colore della linea
     *
     * @return il colore della linea
     */
    ColorRGB getColorLine();

    /**
     * Imposta il colore della linea
     *
     * @param color il colore della linea
     */
    void setColorLine(ColorRGB color);

    /**
     * Restituisce true se il cursore tocca il foglio,false altrimenti.
     *
     * @return true se il cursore tocca il foglio,false altrimenti.
     */
    boolean isPlot();

    /**
     * Imposta se il cursore sta tracciando un segmento oppure no attraverso il parametro passato.
     *
     * @param plot true se il cursore sta tracciando un segmento, false altrimenti.
     */
    void setPlot(boolean plot);

    /**
     * Restituisce lo spessore del tratto del cursore.
     *
     * @return lo spessore del tratto del cursore.
     */
    int getThickness();

    /**
     * Imposta lo spessore del tratto del cursore con la grandezza passata come parametro.
     *
     * @param size lo spessore del tratto del cursore.
     */
    void setThickness(int size);

}
