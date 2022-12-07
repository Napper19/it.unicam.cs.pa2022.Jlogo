package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    Segment line = new Line(new CartesianCordinate(0, 0), new CartesianCordinate(0, 90), ColorRGB.BLACK, 1);

    // Test per testare i vari modi di istanza attraverso i constructor
    @Test
    void testConstructor() {
        Segment line2 = new Line(new CartesianCordinate(0, 0), new CartesianCordinate(0, 90));
        assertEquals(line, line2);
    }

    @Test
    void getStart() {
        assertEquals(new CartesianCordinate(0, 0), line.getStart());
    }

    @Test
    void getEnd() {
        assertEquals(new CartesianCordinate(0, 90), line.getEnd());
    }

    @Test
    void getColor() {
        assertEquals(ColorRGB.BLACK, line.getColor());
    }

    @Test
    void getSize() {
        assertEquals(1, line.getSize());
    }

    @Test
    void getStartNull() {
        assertThrows(NullPointerException.class,
                () -> new Line(null, new CartesianCordinate(0, 90), ColorRGB.BLACK, 1)
        );
    }

    @Test
    void getEndNull() {
        assertThrows(NullPointerException.class,
                () -> new Line(new CartesianCordinate(0, 0), null, ColorRGB.BLACK, 1)
        );
    }

    @Test
    void getColorNull() {
        assertThrows(NullPointerException.class,
                () -> new Line(new CartesianCordinate(0, 0), new CartesianCordinate(0, 90), null, 1)
        );
    }

    @Test
    void getSizeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Line(new CartesianCordinate(0, 0), new CartesianCordinate(0, 90), ColorRGB.BLACK, -1)
        );
    }
}