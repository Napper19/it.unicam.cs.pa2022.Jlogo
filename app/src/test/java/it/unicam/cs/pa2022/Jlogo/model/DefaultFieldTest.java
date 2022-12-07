package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultFieldTest {

    Field field = new DefaultField(500, 500, ColorRGB.WHITE);

    Field field2 = new DefaultField(500, 500);

    @Test
    void checkConstructors() {

        assertThrows(NullPointerException.class,
                () -> new DefaultField(500, 500, null)
        );
        assertThrows(IllegalArgumentException.class,
                () -> new DefaultField(99, 180, ColorRGB.BLACK)
        );
        assertThrows(IllegalArgumentException.class,
                () -> new DefaultField(180, 90, ColorRGB.BLACK)
        );

        assertEquals(500, field.getBase());
        assertEquals(500, field.getHeight());
        assertEquals(ColorRGB.WHITE, field.getBackground());

        assertEquals(500, field2.getBase());
        assertEquals(500, field2.getHeight());
        assertEquals(ColorRGB.WHITE, field2.getBackground());
    }

    @Test
    void getHeight() {
        assertEquals(500, field.getHeight());
    }

    @Test
    void getBase() {
        assertEquals(500, field.getBase());
    }

    @Test
    void getBackground() {
        assertEquals(ColorRGB.WHITE, field.getBackground());
    }

    @Test
    void setBackground() {
        field.setBackground(ColorRGB.BLACK);
        assertEquals(ColorRGB.BLACK, field.getBackground());
    }

    @Test
    void getCursor() {
        Cursor cursor = new DefaultCursor(new CartesianCordinate(250, 250));
        assertEquals(cursor, field.getCursor());
    }
}