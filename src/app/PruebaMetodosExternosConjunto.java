package app;

import api.ConjuntoTDA;
import api.PilaTDA;
import api.ColaTDA;
import impl.MetodosExternosConjunto;
import impl.ConjuntoTDAImpl;
import impl.PilaTDAImpl;
import impl.ColaTDAImpl;

public class PruebaMetodosExternosConjunto {

    public static void main(String[] args) {
        // Crear instancias de ConjuntoTDAImpl para las pruebas
        ConjuntoTDA conjuntoA = new ConjuntoTDAImpl();
        ConjuntoTDA conjuntoB = new ConjuntoTDAImpl();
        conjuntoA.inicializarConjunto();
        conjuntoB.inicializarConjunto();

        // Agregar elementos a los conjuntos A y B
        conjuntoA.agregar(1);
        conjuntoA.agregar(2);
        conjuntoA.agregar(3);

        conjuntoB.agregar(3);
        conjuntoB.agregar(4);
        conjuntoB.agregar(5);

        // a) Probar diferencia simétrica
        ConjuntoTDA diferencia = MetodosExternosConjunto.diferenciaSimetrica(conjuntoA, conjuntoB);
        System.out.println("Diferencia simétrica entre A y B:");
        imprimirConjunto(diferencia);

        // d) Probar si dos conjuntos son iguales
        ConjuntoTDA conjuntoC = new ConjuntoTDAImpl();
        conjuntoC.inicializarConjunto();
        conjuntoC.agregar(1);
        conjuntoC.agregar(2);
        conjuntoC.agregar(3);
        boolean iguales = MetodosExternosConjunto.conjuntosIguales(conjuntoA, conjuntoC);
        System.out.println("¿Conjunto A y C son iguales?: " + iguales);

        // e) Probar cardinalidad
        int cardinalidadA = MetodosExternosConjunto.cardinalidad(conjuntoA);
        System.out.println("Cardinalidad de A: " + cardinalidadA);

        // f) Probar elementos en Pila y Cola
        PilaTDA pila = new PilaTDAImpl();
        ColaTDA cola = new ColaTDAImpl();
        pila.inicializarPila();
        cola.inicializarCola();

        // Agregar elementos a la Pila y a la Cola
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);

        cola.acolar(3);
        cola.acolar(4);
        cola.acolar(1);

        ConjuntoTDA elementosComunes = MetodosExternosConjunto.elementosEnPilaYCola(pila, cola);
        System.out.println("Elementos comunes entre la Pila y la Cola:");
        imprimirConjunto(elementosComunes);

        // g) Probar si los elementos de la Pila son los mismos que los de la Cola
        boolean mismosElementos = MetodosExternosConjunto.elementosPilaIgualesCola(pila, cola);
        System.out.println("¿Los elementos de la Pila son los mismos que los de la Cola?: " + mismosElementos);
    }

    // Método auxiliar para imprimir los elementos de un conjunto
    private static void imprimirConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA copia = new ConjuntoTDAImpl();
        copia.inicializarConjunto();

        // Crear una copia del conjunto para imprimir sin modificar el original
        ConjuntoTDA temporal = new ConjuntoTDAImpl();
        temporal.inicializarConjunto();

        // Copiar los elementos a un conjunto temporal para la impresión
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            temporal.agregar(elemento);
            copia.agregar(elemento);
            conjunto.sacar(elemento);
        }

        // Restaurar los elementos al conjunto original
        while (!copia.conjuntoVacio()) {
            int elemento = copia.elegir();
            copia.sacar(elemento);
            conjunto.agregar(elemento);
        }

        // Imprimir los elementos del conjunto temporal
        while (!temporal.conjuntoVacio()) {
            int elemento = temporal.elegir();
            System.out.print(elemento + " ");
            temporal.sacar(elemento);
        }
        System.out.println();
    }
}
