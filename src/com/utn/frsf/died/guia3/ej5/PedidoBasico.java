package com.utn.frsf.died.guia3.ej5;

public class PedidoBasico extends Pedido {
    private boolean esExpress;

    public PedidoBasico() {
        this(false);
    }

    public PedidoBasico(boolean esExpress) {
        super();
        this.esExpress = esExpress;
    }

    public void setEsExpress(boolean esExpress) {
        this.esExpress = esExpress;
    }

    @Override
    int getCapacidad() {
        // El enunciado no dice nada sobre el limite de productos maximo de un pedido basico.
        return Integer.MAX_VALUE;
    }

    @Override
    double getPrecio() {
        double precioProducto = 0;
        for (Producto p : productos) {
            precioProducto += p.getPrecio();
        }
        return precioProducto + precioProducto * (esExpress ? 1.26 : 1.05);
    }

    @Override
    double getComision() {
        return entregado() ? getPrecio() * 0.1 : 0;
    }
}
