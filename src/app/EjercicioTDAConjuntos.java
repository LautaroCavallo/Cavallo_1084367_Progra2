package app;

import api.ConjuntoTDA;
import impl.ConjuntoAcotadoArreglo;

public class EjercicioTDAConjuntos {
    public static void main(String[] args) {
        ConjuntoTDA c1 = new ConjuntoAcotadoArreglo();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        ConjuntoTDA c2 = new ConjuntoAcotadoArreglo();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);

        EjercicioTDAConjuntos tester = new EjercicioTDAConjuntos();

        ConjuntoTDA union = tester.union(c1, c2);
        System.out.println("Unión:");
        while (!union.conjuntoVacio()) {
            int elemento = union.elegir();
            System.out.print(elemento + " ");
            union.sacar(elemento);
        }

        c1.agregar(1); c1.agregar(2); c1.agregar(3); // Restaurar c1
        c2.agregar(3); c2.agregar(4); c2.agregar(5); // Restaurar c2

        ConjuntoTDA interseccion = tester.interseccion(c1, c2);
        System.out.println("\nIntersección:");
        while (!interseccion.conjuntoVacio()) {
            int elemento = interseccion.elegir();
            System.out.print(elemento + " ");
            interseccion.sacar(elemento);
        }

        c1.agregar(1); c1.agregar(2); c1.agregar(3); // Restaurar c1
        c2.agregar(3); c2.agregar(4); c2.agregar(5); // Restaurar c2

        ConjuntoTDA diferencia = tester.diferencia(c1, c2);
        System.out.println("\nDiferencia:");
        while (!diferencia.conjuntoVacio()) {
            int elemento = diferencia.elegir();
            System.out.print(elemento + " ");
            diferencia.sacar(elemento);
        }
    }

    public ConjuntoTDA union(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA resultado = new ConjuntoAcotadoArreglo();
        resultado.inicializarConjunto();

        ConjuntoTDA aux = copiarConjunto(c1);
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            resultado.agregar(elemento);
            aux.sacar(elemento);
        }

        aux = copiarConjunto(c2);
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            resultado.agregar(elemento);
            aux.sacar(elemento);
        }

        return resultado;
    }

    public ConjuntoTDA interseccion(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA resultado = new ConjuntoAcotadoArreglo();
        resultado.inicializarConjunto();

        ConjuntoTDA aux = copiarConjunto(c1);
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            if (c2.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
            aux.sacar(elemento);
        }

        return resultado;
    }

    public ConjuntoTDA diferencia(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA resultado = new ConjuntoAcotadoArreglo();
        resultado.inicializarConjunto();

        ConjuntoTDA aux = copiarConjunto(c1);
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            if (!c2.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
            aux.sacar(elemento);
        }

        return resultado;
    }

    private ConjuntoTDA copiarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA copia = new ConjuntoAcotadoArreglo();
        copia.inicializarConjunto();

        ConjuntoTDA aux = new ConjuntoAcotadoArreglo();
        aux.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            copia.agregar(elemento);
            aux.agregar(elemento);
            conjunto.sacar(elemento);
        }

        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            conjunto.agregar(elemento);
            aux.sacar(elemento);
        }

        return copia;
    }
}
