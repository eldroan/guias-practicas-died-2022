package com.utn.frsf.died.guia3.ej5;

import java.time.LocalDate;

/***
 * Ejercicio 05 – Herencia y Sobreescritura
 * Una app de delivery de productos permite que el usuario solicite productos para el envío. Esta aplicación tiene posee
 * dos opciones de envío, básico y premium.
 * Cuando un usuario selecciona un envío básico puede agregar hasta 5 productos en el envío y se le cobra además del
 * precio de cada producto, un 5% extra del precio de cada producto. Es decir si pido un producto por $100, el costo
 * del Pedido es $105 ($100 del producto y $5 del envío) y el envío se realiza entre las 24 y las 48 horas hábiles.
 * El usuario tiene la opción de indicar que el envío básico es Express, y necesita recibirlo en 24 horas.
 * Si lo marca como Express entonces se le cobra un 20% sobre el total del envío.
 * (en el caso anterior a los $105 se le suma un 20%, es decir $21 y el costo del envío será $126).
 */
public class Main {
    public static void main(String[] args) {
        final PedidoPremium pedidoPremium = new PedidoPremium();
        for (int i = 0; i < 6; i++) {
            pedidoPremium.agregarProducto(new Producto("", 100));
        }
        System.out.println("El precio del pedido premium es " + pedidoPremium.getPrecio());
        pedidoPremium.setFechaEntrega(LocalDate.now());
        System.out.println("La comision del pedido premium es " + pedidoPremium.getComision());
        pedidoPremium.setFechaEntrega(null); // Lo vuelvo a marcar como no enviado

        final PedidoBasico pedidoBasico = new PedidoBasico();
        pedidoBasico.agregarProducto(new Producto("", 100));
        System.out.println("El precio del pedido basico es " + pedidoBasico.getPrecio());
        pedidoBasico.setFechaEntrega(LocalDate.now());
        System.out.println("La comision del pedido basico es " + pedidoBasico.getComision());
        pedidoBasico.setFechaEntrega(null); // Lo vuelvo a marcar como no enviado

        final PedidoBasico pedidoBasicoExpress = new PedidoBasico();
        pedidoBasicoExpress.setEsExpress(true);
        pedidoBasicoExpress.agregarProducto(new Producto("", 100));
        System.out.println("El precio del pedido basico express es " + pedidoBasicoExpress.getPrecio());
        pedidoBasicoExpress.setFechaEntrega(LocalDate.now());
        System.out.println("La comision del pedido basico express es " + pedidoBasicoExpress.getComision());
        pedidoBasicoExpress.setFechaEntrega(null); // Lo vuelvo a marcar como no enviado

        final Cadete cadete = new Cadete();
        cadete.agregarPedido(pedidoPremium);
        cadete.agregarPedido(pedidoBasico);
        cadete.agregarPedido(pedidoBasicoExpress);

        System.out.println("Como ningun pedido esta entregado aun la comision debería ser 0 -> resultado: " + cadete.getComisiones());
        pedidoPremium.setFechaEntrega(LocalDate.now());
        pedidoBasico.setFechaEntrega(LocalDate.now());
        pedidoBasicoExpress.setFechaEntrega(LocalDate.now());
        System.out.println("Luego de entregar todos los pedidos la comision es " +  cadete.getComisiones());
    }
}
