package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;

import static it.unicam.cs.pa2022.Jlogo.utility.Utilities.*;

/**
 * Classe che rappresenta una Linea, ovvero un segmento di retta.
 */
public class Line implements Segment {

    private final CartesianCordinate start;
    private final CartesianCordinate end;
    private final ColorRGB color;
    private final int size;

    public Line(CartesianCordinate start, CartesianCordinate end, ColorRGB color, int size) {

        ThrowIfNull(start, "Start cannot be null");
        ThrowIfNull(end, "End cannot be null");
        ThrowIfNull(color, "Color cannot be null");

        if (size < 1) {
            throw new IllegalArgumentException("Size must be positive");
        }

        this.start = start;
        this.end = end;
        this.color = color;
        this.size = size;
    }

    public Line(CartesianCordinate start, CartesianCordinate end) {
        this(start, end, ColorRGB.BLACK, 1);
    }

    @Override
    public CartesianCordinate getStart() {
        return this.start;
    }

    @Override
    public CartesianCordinate getEnd() {
        return this.end;
    }

    @Override
    public ColorRGB getColor() {
        return this.color;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Double.compare(line.size, size) == 0 &&
                color == line.color &&
                start.equals(line.start) &&
                end.equals(line.end);
    }
    @Override
    public String toString() {
        return "LINE " + start + " " + end + " " + color + " <" + size + ">\n";
    }
}
