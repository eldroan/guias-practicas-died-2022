package com.utn.frsf.died.guia3.ej1;

/***
 * 1. Crear el punto P1(1,1)
 * 2. Crear el punto P2(2,2).
 * 3. Crear la recta R1 con los puntos P1 y P2.
 * 4. Mostrar por pantalla la pendiente de la recta R1.
 * 5. Crear el punto P3(3,3).
 * 6. Crear la recta R2 con los puntos P2 y P3.
 * 7. Mostrar por pantalla (true o false) si R1 y R2 representan la misma recta.
 */
public class Main {
    public static void main(String[] args) {
        final Punto puntoP1 = new Punto(1, 1);
        final Punto puntoP2 = new Punto(2, 2);
        final Recta rectaR1 = new Recta(puntoP1, puntoP2);

        System.out.println("La pendiente de la recta es " + rectaR1.getPendiente());

        final Punto puntoP3 = new Punto(3, 3);
        final Recta rectaR2 = new Recta(puntoP2, puntoP3);

        System.out.println("Las rectas R1 y R2 representan la misma recta? " + rectaR1.equals(rectaR2));

    }
}
