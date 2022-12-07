package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;

import static it.unicam.cs.pa2022.Jlogo.utility.Utilities.ThrowIfNull;

/**
 * Implementazione di default di un campo.
 */
public class DefaultField implements Field {

    private final double height;
    private final double base;
    private ColorRGB background;
    private final Cursor cursor;


    public DefaultField(double height, double base, ColorRGB background, ColorRGB cursorColor) {
        ThrowIfNull(background, "Background cannot be null");
        if (height < 100 || base < 100) {
            throw new IllegalArgumentException("Size must be greater than 100");
        }
        this.height = height;
        this.base = base;
        this.background = background;
        this.cursor = new DefaultCursor(getCenter(), cursorColor);
    }

    public DefaultField(double height, double base, ColorRGB background) {
        this(height, base, background, ColorRGB.BLACK);
    }

    public DefaultField(double base, double height) {
        this(base, height, ColorRGB.WHITE);
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getBase() {
        return this.base;
    }

    @Override
    public ColorRGB getBackground() {
        return this.background;
    }

    @Override
    public void setBackground(ColorRGB color) {
        this.background = color;
    }

    @Override
    public Cursor getCursor() {
        return this.cursor;
    }

    @Override
    public void updateCursorPosition(CartesianCordinate newPosition) {
        this.cursor.setPosition(newPosition);
    }

    @Override
    public String getPropertiesForFile() {
        return "SIZE <" + getBase() + "> <" + getHeight() + "> " + getBackground().toString() + "\n";
    }


}
