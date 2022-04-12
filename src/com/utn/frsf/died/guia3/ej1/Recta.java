package com.utn.frsf.died.guia3.ej1;

public class Recta {
    private final float pendiente;
    private final float origen;

    public Recta() {
        this(1f, 0f);
    }

    public Recta(float p, float o) {
        this.pendiente = p;
        this.origen = o;
    }

    public float getPendiente() {
        return pendiente;
    }

    public Recta(Punto p1, Punto p2) {
        // La pendiente de la recta m = (y1 – y0) / (x1 – x0)
        final float divisor = p1.getX() - p2.getX();
        this.pendiente = divisor != 0 ? (p1.getY() - p2.getY()) / divisor : 0;
        this.origen = p2.getY() - pendiente * p2.getX();
    }

    public boolean paralelas(Recta r) {
        return r.pendiente == pendiente;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        final Recta otra = (Recta) obj;
        return otra.pendiente == pendiente && otra.origen == origen;
    }
}
