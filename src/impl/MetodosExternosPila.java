package impl;

import api.PilaTDA;

public class MetodosExternosPila {
    // 1(a) - Comprobar si una Pila es capicúa
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static boolean esCapicua(PilaTDA pila) {
        PilaTDA copia = copiarPila(pila);
        PilaTDA invertida = new PilaTDAImpl();
        invertida.inicializarPila();

        // Invertir la pila en la pila `invertida`
        while (!copia.pilaVacia()) {
            invertida.apilar(copia.tope());
            copia.desapilar();
        }

        // Comparar elemento a elemento entre la pila original y la invertida
        PilaTDA originalCopia = copiarPila(pila);
        while (!originalCopia.pilaVacia()) {
            if (originalCopia.tope() != invertida.tope()) {
                return false;
            }
            originalCopia.desapilar();
            invertida.desapilar();
        }
        return true;
    }

    // 1(b) - Eliminar las repeticiones de una Pila
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static void eliminarRepeticiones(PilaTDA pila) {
        PilaTDA pilaAux = new PilaTDAImpl();
        pilaAux.inicializarPila();
        PilaTDA pilaInvertida = new PilaTDAImpl();
        pilaInvertida.inicializarPila();

        // Pasar los elementos a una pila invertida
        while (!pila.pilaVacia()) {
            pilaInvertida.apilar(pila.tope());
            pila.desapilar();
        }

        // Volver a la pila original sin los elementos repetidos
        while (!pilaInvertida.pilaVacia()) {
            int elemento = pilaInvertida.tope();
            pilaInvertida.desapilar();

            // Revisar si el elemento ya está en pilaAux
            if (!existeEnPila(pilaAux, elemento)) {
                pilaAux.apilar(elemento);
            }
        }

        // Reconstruir la pila original en su orden
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

    // 1(c) - Repartir una Pila en dos mitades
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static void repartirMitades(PilaTDA pila, PilaTDA mitad1, PilaTDA mitad2) {
        PilaTDA pilaAux = copiarPila(pila);
        mitad1.inicializarPila();
        mitad2.inicializarPila();
        int totalElementos = contarElementos(pila);
        int mitad = totalElementos / 2;

        // Pasar los elementos a mitad1 y mitad2
        for (int i = 0; i < mitad; i++) {
            mitad1.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
        for (int i = 0; i < mitad; i++) {
            mitad2.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

    // 1(d) - Generar el conjunto de elementos repetidos en una Pila
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static PilaTDA obtenerElementosRepetidos(PilaTDA pila) {
        PilaTDA elementosRepetidos = new PilaTDAImpl();
        elementosRepetidos.inicializarPila();

        PilaTDA pilaAux = new PilaTDAImpl();
        pilaAux.inicializarPila();
        PilaTDA copia = copiarPila(pila);

        while (!copia.pilaVacia()) {
            int elemento = copia.tope();
            copia.desapilar();

            if (existeEnPila(pilaAux, elemento) && !existeEnPila(elementosRepetidos, elemento)) {
                elementosRepetidos.apilar(elemento);
            } else {
                pilaAux.apilar(elemento);
            }
        }

        return elementosRepetidos;
    }

    // Método auxiliar para copiar una pila
    // Costo Espacial: O(n), Costo Temporal: O(n)
    static PilaTDA copiarPila(PilaTDA original) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();
        PilaTDA copia = new PilaTDAImpl();
        copia.inicializarPila();

        // Desapilar original para llenar auxiliar y copiar elementos
        while (!original.pilaVacia()) {
            int elemento = original.tope();
            original.desapilar();
            auxiliar.apilar(elemento);
        }

        // Restaurar original y llenar copia
        while (!auxiliar.pilaVacia()) {
            int elemento = auxiliar.tope();
            auxiliar.desapilar();
            original.apilar(elemento);
            copia.apilar(elemento);
        }

        return copia;
    }

    // Método auxiliar para contar los elementos de una pila
    // Costo Espacial: O(n), Costo Temporal: O(n)
    private static int contarElementos(PilaTDA pila) {
        int contador = 0;
        PilaTDA copia = copiarPila(pila);
        while (!copia.pilaVacia()) {
            copia.desapilar();
            contador++;
        }
        return contador;
    }

    // Método auxiliar para comprobar si un elemento existe en la pila
    // Costo Espacial: O(n), Costo Temporal: O(n)
    private static boolean existeEnPila(PilaTDA pila, int elemento) {
        PilaTDA auxiliar = copiarPila(pila);
        while (!auxiliar.pilaVacia()) {
            if (auxiliar.tope() == elemento) {
                return true;
            }
            auxiliar.desapilar();
        }
        return false;
    }
}
