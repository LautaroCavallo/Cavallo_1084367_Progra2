package app;

import api.GrafoTDA;
import impl.GrafoListasTDAImpl;
import impl.GrafoMatrizTDAImpl;
import api.ConjuntoTDA;
import impl.ConjuntoTDAImpl;

public class Ejercicio5Grafos {
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
        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar aristas
        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(1, 3, 15);
        grafo.agregarArista(2, 4, 20);
        grafo.agregarArista(3, 4, 25);
        grafo.agregarArista(4, 5, 30);

        // Calcular y mostrar el mayor costo de las aristas salientes de un vértice
        int vertice = 1;
        int mayorCosto = calcularMayorCostoAristasSalientes(grafo, vertice);
        System.out.println("Mayor costo de las aristas salientes del vértice " + vertice + ": " + mayorCosto);
    }

    // Costo Espacial: O(1), Costo Temporal: O(V) donde V es el número de vértices del grafo
    private static int calcularMayorCostoAristasSalientes(GrafoTDA grafo, int vertice) {
        int mayorCosto = Integer.MIN_VALUE;
        ConjuntoTDA adyacentes = grafo.vertices();

        while (!adyacentes.conjuntoVacio()) {
            int adyacente = adyacentes.elegir();
            adyacentes.sacar(adyacente);
            if (grafo.ExisteArista(vertice, adyacente)) {
                int peso = grafo.pesoArista(vertice, adyacente);
                if (peso > mayorCosto) {
                    mayorCosto = peso;
                }
            }
        }

        return mayorCosto == Integer.MIN_VALUE ? 0 : mayorCosto;
    }
}
