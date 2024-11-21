package impl;

import api.ConjuntoTDA;
import api.PilaTDA;
import api.ColaTDA;

import static impl.MetodosExternosCola.copiarCola;
import static impl.MetodosExternosPila.copiarPila;


public class MetodosExternosConjunto {

    // a) Calcular la diferencia simétrica entre dos conjuntos A y B
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA diferencia = new ConjuntoTDAImpl();
        diferencia.inicializarConjunto();

        ConjuntoTDA copiaA = copiarConjunto(A);
        ConjuntoTDA copiaB = copiarConjunto(B);

        // Agregar elementos de A que no estén en B
        while (!copiaA.conjuntoVacio()) {
            int elemento = copiaA.elegir();
            copiaA.sacar(elemento);
            if (!B.pertenece(elemento)) {
                diferencia.agregar(elemento);
            }
        }

        // Agregar elementos de B que no estén en A
        while (!copiaB.conjuntoVacio()) {
            int elemento = copiaB.elegir();
            copiaB.sacar(elemento);
            if (!A.pertenece(elemento)) {
                diferencia.agregar(elemento);
            }
        }

        return diferencia;
    }

    // d) Determinar si dos conjuntos son iguales
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static boolean conjuntosIguales(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA copiaA = copiarConjunto(A);
        ConjuntoTDA copiaB = copiarConjunto(B);

        while (!copiaA.conjuntoVacio()) {
            int elemento = copiaA.elegir();
            copiaA.sacar(elemento);
            if (!B.pertenece(elemento)) {
                return false;
            }
        }

        while (!copiaB.conjuntoVacio()) {
            int elemento = copiaB.elegir();
            copiaB.sacar(elemento);
            if (!A.pertenece(elemento)) {
                return false;
            }
        }

        return true;
    }

    // e) Calcular la cardinalidad de un conjunto
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static int cardinalidad(ConjuntoTDA conjunto) {
        int contador = 0;
        ConjuntoTDA copia = copiarConjunto(conjunto);

        while (!copia.conjuntoVacio()) {
            copia.sacar(copia.elegir());
            contador++;
        }

        return contador;
    }

    // f) Generar el conjunto de elementos que están tanto en la Pila P y en la Cola C
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static ConjuntoTDA elementosEnPilaYCola(PilaTDA P, ColaTDA C) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        PilaTDA copiaPila = copiarPila(P);
        ColaTDA copiaCola = copiarCola(C);

        while (!copiaPila.pilaVacia()) {
            int elemento = copiaPila.tope();
            copiaPila.desapilar();
            if (existeEnCola(copiaCola, elemento)) {
                conjunto.agregar(elemento);
            }
        }

        return conjunto;
    }

    // g) Determinar si los elementos de una Pila P son los mismos que los de una Cola C
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static boolean elementosPilaIgualesCola(PilaTDA P, ColaTDA C) {
        ConjuntoTDA elementosPila = new ConjuntoTDAImpl();
        elementosPila.inicializarConjunto();
        ConjuntoTDA elementosCola = new ConjuntoTDAImpl();
        elementosCola.inicializarConjunto();

        PilaTDA copiaPila = copiarPila(P);
        ColaTDA copiaCola = copiarCola(C);

        while (!copiaPila.pilaVacia()) {
            int elemento = copiaPila.tope();
            copiaPila.desapilar();
            elementosPila.agregar(elemento);
        }

        while (!copiaCola.colaVacia()) {
            int elemento = copiaCola.primero();
            copiaCola.desacolar();
            elementosCola.agregar(elemento);
        }

        return conjuntosIguales(elementosPila, elementosCola);
    }

    // Métodos auxiliares
    public static ConjuntoTDA copiarConjunto(ConjuntoTDA original) {
        ConjuntoTDA copia = new ConjuntoTDAImpl();
        copia.inicializarConjunto();

        ConjuntoTDA temporal = new ConjuntoTDAImpl();
        temporal.inicializarConjunto();

        // Copiar los elementos al conjunto copia
        while (!original.conjuntoVacio()) {
            int elemento = original.elegir();
            temporal.agregar(elemento);
            copia.agregar(elemento);
            original.sacar(elemento);
        }

        // Restaurar los elementos al conjunto original
        while (!temporal.conjuntoVacio()) {
            int elemento = temporal.elegir();
            temporal.sacar(elemento);
            original.agregar(elemento);
        }

        return copia;
    }

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

    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    static ConjuntoTDA obtenerValoresComunes(ConjuntoTDA valoresD1, ConjuntoTDA valoresD2) {
        ConjuntoTDA valoresComunes = new ConjuntoTDAImpl();
        valoresComunes.inicializarConjunto();

        ConjuntoTDA copiaValoresD1 = copiarConjunto(valoresD1);
        while (!copiaValoresD1.conjuntoVacio()) {
            int valor = copiaValoresD1.elegir();
            copiaValoresD1.sacar(valor);
            if (valoresD2.pertenece(valor)) {
                valoresComunes.agregar(valor);
            }
        }

        return valoresComunes;
    }
}
