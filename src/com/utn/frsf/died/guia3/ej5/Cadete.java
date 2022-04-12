package com.utn.frsf.died.guia3.ej5;

import java.util.ArrayList;
import java.util.List;

public class Cadete {
    private final List<Pedido> pedidos;

    public Cadete() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public double getComisiones() {
        double comision = 0;
        for (Pedido p : pedidos) {
            comision += p.getComision();
        }
        return comision;
    }
}
