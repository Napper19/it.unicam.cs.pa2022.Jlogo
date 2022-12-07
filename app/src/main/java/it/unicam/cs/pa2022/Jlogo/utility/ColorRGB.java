package it.unicam.cs.pa2022.Jlogo.utility;

/**
 * e' un enum che rappresenta un insieme finito di colori :
 * WHITE,BLACK,GREEN,RED ,YELLOW, BLUE, ORANGE;
 */
public enum ColorRGB {
    WHITE(255, 255, 255), BLACK(0, 0, 0),
    GREEN(0, 255, 0), RED(255, 0, 0),
    YELLOW(255, 255, 0), BLUE(0, 0, 255), ORANGE(255, 165, 0);

    private final int red;
    private final int blue;
    private final int green;

    ColorRGB(int red, int green, int blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    @Override
    public String toString() {
        return "<" + this.getRed() + "> <" + this.getBlue() + "> <" + this.getGreen() + ">";
    }

    public static String getColorName(ColorRGB color) {
        return color.name();
    }
}
