package it.unicam.cs.pa2022.Jlogo.controllers;

import it.unicam.cs.pa2022.Jlogo.model.*;
import it.unicam.cs.pa2022.Jlogo.utility.Angle;
import it.unicam.cs.pa2022.Jlogo.utility.Direction;

public class ControllerCursor {

    // metodo per spostare il curosre in una determinata direzione
    public CartesianCordinate moveCursor(Cursor cursor, double distance, Direction direction) {
        double newX = cursor.getPosition().x() + distance * direction.getSign() * Math.cos(Math.toRadians(cursor.getAngleValue()));
        double newY = cursor.getPosition().y() + distance * direction.getSign() * Math.sin(Math.toRadians(cursor.getAngleValue()));
        return new CartesianCordinate(newX, newY);
    }

    public void rotateCursor(Cursor cursor, int angle, Angle angleType) {
        if(angleType == Angle.RIGHT){
            if(cursor.getAngleValue() - angle < 0){
                cursor.setAngleValue(360 + cursor.getAngleValue() - angle);
            } else {
                cursor.setAngleValue(cursor.getAngleValue() - angle);
            }
        }else{
            if(cursor.getAngleValue() + angle > 360){
                cursor.setAngleValue(cursor.getAngleValue() + angle - 360);
            } else {
                cursor.setAngleValue(cursor.getAngleValue() + angle);
            }
        }
    }
}
