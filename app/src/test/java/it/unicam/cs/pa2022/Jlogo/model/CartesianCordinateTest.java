package it.unicam.cs.pa2022.Jlogo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartesianCordinateTest {

    CartesianCordinate cartesianCordinate = new CartesianCordinate(0, 0);

    @Test
    void x() {
        assertEquals(0, cartesianCordinate.x());
    }

    @Test
    void y() {
        assertEquals(0, cartesianCordinate.y());
    }

    @Test
    void equals() {
        CartesianCordinate cartesianCordinate2 = new CartesianCordinate(0, 0);
        assertEquals(cartesianCordinate, cartesianCordinate2);
        CartesianCordinate cartesianCordinate3 = new CartesianCordinate(0, 1);
        assertNotEquals(cartesianCordinate, cartesianCordinate3);
        CartesianCordinate cartesianCordinate4 = new CartesianCordinate(1, 0);
        assertNotEquals(cartesianCordinate, cartesianCordinate4);
    }
}