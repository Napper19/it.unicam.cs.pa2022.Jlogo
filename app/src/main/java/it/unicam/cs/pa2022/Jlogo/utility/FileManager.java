package it.unicam.cs.pa2022.Jlogo.utility;

import it.unicam.cs.pa2022.Jlogo.model.DefaultPolygon;
import it.unicam.cs.pa2022.Jlogo.model.Field;
import it.unicam.cs.pa2022.Jlogo.model.Segment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * classe che si occupa della gestione dei file.
 * Sono presenti solo operazioni che mi permettono di salvare su file,non di caricare.
 */
public class FileManager {
    private final FileWriter fileW;
    private final BufferedWriter buffW;



    public FileManager(Field field, String fileName) throws IOException {
        String currentDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\";
        fileW = new FileWriter(currentDirectory + fileName);
        buffW = new BufferedWriter(fileW);
        writeProperties(field);
    }

    private void writeProperties(Field field) throws IOException {
        try {
            buffW.write(field.getPropertiesForFile());
            buffW.append("<SHAPE>\n");
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void writeSegments(LinkedList<Segment> segmentSequence) {
        try {
            for (Segment segment : segmentSequence) {
                buffW.append(segment.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeFile() throws IOException {
        buffW.append("\n</SHAPE>");
        buffW.close();
        fileW.close();
    }


    public void writePolygon(DefaultPolygon<Segment> polygon) {
        try {
            buffW.append(polygon.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
