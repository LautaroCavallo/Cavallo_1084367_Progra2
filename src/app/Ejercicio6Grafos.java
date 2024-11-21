package app;

import api.GrafoTDA;
import impl.GrafoListasTDAImpl;
import impl.GrafoMatrizTDAImpl;
import api.ConjuntoTDA;
import impl.ConjuntoTDAImpl;

public class Ejercicio6Grafos {
    public static void main(String[] args) {
        System.out.println("\nGrafo con Listas de Adyacencia:");
        GrafoTDA grafoListas = new GrafoListasTDAImpl();
        grafoListas.inicializarGrafo();
        probarGrafo(grafoListas);

        System.out.println("\nGrafo con Matriz de Adyacencia:");
        GrafoTDA grafoMatriz = new GrafoMatrizTDAImpl();
        grafoMatriz.inicializarGrafo();
        probarGrafo(grafoMatriz);
    }

    private static void probarGrafo(GrafoTDA grafo) {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(3, 2, 15);
        grafo.agregarArista(4, 2, 20);
        grafo.agregarArista(5, 2, 25);

        int vertice = 2;
        ConjuntoTDA predecesores = obtenerPredecesores(grafo, vertice);
        System.out.print("Predecesores del vértice " + vertice + ": ");
        mostrarConjunto(predecesores);
    }

    // Metodo para obtener el conjunto de predecesores de un vértice dado
    // Costo Espacial: O(V), Costo Temporal: O(V) donde V es el número de vértices del grafo
    private static ConjuntoTDA obtenerPredecesores(GrafoTDA grafo, int vertice) {
        ConjuntoTDA predecesores = new ConjuntoTDAImpl();
        predecesores.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int posiblePredecesor = vertices.elegir();
            vertices.sacar(posiblePredecesor);
            if (grafo.ExisteArista(posiblePredecesor, vertice)) {
                predecesores.agregar(posiblePredecesor);
            }
        }
        return predecesores;
    }

    private static void mostrarConjunto(ConjuntoTDA conjunto) {
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.print(elemento + " ");
            conjunto.sacar(elemento);
        }
        System.out.println();
    }
}
