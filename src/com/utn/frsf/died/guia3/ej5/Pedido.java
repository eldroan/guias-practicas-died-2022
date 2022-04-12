package com.utn.frsf.died.guia3.ej5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {
    protected final List<Producto> productos;
    LocalDate fechaEntrega;

    public Pedido() {
        productos = new ArrayList<>();
        fechaEntrega = null;
    }

    abstract int getCapacidad();

    abstract double getPrecio();

    abstract double getComision();

    public boolean agregarProducto(Producto p) {
        if (productos.size() >= getCapacidad()) return false;
        productos.add(p);
        return true;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public boolean entregado() {
        return fechaEntrega != null;
    }

}
