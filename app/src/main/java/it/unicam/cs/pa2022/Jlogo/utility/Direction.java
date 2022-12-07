package it.unicam.cs.pa2022.Jlogo.utility;

/**
 * e' un enum che rappresenta un insieme finito di direzioni :
 * FORWARD,BACKWARD;
 * positivo se vado avanti,negativo se vado indietro.
 */
public enum Direction {
    FORWARD(1), BACKWARD(-1);

    private final int sign;

    Direction(int sign) {
        this.sign = sign;
    }

    public int getSign() {
        return sign;
    }
}
