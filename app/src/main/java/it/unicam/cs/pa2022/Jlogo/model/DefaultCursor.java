package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;

/**
 * Implementazione di default dell'interfaccia Cursor.
 */
public class DefaultCursor implements Cursor {

    private CartesianCordinate position;
    private int angle;

    private ColorRGB color;
    private boolean plot;
    private int thickness;

    public DefaultCursor(double x, double y, ColorRGB color, int thickness) {
        this.position = new CartesianCordinate(x, y);
        this.angle = 0;
        this.color = color;
        this.plot = true;
        this.thickness = thickness;
    }

    public DefaultCursor(CartesianCordinate position, ColorRGB color) {
        this(position.x(), position.y(), color, 1);
    }
    public DefaultCursor(CartesianCordinate position) {
        this(position.x(), position.y(), ColorRGB.BLACK, 1);
    }

    public DefaultCursor(double x, double y) {
        this(x, y, ColorRGB.BLACK, 1);
    }


    @Override
    public CartesianCordinate getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(CartesianCordinate position) {
        this.position = position;
    }

    @Override
    public int getAngleValue() {
        return this.angle;
    }

    @Override
    public void setAngleValue(int direction) {
        if (direction < 0 || direction > 360) {
            throw new IllegalArgumentException("Angle must be between 0 and 360");
        }
        this.angle = direction;
    }

    @Override
    public ColorRGB getColorLine() {
        return this.color;
    }

    @Override
    public void setColorLine(ColorRGB color) {
        this.color = color;
    }

    @Override
    public boolean isPlot() {
        return this.plot;
    }

    @Override
    public void setPlot(boolean plot) {
        this.plot = plot;
    }

    @Override
    public int getThickness() {
        return this.thickness;
    }

    @Override
    public void setThickness(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Thickness must be at least 1");
        }
        this.thickness = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultCursor that = (DefaultCursor) o;
        return angle == that.angle &&
                position.equals(that.position);
    }
}
