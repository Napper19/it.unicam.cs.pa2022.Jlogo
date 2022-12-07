package it.unicam.cs.pa2022.Jlogo.utility;

/**
 *Enum che rappresenta un angolo di rotazione,puo' essere positivo o negativo.
 */
public enum Angle {
    RIGHT(1), LEFT(-1);

    private final int sign;

    Angle(int sign) {
        this.sign = sign;
    }

    public int getSign() {
        return sign;
    }
}
