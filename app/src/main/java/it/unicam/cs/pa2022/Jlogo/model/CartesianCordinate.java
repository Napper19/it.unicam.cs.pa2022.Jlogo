package it.unicam.cs.pa2022.Jlogo.model;

/**
 * Record che rappresenta una generica coordinata in un piano a due dimensioni.
 *
 * @param x il valore della coordinata x.
 * @param y il valore della coordinata y.
 */
public record CartesianCordinate(double x, double y) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianCordinate that = (CartesianCordinate) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0;
    }

    @Override
    public String toString() {
        return "<" + x + "> <" + y + ">";
    }
}