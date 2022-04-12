package com.utn.frsf.died.guia3.ej4;


import java.util.ArrayList;
import java.util.List;

public class Camino {
    private final List<Coordenada> caminos;

    public Camino() {
        caminos = new ArrayList<>();
    }

    public void agregar(Coordenada coordenada) {
        caminos.add(coordenada);
    }

    public void agregar(double lat, double lng) {
        agregar(new Coordenada(lat, lng));
    }

    public void agregar(int mtsLat, int mtsLn) {
        // Nota: Acá el enunciado dice de sumar mtsLat y mtsLn para obtener una nueva coordenada pero no dice a partir
        // de que punto. Voy a asumir que este metodo opera sobre la ultima coordenada de la lista y si no hay una
        // que sea a partir del origen.
        final Coordenada ultima = caminos.isEmpty() ? new Coordenada() : caminos.get(caminos.size() - 1);
        final Coordenada nuevaCoordenada = new Coordenada(ultima.getLatitud(), ultima.getLongitud());
        nuevaCoordenada.sumar(mtsLat, mtsLn);
        agregar(nuevaCoordenada);
    }

    public List<Coordenada> buscar(Coordenada so, Coordenada se) {
        final List<Coordenada> encontrados = new ArrayList<>();
        for (Coordenada punto : caminos) {
            // Valores negativos de latitud son debajo del ecuador
            // Valores negativos de longitud son a la izquierda de greenwich
            final boolean dentroDeSuperiorIzquierdo = so.getLatitud() >= punto.getLatitud() && so.getLongitud() <= punto.getLongitud();
            final boolean dentroDeInferiorDerecho = punto.getLatitud() >= se.getLatitud() && punto.getLongitud() <= se.getLongitud();
            if (dentroDeInferiorDerecho && dentroDeSuperiorIzquierdo) {
                encontrados.add(punto);
            }
        }
        return encontrados;
    }

    public List<Coordenada> buscar(Coordenada punto, int distancia) {
        final Coordenada so = new Coordenada(punto.getLatitud(), punto.getLongitud());
        so.sumar(distancia, -distancia);
        final Coordenada se = new Coordenada(punto.getLatitud(), punto.getLongitud());
        se.sumar(-distancia, distancia);
        return buscar(so, se);
    }

    public List<Coordenada> getCaminos() {
        return caminos;
    }
}
