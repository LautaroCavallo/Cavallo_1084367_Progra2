package app;

import api.GrafoTDA;
import impl.GrafoListasTDAImpl;
import impl.GrafoMatrizTDAImpl;
import api.ConjuntoTDA;
import impl.ConjuntoTDAImpl;

public class Ejercicio8Grafos {
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

        grafo.agregarArista(1, 3, 10);
        grafo.agregarArista(3, 2, 15);
        grafo.agregarArista(1, 4, 20);
        grafo.agregarArista(4, 2, 25);
        grafo.agregarArista(1, 5, 30);
        grafo.agregarArista(5, 2, 35);

        int vertice1 = 1;
        int vertice2 = 2;
        ConjuntoTDA verticesPuente = obtenerVerticesPuente(grafo, vertice1, vertice2);
        System.out.print("Vértices puente entre " + vertice1 + " y " + vertice2 + ": ");
        mostrarConjunto(verticesPuente);
    }

    // Metodo para obtener el conjunto de vértices puente entre dos vértices dados
    // Costo Espacial: O(V), Costo Temporal: O(V) donde V es el número de vértices del grafo
    private static ConjuntoTDA obtenerVerticesPuente(GrafoTDA grafo, int vertice1, int vertice2) {
        ConjuntoTDA verticesPuente = new ConjuntoTDAImpl();
        verticesPuente.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int posiblePuente = vertices.elegir();
            vertices.sacar(posiblePuente);
            if (grafo.ExisteArista(vertice1, posiblePuente) && grafo.ExisteArista(posiblePuente, vertice2)) {
                verticesPuente.agregar(posiblePuente);
            }
        }
        return verticesPuente;
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
