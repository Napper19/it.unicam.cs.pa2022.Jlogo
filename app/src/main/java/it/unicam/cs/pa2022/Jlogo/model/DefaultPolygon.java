package it.unicam.cs.pa2022.Jlogo.model;


import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;

import java.util.LinkedList;
import java.util.Objects;

import static it.unicam.cs.pa2022.Jlogo.utility.Utilities.ThrowIfNull;

/**
 * Implementazione dell'interfaccia Polygon con una lista di segmenti.
 * Un poligono si crea quando la coordinata start del primo segmento
 * e' uguale alla coordinata end dell'ultimo segmento.
 */
public record DefaultPolygon<S extends Segment>(LinkedList<S> segments, ColorRGB fillColor) implements Polygon<S> {

    public DefaultPolygon {
        ThrowIfNull(segments, "Segments cannot be null");
        ThrowIfNull(fillColor, "Fill color cannot be null");

        if (segments.isEmpty() || segments.size() < 3) {
            throw new IllegalArgumentException("Too few segments");
        }
        if (!segments.getFirst().getStart().equals(segments.getLast().getEnd())) {
            throw new IllegalArgumentException("Polygon is not closed");
        }
        // Metodo che controlla se i segmenti sono connessi tra di loro
        for (int i = 0; i < segments.size() - 1; i++) {
            if (!segments.get(i).getEnd().equals(segments.get(i + 1).getStart())) {
                throw new IllegalArgumentException("Polygon is not connected");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultPolygon<?> that = (DefaultPolygon<?>) o;
        return Objects.equals(segments, that.segments) &&
                Objects.equals(fillColor, that.fillColor);
    }

    @Override
    public String toString() {
        return "<POLYGON> <" + segments().size() + "> " + fillColor + "" +
                (segments.isEmpty() ?
                        ""
                        : "\n" + segments.stream()
                        .map((Segment::toString))
                        .reduce((s1, s2) -> s1 + "\t" + s2)
                        .get()) + "</POLYGON>";
    }


}
