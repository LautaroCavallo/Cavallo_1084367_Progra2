package impl;

import api.ColaTDA;

public class MetodosExternosCola {
    // a) Eliminar las repeticiones de una Cola
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static void eliminarRepeticiones(ColaTDA cola) {
        ColaTDA colaAux = new ColaTDAImpl();
        colaAux.inicializarCola();
        ColaTDA colaInvertida = new ColaTDAImpl();
        colaInvertida.inicializarCola();

        // Invertir la cola para preservar el orden al procesar
        while (!cola.colaVacia()) {
            colaInvertida.acolar(cola.primero());
            cola.desacolar();
        }

        // Procesar los elementos e insertar solo los no repetidos en la cola auxiliar
        while (!colaInvertida.colaVacia()) {
            int elemento = colaInvertida.primero();
            colaInvertida.desacolar();
            if (!existeEnCola(colaAux, elemento)) {
                colaAux.acolar(elemento);
            }
        }

        // Reconstruir la cola original sin repeticiones
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
    }

    // b) Repartir una Cola en dos mitades
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static void repartirMitades(ColaTDA cola, ColaTDA mitad1, ColaTDA mitad2) {
        mitad1.inicializarCola();
        mitad2.inicializarCola();
        int totalElementos = contarElementos(cola);
        int mitad = totalElementos / 2;

        for (int i = 0; i < mitad; i++) {
            mitad1.acolar(cola.primero());
            cola.desacolar();
        }
        for (int i = 0; i < mitad; i++) {
            mitad2.acolar(cola.primero());
            cola.desacolar();
        }
    }

    // c) Generar el conjunto de elementos que se repiten en una Cola
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static ColaTDA obtenerElementosRepetidos(ColaTDA cola) {
        ColaTDA elementosRepetidos = new ColaTDAImpl();
        elementosRepetidos.inicializarCola();
        ColaTDA colaAux = new ColaTDAImpl();
        colaAux.inicializarCola();
        ColaTDA copia = copiarCola(cola);

        while (!copia.colaVacia()) {
            int elemento = copia.primero();
            copia.desacolar();
            if (existeEnCola(colaAux, elemento) && !existeEnCola(elementosRepetidos, elemento)) {
                elementosRepetidos.acolar(elemento);
            } else {
                colaAux.acolar(elemento);
            }
        }

        return elementosRepetidos;
    }

    // Metodo auxiliar para copiar una cola
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static ColaTDA copiarCola(ColaTDA original) {
        ColaTDA copia = new ColaTDAImpl();
        copia.inicializarCola();
        ColaTDA auxiliar = new ColaTDAImpl();
        auxiliar.inicializarCola();

        while (!original.colaVacia()) {
            int elemento = original.primero();
            original.desacolar();
            auxiliar.acolar(elemento);
        }

        while (!auxiliar.colaVacia()) {
            int elemento = auxiliar.primero();
            auxiliar.desacolar();
            original.acolar(elemento);
            copia.acolar(elemento);
        }

        return copia;
    }

    // Metodo auxiliar para contar los elementos de una cola
    // Costo Espacial: O(n), Costo Temporal: O(n)
    private static int contarElementos(ColaTDA cola) {
        int contador = 0;
        ColaTDA copia = copiarCola(cola);
        while (!copia.colaVacia()) {
            copia.desacolar();
            contador++;
        }
        return contador;
    }

    // Metodo auxiliar para comprobar si un elemento existe en la cola
    // Costo Espacial: O(n), Costo Temporal: O(n)
    private static boolean existeEnCola(ColaTDA cola, int elemento) {
        ColaTDA copia = copiarCola(cola);
        while (!copia.colaVacia()) {
            if (copia.primero() == elemento) {
                return true;
            }
            copia.desacolar();
        }
        return false;
    }
}
