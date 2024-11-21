package app;

import api.PilaTDA;
import impl.PilaTDAImpl;

public class EjercicioTDAPila {

    public static void main(String[] args) {
        EjercicioTDAPila ejercicioTDAPila = new EjercicioTDAPila();

        PilaTDA pilaVacia = new PilaTDAImpl();
        pilaVacia.inicializarPila();
        System.out.println("Prueba con pila vacía:");
        System.out.println("Tope: " + ejercicioTDAPila.obtenerTope(pilaVacia));
        System.out.println("Cantidad de elementos: " + ejercicioTDAPila.contarElementos(pilaVacia));
        System.out.println("Suma de elementos: " + ejercicioTDAPila.sumarElementos(pilaVacia));
        System.out.println("Promedio de elementos: " + ejercicioTDAPila.promedioElementos(pilaVacia));

        PilaTDA pilaUnElemento = new PilaTDAImpl();
        pilaUnElemento.inicializarPila();
        pilaUnElemento.apilar(42);
        System.out.println("\nPrueba con pila de un solo elemento:");
        System.out.println("Tope: " + ejercicioTDAPila.obtenerTope(pilaUnElemento));
        System.out.println("Cantidad de elementos: " + ejercicioTDAPila.contarElementos(pilaUnElemento));
        System.out.println("Suma de elementos: " + ejercicioTDAPila.sumarElementos(pilaUnElemento));
        System.out.println("Promedio de elementos: " + ejercicioTDAPila.promedioElementos(pilaUnElemento));

        PilaTDA pilaOriginal = new PilaTDAImpl();
        pilaOriginal.inicializarPila();
        pilaOriginal.apilar(1);
        pilaOriginal.apilar(2);
        pilaOriginal.apilar(3);
        PilaTDA pilaDestino = new PilaTDAImpl();
        pilaDestino.inicializarPila();
        ejercicioTDAPila.transferirEnOrdenInverso(pilaOriginal, pilaDestino);
        System.out.println("\nPrueba de transferencia en orden inverso:");
        System.out.println("Pila original vacía: " + pilaOriginal.pilaVacia());
        System.out.println("Tope de pila inversa: " + pilaDestino.tope()); // Debería ser 1

        PilaTDA pilaACopiar = new PilaTDAImpl();
        pilaACopiar.inicializarPila();
        pilaACopiar.apilar(5);
        pilaACopiar.apilar(10);
        pilaACopiar.apilar(15);
        PilaTDA pilaCopia = new PilaTDAImpl();
        pilaCopia.inicializarPila();
        ejercicioTDAPila.copiarPila(pilaACopiar, pilaCopia);
        System.out.println("\nPrueba de copiar pila:");
        System.out.println("Tope de pila original: " + pilaACopiar.tope());
        System.out.println("Tope de pila copiada: " + pilaCopia.tope());

        PilaTDA pilaVariosElementos = new PilaTDAImpl();
        pilaVariosElementos.inicializarPila();
        pilaVariosElementos.apilar(10);
        pilaVariosElementos.apilar(20);
        pilaVariosElementos.apilar(30);
        System.out.println("\nPrueba con pila de varios elementos:");
        System.out.println("Tope: " + ejercicioTDAPila.obtenerTope(pilaVariosElementos));
        System.out.println("Cantidad de elementos: " + ejercicioTDAPila.contarElementos(pilaVariosElementos));
        System.out.println("Suma de elementos: " + ejercicioTDAPila.sumarElementos(pilaVariosElementos));
        System.out.println("Promedio de elementos: " + ejercicioTDAPila.promedioElementos(pilaVariosElementos));

    }

    public void copiarPila(PilaTDA origen, PilaTDA destino) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();

        while (!origen.pilaVacia()) {
            auxiliar.apilar(origen.tope());
            origen.desapilar();
        }

        while (!auxiliar.pilaVacia()) {
            int elemento = auxiliar.tope();
            destino.apilar(elemento);
            origen.apilar(elemento);
            auxiliar.desapilar();
        }
    }

    public void invertirPila(PilaTDA pila) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();
        transferirEnOrdenInverso(pila, auxiliar);
        transferirEnOrdenInverso(auxiliar, pila);
    }


    public int obtenerTope(PilaTDA pila) {
        if (!pila.pilaVacia()) {
            return pila.tope();
        }
        return -1;
    }

    public int contarElementos(PilaTDA pila) {
        int contador = 0;
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();

        while (!pila.pilaVacia()) {
            auxiliar.apilar(pila.tope());
            pila.desapilar();
            contador++;
        }

        while (!auxiliar.pilaVacia()) {
            pila.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }

        return contador;
    }

    public int sumarElementos(PilaTDA pila) {
        int suma = 0;
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            suma += elemento;
            auxiliar.apilar(elemento);
            pila.desapilar();
        }

        while (!auxiliar.pilaVacia()) {
            pila.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }

        return suma;
    }

    public double promedioElementos(PilaTDA pila) {
        int suma = sumarElementos(pila);
        int cantidad = contarElementos(pila);
        if (cantidad == 0) {
            return 0;
        }
        return (double) suma / cantidad;
    }

    public void transferirEnOrdenInverso(PilaTDA origen, PilaTDA destino) {
        while (!origen.pilaVacia()) {
            destino.apilar(origen.tope());
            origen.desapilar();
        }
    }

}
