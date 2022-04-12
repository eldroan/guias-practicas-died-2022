package com.utn.frsf.died.guia3.ej1;

import java.util.Objects;

public class Punto {
    private final float x;
    private final float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Float.compare(punto.x, x) == 0 && Float.compare(punto.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

