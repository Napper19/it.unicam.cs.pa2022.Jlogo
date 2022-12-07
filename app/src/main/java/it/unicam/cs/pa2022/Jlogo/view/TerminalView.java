package it.unicam.cs.pa2022.Jlogo.view;

import it.unicam.cs.pa2022.Jlogo.controllers.ControllerField;
import it.unicam.cs.pa2022.Jlogo.utility.ColorRGB;
import it.unicam.cs.pa2022.Jlogo.utility.Angle;
import it.unicam.cs.pa2022.Jlogo.utility.Direction;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TerminalView {

    static ControllerField controllerField = new ControllerField();

    public static void init() throws IOException {
        printMenu();
        System.out.println("Programma inizializzato, parametri giusti");
        System.out.println("Per uscire digitare 'exit', il file verra' salvato automaticamente nella cartella 'resources'");
        System.out.println("Digitare 'help' per visualizzare la lista dei comandi");
        readCommand();
    }

    private static void readCommand() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("> ");
        String command = scanner.nextLine();

        switch (command) {
            case "forward" -> {
                forward();
                readCommand();
            }
            case "backward" -> {
                backward();
                readCommand();
            }
            case "left" -> {
                left();
                readCommand();
            }
            case "right" -> {
                right();
                readCommand();
            }
            case "clearscreen" -> {
                clearscreen();
                readCommand();
            }
            case "penup" -> {
                penup();
                readCommand();
            }
            case "pendown" -> {
                pendown();
                readCommand();
            }
            case "setpencolor" -> {
                setpencolor();
                readCommand();
            }
            case "setfillcolor" -> {
                setfillcolor();
                readCommand();
            }
            case "setscreencolor" -> {
                setscreencolor();
                readCommand();
            }
            case "setpensize" -> {
                setpensize();
                readCommand();
            }
            case "repeat" -> {
                repeat();
                readCommand();
            }
            case "help" -> {
                help();
                readCommand();
            }
            case "exit" -> {
                exit();
                System.out.println("Arrivederci!");
                System.exit(0);
            }
            default -> {
                System.out.println("Comando non riconosciuto");
                readCommand();
            }
        }
    }

    private static void help() {
        System.out.println("Comandi disponibili:");
        System.out.println("forward\t\t\t Muove il cursore di una distanza in avanti");
        System.out.println("backward\t\t Muove il cursore di una distanza indietro");
        System.out.println("left\t\t\t Muove il cursore di un angolo valore in senso antiorario");
        System.out.println("right\t\t\t Muove il cursore di un angolo valore in senso orario");
        System.out.println("clearscreen\t\t Pulisce lo schermo, nuovo foglio delle stesse dimensioni");
        System.out.println("penup\t\t\t Rilascia il pennello");
        System.out.println("pendown\t\t\t Poni il pennello");
        System.out.println("setpencolor\t\t Imposta il colore del pennello");
        System.out.println("setfillcolor\t Imposta il colore di riempimento di un poligono");
        System.out.println("setscreencolor\t Imposta il colore del foglio");
        System.out.println("setpensize\t\t Imposta lo spessore delle line tratteggiate dal pennello");
        System.out.println("repeat\t\t\t Ripete un comando un numero di volte (NON DISPONIBILE)");
        System.out.println("help\t\t\t Visualizza questo messaggio");
        System.out.println("exit\t\t\t Esce dal programma e salvataggio automatico");
    }

    private static void repeat() {
        System.out.println("Comando non disponibile!");
    }

    private static void setpensize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Impostare il nuovo spessore della linea: ");
        int size = scanner.nextInt();
        if (size > 0) {
            controllerField.setPenSize(size);
            System.out.println("Spessore impostato! Riprovare");
        } else {
            System.out.println("Spessore non valido!");
            setpensize();
        }
    }

    private static void setscreencolor() {
        controllerField.setScreenColor(ColorRGB.values()[askForColorChoice() - 1]);
    }

    private static void setfillcolor() {
        controllerField.setFillColor(ColorRGB.values()[askForColorChoice() - 1]);
    }

    private static void setpencolor() {
        controllerField.setPenColor(ColorRGB.values()[askForColorChoice() - 1]);
    }

    private static int askForColorChoice() {
        Scanner in4 = new Scanner(System.in);
        AtomicInteger counter = new AtomicInteger(1);
        Arrays.stream(ColorRGB.values()).forEach(color -> System.out.println(counter.getAndIncrement() + ") " + ColorRGB.getColorName(color)));
        System.out.println("Scegli il colore del cursore: ");
        return in4.nextInt();
    }

    private static void clearscreen() throws IOException {
        controllerField.clearScreen();
        System.out.println("Schermo pulito");
    }

    private static void pendown() {
        controllerField.penDown();
    }

    private static void penup() {
        controllerField.penUp();
    }

    private static void right() {
        System.out.println("Indicare angolo di rotazione (in gradi): ");
        Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();
        if (angle < 0 || angle > 360) {
            System.out.println("Angolo non valido");
            right();
        } else {
            controllerField.rotate(angle, Angle.RIGHT);
            System.out.println("Rotazione effettuata");
        }
    }

    private static void left() {
        System.out.println("Indicare angolo di rotazione (in gradi): ");
        Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();
        if (angle < 0 || angle > 360) {
            System.out.println("Angolo non valido");
            left();
        } else {
            controllerField.rotate(angle, Angle.LEFT);
            System.out.println("Rotazione effettuata");
        }
    }

    private static void exit() throws IOException {
        controllerField.exit();
    }

    private static void backward() {
        System.out.println("Digita la distanza: ");
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextDouble();
        controllerField.movement(distance, Direction.BACKWARD);
    }

    private static void forward() {
        System.out.println("Digita la distanza: ");
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextDouble();
        controllerField.movement(distance, Direction.FORWARD);
    }

    private static void printMenu() throws IOException {
        Scanner in0 = new Scanner(System.in);
        System.out.println("LOGO PROGRAM --- Implementazione di Davide Nappo");
        System.out.println("1) Nuovo disegno");
        System.out.println("2) Carica disegno");
        System.out.println("3) Esci");
        System.out.println("Scegli un'opzione: ");
        int opzione = in0.nextInt();

        switch (opzione) {
            case 1 -> newDraw();
            case 2 -> loadDraw();
            case 3 -> System.exit(0);
            default -> {
                System.out.println("Opzione non valida! Riprovare!");
                printMenu();
            }
        }

    }

    private static void loadDraw() {
    System.out.println("Caricamento non disponibile,digita exit per uscire !");
    }

    private static void newDraw() throws IOException {
        Scanner in1 = new Scanner(System.in);
        System.out.println("Nuovo disegno");
        System.out.println("Inserire l'altezza del foglio: ");
        double height = in1.nextInt();
        System.out.println("Inserire la base del foglio: ");
        double base = in1.nextInt();
        int indexColor = askColorField();
        if (indexColor != 1) {
            controllerField.init(base, height, ColorRGB.values()[indexColor - 1], ColorRGB.values()[askCursorColor() - 1]);
        } else {
            controllerField.init(base, height, ColorRGB.values()[indexColor - 1], ColorRGB.BLACK);
        }
    }

    private static int askColorField() {
        Scanner in2 = new Scanner(System.in);
        System.out.println("Desidera usare il colore di sfondo bianco (y/n)?");
        String yesNo = in2.nextLine();

        AtomicInteger counter = new AtomicInteger(1);
        int indexOfColor;
        if (yesNo.equals("n")) {
            Arrays.stream(ColorRGB.values()).forEach(color -> System.out.println(counter.getAndIncrement() + ") " + ColorRGB.getColorName(color)));
            System.out.println("Scegli il colore di sfondo: ");
            indexOfColor = in2.nextInt();
        } else {
            indexOfColor = 1;
        }

        return indexOfColor;
    }

    private static int askCursorColor() {
        Scanner in3 = new Scanner(System.in);
        System.out.println("Il colore dello sfondo e' stato cambiato. Desidera ancora usare il colore del cursore nero (y/n)?");
        String yesNo = in3.nextLine();
        AtomicInteger counter = new AtomicInteger(1);
        int indexOfColor;
        if (yesNo.equals("n")) {
            Arrays.stream(ColorRGB.values()).forEach(color -> System.out.println(counter.getAndIncrement() + ") " + ColorRGB.getColorName(color)));
            System.out.println("Scegli il colore del cursore: ");
            indexOfColor = in3.nextInt();

        } else {
            indexOfColor = 2;
        }
        return indexOfColor;
    }
}

