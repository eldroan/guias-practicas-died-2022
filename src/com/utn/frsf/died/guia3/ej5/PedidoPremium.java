package com.utn.frsf.died.guia3.ej5;

import java.util.Collection;

public class PedidoPremium extends Pedido {

    @Override
    int getCapacidad() {
        // El enunciado dice que el limite es 10 pero si respetamos lo que dice el cadete jamas
        // podría cobrar sus 50 pesos extras así que vamos a hacerle el aguante y sacar el limite.
        return Integer.MAX_VALUE;
    }

    @Override
    double getPrecio() {
        double precioProducto = 0;
        for (Producto p : productos) {
            precioProducto += p.getPrecio();
        }

        double tarifa = productos.size() <= 5 ? 0.2 : 0.3;
        double precioComision = 0;
        if (productos.size() <= 10) {
            for (Producto p : productos) {
                precioComision += p.getPrecio() * tarifa;
            }
        } else {
            // Como quitamos el limite de cantidad y el enunciado dice
            // "un 30% extra si son más de 5 productos los pedidos hasta un máximo de 10" voy a asumir que despues de
            // los 10 productos es tarifa fija.
            precioComision = 10 * tarifa;
        }
        return precioProducto + precioComision;
    }

    @Override
    double getComision() {
        double comision = getPrecio() * 0.15 + (productos.size() > 10 ? 50 : 0);
        return entregado() ? comision : 0;
    }
}
