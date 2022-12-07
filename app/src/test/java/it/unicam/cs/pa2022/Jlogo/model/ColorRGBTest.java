package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorRGBTest {

    @Test
    void getRed() {
        assertEquals(255, ColorRGB.WHITE.getRed());
        assertEquals(0, ColorRGB.BLACK.getRed());
        assertEquals(0, ColorRGB.GREEN.getRed());
        assertEquals(255, ColorRGB.RED.getRed());
        assertEquals(255, ColorRGB.YELLOW.getRed());
        assertEquals(0, ColorRGB.BLUE.getRed());
        assertEquals(255, ColorRGB.ORANGE.getRed());
    }

    @Test
    void getBlue() {
        assertEquals(255, ColorRGB.WHITE.getBlue());
        assertEquals(0, ColorRGB.BLACK.getBlue());
        assertEquals(0, ColorRGB.GREEN.getBlue());
        assertEquals(0, ColorRGB.RED.getBlue());
        assertEquals(0, ColorRGB.YELLOW.getBlue());
        assertEquals(255, ColorRGB.BLUE.getBlue());
        assertEquals(0, ColorRGB.ORANGE.getBlue());
    }

    @Test
    void getGreen() {
        assertEquals(255, ColorRGB.WHITE.getGreen());
        assertEquals(0, ColorRGB.BLACK.getGreen());
        assertEquals(255, ColorRGB.GREEN.getGreen());
        assertEquals(0, ColorRGB.RED.getGreen());
        assertEquals(255, ColorRGB.YELLOW.getGreen());
        assertEquals(0, ColorRGB.BLUE.getGreen());
        assertEquals(165, ColorRGB.ORANGE.getGreen());
    }
}