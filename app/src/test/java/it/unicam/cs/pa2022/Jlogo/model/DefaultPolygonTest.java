package it.unicam.cs.pa2022.Jlogo.model;

import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DefaultPolygonTest {

    @Test
    void testExeptions() {
        assertThrows(NullPointerException.class, () -> new DefaultPolygon<Line>(null, ColorRGB.WHITE));
        assertThrows(NullPointerException.class, () -> new DefaultPolygon<Line>(new LinkedList<>(), null));

        Line line1 = new Line(new CartesianCordinate(0, 0), new CartesianCordinate(10, 0));
        Line line2 = new Line(new CartesianCordinate(10, 0), new CartesianCordinate(10, 10));
        Line line3 = new Line(new CartesianCordinate(10, 10), new CartesianCordinate(0, 10));
        Line line4 = new Line(new CartesianCordinate(0, 10), new CartesianCordinate(0, 0));
        LinkedList<Line> list1 = new LinkedList<>();
        list1.add(line1);
        list1.add(line4);
        list1.add(line3);
        list1.add(line2);

        LinkedList<Line> list2 = new LinkedList<>();
        list2.add(line1);
        list2.add(line2);
        // test per vedere se sono troppo poche le linee
        assertThrows(IllegalArgumentException.class, () -> new DefaultPolygon<>(list2, ColorRGB.WHITE));

        // test for exception when the list is not closed
        assertThrows(IllegalArgumentException.class, () -> new DefaultPolygon<>(list1, ColorRGB.WHITE));

        LinkedList<Line> list3 = new LinkedList<>();
        list3.add(line1);
        list3.add(line2);
        list3.add(line3);
        list3.add(line4);
        Polygon<Line> polygon = new DefaultPolygon<>(list3, ColorRGB.WHITE);
        System.out.println(polygon);
    }
}