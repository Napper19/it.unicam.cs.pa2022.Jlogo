package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;

/**
 * Rappresenta il foglio di carta dove avverra' il disegno.
 * Il foglio ha una base,altezza,un colore di sfondo e un centro.
 * Il foglio contiene anche un cursore e si occupa di aggiornare la posizione del cursore al suo interno.
 * Le proprieta' del foglio verranno restituite attraverso un metodo in modo da poter essere scritte su un file.
 */
public interface Field {

    /**
     * Restituisce l'altezza del foglio.
     *
     * @return l'altezza del foglio.
     */
    double getHeight();

    /**
     * Restituisce la base del foglio.
     *
     * @return la base del foglio.
     */
    double getBase();

    /**
     * Restituisce il colore di sfondo del foglio.
     *
     * @return il colore di sfondo del foglio.
     */

    ColorRGB getBackground();

    /**
     * Imposta il colore di sfondo del foglio.
     *
     * @param color il colore di sfondo del foglio.
     */
    void setBackground(ColorRGB color);

    /**
     * Restituisce il cursore.
     *
     * @return il cursore.
     */
    Cursor getCursor();

    /**
     * Aggiorna la posizione del cursore.
     *
     * @param newPosition nuova posizione del cursore.
     *                    .
     */
    void updateCursorPosition(CartesianCordinate newPosition);

    /**
     * Ritorna le proprieta' del foglio in modo da poter essere scritto in un file.
     *
     * @return le proprieta' del foglio.
     */
    String getPropertiesForFile();

    /**
     * Ritorna il centro del foglio.
     *
     * @return il centro del foglio.
     */
    default CartesianCordinate getCenter() {
        return new CartesianCordinate(getBase() / 2, getHeight() / 2);
    }

}
