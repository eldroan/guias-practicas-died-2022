package com.utn.frsf.died.guia3.ej4;

import java.util.List;

import static com.utn.frsf.died.guia3.ej4.Constants.LATLNG_TO_METERS_APROX;

/**
 * Implementar una clase Camino, que guarda una lista de Coordenadas que determinan el camino que debe seguir un
 * repartidor para entregar todos los productos que debe repartir.
 * <p>
 * La clase Coordenadas solo posee dos atributos de tipo double, latitud y longitud.
 * <p>
 * La clase Camino, posee una lista de coordenadas, donde se supone que la primera coordenada es donde comienza
 * el camino y la última es donde finaliza.
 */
public class Main {
    public static void main(String[] args) {
        final Camino camino = new Camino();
        camino.agregar(10.0, 10.0);
        camino.agregar(500, 500);
        camino.agregar(new Coordenada(1, 1));

        System.out.println("Existen " + camino.getCaminos().size() + " caminos");

        for (Coordenada c : camino.getCaminos()) {
            System.out.println(c);
        }
        final Coordenada so = new Coordenada(11, 9);
        final Coordenada se = new Coordenada(9, 11);

        System.out.println("Con una coordenada superior izquierda" + so + " y una coordenada inferior izquierda " + se);

        final List<Coordenada> resultado1 = camino.buscar(so, se);

        System.out.println("Se encontraron " + resultado1.size() + " coordenadas");

        for (Coordenada c : resultado1) {
            System.out.println(c);
        }

        System.out.println("------");

        final Coordenada punto = new Coordenada(15, 15);
        final int distanciaEnMetros = 10 * LATLNG_TO_METERS_APROX; // 10 grados a metros

        System.out.println("Partiendo del puntoa" + punto + " y buscando " + distanciaEnMetros + " metros a la redonda");

        final List<Coordenada> resultado2 = camino.buscar(new Coordenada(15, 15), distanciaEnMetros);

        System.out.println("Se encontraron " + resultado2.size() + " coordenadas");

        for (Coordenada c : resultado2) {
            System.out.println(c);
        }

        System.out.println("------");
    }
}
