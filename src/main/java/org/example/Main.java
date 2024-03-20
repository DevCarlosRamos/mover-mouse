package org.example;

import java.awt.AWTException;
import java.awt.Robot;

public class Main {
    private static final int DELAY = 200; // Milisegundos entre movimientos del mouse

    public static void main(String[] args) {
        try {
            final Robot robot = new Robot();

            // Movimiento continuo del ratón
            double angle = 0;
            while (true) {
                // Movimiento en un círculo pequeño
                int xOffset = (int) (Math.cos(angle) * 1.5);
                int yOffset = (int) (Math.sin(angle) * 1.5);

                // Obtener la posición actual del ratón
                int currentX = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getX();
                int currentY = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getY();

                // Mover el ratón
                robot.mouseMove(currentX + xOffset, currentY + yOffset);
                robot.delay(DELAY); // Esperar antes de mover el ratón nuevamente
                angle += 0.05; // Incrementar el ángulo para moverse en el círculo
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}