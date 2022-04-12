package com.utn.frsf.died.guia3.ej3;

import com.utn.frsf.died.guia3.ej2.Escala;
import com.utn.frsf.died.guia3.ej2.Temperatura;

import java.util.Date;
import java.util.Random;

/**
 * Ejercicio 03
 * Se desean registrar las temperaturas históricas para distintas ciudades de las que se
 * obtuvieron muestras. Para ello crearemos la clase Registro, que permite registrar hasta 30
 * temperaturas históricas
 * <p>
 * 1. Crear el paquete para las clases de este ejercicio
 * 2. Tenga en cuenta que para las siguientes clases será necesario importar
 * alguna clase del ejercicio 2, por ejemplo Temperatura
 * 3. Crear la clase Registro.
 * 4. Atributos (mínimos):
 * a. private String ciudad: ciudad a la que pertence el registro de
 * temperaturas
 * b. private Temperatura[] historico: listado de las temperaturas
 * históricas
 * c. Podrá crear otros atributos privados que considere necesarios,
 * como por ejemplo el indice actual en el que se encuentra el
 * último elemento agregado al arreglo, o la capacidad disponible,
 * o la cantidad de elementos insertados, o una constante que
 * indique la capacidad máxima del arreglo
 * 5. Constructores
 * a. Registro() : asigna como nombre de ciudad "-" y crea el arreglo
 * con la capacidad máxima.
 * b. Registro(Strinc ciudad) : asigna como nombre de ciudad el valor
 * del argumento ciudad y crea el arreglo con la capacidad
 * máxima.
 */
public class Main {
    public static void main(String[] args) {
        Registro r1 = new Registro("DENVER");
        Registro r2 = new Registro("NAIROBI");
        Random generadorAleatorio = new Random();
        for (int i = 0; i < 10; i++) {
            r1.agregar(new Temperatura(generadorAleatorio.nextDouble() * 50, Escala.CELCIUS));
        }
        for (int i = 0; i < 10; i++) {
            r2.agregar(new Temperatura(generadorAleatorio.nextDouble() * 105, Escala.FARENHEIT));
        }
        r1.imprimir();
        System.out.println("Promedio en " + r1.getCiudad() + " : " + r1.mediaAsCelcius().getGrados() + " C°");
        System.out.println("Maximo en " + r1.getCiudad() + " : " + r1.maximo().asCelcius() + " C°");
        r2.imprimir();
        System.out.println("Promedio en " + r2.getCiudad() + " : " + r2.mediaAsFahrenheit().getGrados() + " F°");
        System.out.println("Maximo en " + r2.getCiudad() + " :"  + r2.maximo().asFarenheit() + " F°");
    }
}
