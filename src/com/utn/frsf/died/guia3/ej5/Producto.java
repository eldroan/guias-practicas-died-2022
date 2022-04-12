package com.utn.frsf.died.guia3.ej5;

import java.util.Objects;

public class Producto {
    private final String descripcion;
    private final double precio;

    public Producto(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Double.compare(producto.precio, precio) == 0 && Objects.equals(descripcion, producto.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, precio);
    }
}
