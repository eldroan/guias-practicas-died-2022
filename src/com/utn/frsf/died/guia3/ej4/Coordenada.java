package com.utn.frsf.died.guia3.ej4;

import java.util.Objects;

public class Coordenada {
    private static final double R_EARTH_KM = 6378.137;
    private static final double CHICHUMEQUE = (1 / ((2 * Math.PI / 360) * R_EARTH_KM)) ;  //1 KM in degree


    private double latitud, longitud;

    public Coordenada(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Coordenada() {
        this(0, 0);
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada that = (Coordenada) o;
        return Double.compare(that.latitud, latitud) == 0 && Double.compare(that.longitud, longitud) == 0;
    }

    public void sumar(int metrosLatitud, int metrosLongitud) {
        final double latitudOriginal = latitud;
        latitud = latitudOriginal + (metrosLatitud * CHICHUMEQUE);
        longitud = longitud + (metrosLongitud * CHICHUMEQUE) / Math.cos(latitudOriginal * (Math.PI / 180));
    }

    @Override
    public String toString() {
        return "Coordenada{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
