package it.unicam.cs.pa2022.Jlogo.controllers;

import it.unicam.cs.pa2022.Jlogo.model.*;
import it.unicam.cs.pa2022.Jlogo.utility.Angle;
import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;
import it.unicam.cs.pa2022.Jlogo.utility.Direction;
import it.unicam.cs.pa2022.Jlogo.utility.FileManager;

import java.io.IOException;
import java.util.LinkedList;

public class ControllerField {

    private DefaultField field;
    private FileManager fileManager;
    private ControllerCursor cursorManager;
    LinkedList<Segment> segmentSequence = new LinkedList<>();

    private ColorRGB polygonFillColor = ColorRGB.BLACK;

    /**
     * Inizializza il Field,il Controller del cursore e il fileManager.
     * @param base
     * @param height
     * @param background
     * @param cursorColor
     * @throws IOException
     */
    public void init(Double base, Double height, ColorRGB background, ColorRGB cursorColor) throws IOException {
        field = new DefaultField(base, height, background, cursorColor);
        cursorManager = new ControllerCursor();
        fileManager = new FileManager(field, "output.txt");
    }

    public void movement(double distance, Direction direction) {
        if (!checkIfOutOfField(distance, direction)) {
            if (field.getCursor().isPlot()) {
                Line segment = new Line(
                        field.getCursor().getPosition(),
                        cursorManager.moveCursor(field.getCursor(), distance, direction),
                        field.getCursor().getColorLine(),
                        field.getCursor().getThickness()
                );
                segmentSequence.add(segment);
                field.updateCursorPosition(segment.getEnd());
                System.out.println("Cursore spostato!");
            } else {
                field.updateCursorPosition(cursorManager.moveCursor(field.getCursor(), distance, direction));
                System.out.println("Cursore spostato!");
            }
        } else {
            System.out.println("Il cursore e' fuori dal campo, segmento non tracciato!");
        }
        checkPolygonPresence();
    }

    /**
     * Metodo che controlla se il cursore esce dal campo.
     * @param distance
     * @param direction
     * @return
     */
    private boolean checkIfOutOfField(double distance, Direction direction) {
        return (
                // Controllo asse X
                field.getCursor().getPosition().x() + distance * direction.getSign() > field.getBase() || field.getCursor().getPosition().x() + distance * direction.getSign() < 0) || (
                // Controllo asse Y
                field.getCursor().getPosition().y() + distance * direction.getSign() > field.getHeight() || field.getCursor().getPosition().y() + distance * direction.getSign() < 0);
    }

    public void exit() throws IOException {
        if (!segmentSequence.isEmpty()) {
            fileManager.writeSegments(segmentSequence);
        }
        fileManager.closeFile();
    }


    public void rotate(int angle, Angle angleType) {
        cursorManager.rotateCursor(field.getCursor(), angle, angleType);
    }

    public void penUp() {
        field.getCursor().setPlot(false);
        fileManager.writeSegments(segmentSequence);
    }

    public void penDown() {
        field.getCursor().setPlot(true);
        segmentSequence = new LinkedList<>();
    }

    /**
     * Metodo che controlla la presenza di un poligono.
     * Un poligono e' formato da almeno 3 segmenti.
     */
    private void checkPolygonPresence() {
        if (segmentSequence.size() > 2) {
            if (segmentSequence.getFirst().getStart().equals(segmentSequence.getLast().getEnd())) {
                System.out.println("Individuato Poligono!");
                DefaultPolygon<Segment> polygon = new DefaultPolygon<>(segmentSequence, polygonFillColor);
                fileManager.writePolygon(polygon);
                segmentSequence = new LinkedList<>();
            }
        }
    }

    public void clearScreen() throws IOException {
        field = new DefaultField(field.getBase(), field.getHeight(), field.getBackground(), field.getCursor().getColorLine());
        fileManager = new FileManager(field, "output.txt");
    }

    public void setPenColor(ColorRGB value) {
        field.getCursor().setColorLine(value);
    }

    public void setFillColor(ColorRGB value) {
        this.polygonFillColor = value;
    }

    public void setScreenColor(ColorRGB value) {
        field.setBackground(value);
    }

    public void setPenSize(int size) {
        field.getCursor().setThickness(size);
    }
}
