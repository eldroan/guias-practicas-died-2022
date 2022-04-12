package com.utn.frsf.died.guia3.ej3;

import com.utn.frsf.died.guia3.ej2.Escala;
import com.utn.frsf.died.guia3.ej2.Temperatura;

import java.util.ArrayList;
import java.util.List;

public class Registro {
    private final String ciudad;
    private static final String SEPARATOR = " ";
    private static final String NEW_LINE = "\n";
    private static final int CAPACIDAD = 20;
    private final List<Temperatura> historico;

    public Registro() {
        this("", new ArrayList<>());
    }

    public Registro(String ciudad) {
        this(ciudad, new ArrayList<>());
    }

    public Registro(String ciudad, List<Temperatura> historico) {
        this.ciudad = ciudad;
        this.historico = historico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TEMPERATURAS REGISTRADAS EN : " + ciudad);
        for (int i = 0; i < historico.size(); i++) {
            Temperatura temp = historico.get(i);
            sb.append(NEW_LINE);
            sb.append(i + 1);
            sb.append(SEPARATOR);
            sb.append(temp.toString());
        }
        return sb.toString();
    }

    public void agregar(Temperatura t) {
        if (historico.size() < CAPACIDAD) {
            historico.add(t);
        }
    }

    public Temperatura mediaAsCelcius() {
        // Calculamos en celcius por si hay temperaturas en escalas diferentes
        double temperaturaEnCelcius = 0;
        for (Temperatura temp : historico) {
            temperaturaEnCelcius += temp.asCelcius();
        }
        return new Temperatura(temperaturaEnCelcius / historico.size(), Escala.CELCIUS);
    }

    public Temperatura mediaAsFahrenheit() {
        return new Temperatura(mediaAsCelcius().asFarenheit(), Escala.FARENHEIT);
    }

    public Temperatura maximo() {
        return maximo(historico);
    }

    private Temperatura maximo(List<Temperatura> t) {
        if (t == null || t.isEmpty()) {
            return null;
        } else if (t.size() == 1) {
            return t.get(0);
        } else {
            // Ojo de usar "t" y no "historico"
            final int mitad = t.size() / 2;
            final List<Temperatura> lista1 = t.subList(0, mitad);
            final List<Temperatura> lista2 = t.subList(mitad, t.size());
            final Temperatura max1 = maximo(lista1);
            final Temperatura max2 = maximo(lista2);
            // Casteamos a celcius por si tenemos mezcla de escalas
            if (max1.asCelcius() > max2.asCelcius()) {
                return max1;
            } else {
                return max2;
            }
        }
    }

}
