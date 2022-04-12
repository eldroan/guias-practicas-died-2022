package com.utn.frsf.died.guia3.ej2;

import static com.utn.frsf.died.guia3.ej2.Escala.CELCIUS;
import static com.utn.frsf.died.guia3.ej2.Escala.FARENHEIT;

public class Temperatura {
    private double grados;
    Escala escala;

    public Temperatura(double grados, Escala escala) {
        this.grados = grados;
        this.escala = escala;
    }

    public Temperatura() {
        this.grados = 0;
        this.escala = CELCIUS;
    }

    public double getGrados() {
        return grados;
    }

    @Override
    public String toString() {
        return grados + " " + (escala == CELCIUS ? "C°" : "F°");
    }

    public Double asCelcius() {
        return toScale(CELCIUS).grados;
    }

    public Double asFarenheit() {
        return toScale(FARENHEIT).grados;
    }

    private Temperatura toScale(Escala otraEscala) {
        return switch (escala) {
            case FARENHEIT -> switch (otraEscala) {
                case FARENHEIT -> this;
                case CELCIUS -> new Temperatura((grados - 32) * 5 / 9f, CELCIUS);
            };
            case CELCIUS -> switch (otraEscala) {
                case CELCIUS -> this;
                case FARENHEIT -> new Temperatura((grados * 9 / 5f) + 32, FARENHEIT);
            };
        };
    }

    public void aumentar(Temperatura t) {
        Temperatura otherTemp = t.toScale(escala);
        grados += otherTemp.grados;
    }

    public void disminuir(Temperatura t) {
        Temperatura otherTemp = t.toScale(escala);
        if (grados - otherTemp.grados >= 0) {
            grados -= otherTemp.grados;
        }
    }
}
