package com.utn.frsf.died.guia3.ej2;

/**
 * Se desea modelar la clase Temperatura que permita registrar los grados de una temperatura y
 * la esacala (F° o C° ), y que permita realizar conversiones entre dichos valores.
 * Para la conversión usar la siguiente formula:
 * • De F° a C° ⇒ C° = (F°-32) * 5/9;
 * • De C° a F° ⇒ °F = C° * 9/5 + 32;
 * Creación de Clases
 * 1. Crear el paquete para las clases de este problema (por ejemplo
 * died.guia01.ejercicio02)
 * 1. Dentro del paquete crear el tipo de datos enum, de nombre Escala, que tenga dos
 * valores “FAHRENHEIT” y “CELCIUS”.
 * 2. Crear la clase Temperatura
 * 3. Atributos de la clase Temperatura (defina el modificador de visibilidad que considere
 * apropiado)
 * a. Double grados;
 * b. Escala escala;
 * 4. Constructores
 * a. El constructor por defecto que inicializa en 0 la temperatura y en CELCIUS la
 * escala.
 * b. El constructor con dos argumentos, la temperatura y la escala que asignará a
 * la Temperatura un valor inicial y una escala predefinida.
 * 5. Métodos
 * a. Crear el método toString() que retorna un string representando la
 * temperatura en formato <GRADOS> <SIMBOLO>. Por ejemplo
 * toString() retorna "14 C°" para representar la temperatura de 14
 * grados celcius
 * b. Crear el método “Double asCelcius()” que retorna la temperatura actual en
 * grados Celcius.
 * c. Crear el método “Double asFahrenheit()” que retorna la temperatura actual en
 * grados Fahrenheit.
 * d. Crear un método aumentar(Temperatura temperatura) y un método
 * disminuir(Temperatura). Estos métodos aumentan o disminuyen la
 * temperatura según el valor del parámetro recibido.
 * i. Verificar que el valor sea siempre mayor que 0.0.
 * ii. Tener en cuenta que si la temperatura recibida como parámetro está
 * en una escala, y el objeto que ejecuta el método está en otra escala
 * hay que realizar la conversión o invocar al método que realiza la
 * conversión
 */
public class Main {

    public static void main(String[] args) {
        Temperatura dia1 = new Temperatura(30.0, Escala.CELCIUS);
        Temperatura dia2 = new Temperatura(55.0, Escala.FARENHEIT);
        System.out.println("T1 en C°: " + dia1.asCelcius());
        System.out.println("T1 en F°: " + dia1.asFarenheit());
        System.out.println("T2 en C°: " + dia2.asCelcius());
        System.out.println("T2 en F°: " + dia2.asFarenheit());
        dia2.aumentar(dia1);
        System.out.println("T1+T2 en C°: " + dia2.asCelcius());
        System.out.println("T1+T2 en F°: " + dia2.asFarenheit());
        dia1.disminuir(new Temperatura(10.0, Escala.CELCIUS));
        System.out.println("T1 en C°: " + dia1.asCelcius());
        System.out.println("T1 en F°: " + dia1.asFarenheit());
    }
}
