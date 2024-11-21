package app;

import api.GrafoTDA;
import impl.GrafoListasTDAImpl;
import impl.GrafoMatrizTDAImpl;
import api.ConjuntoTDA;
import impl.ConjuntoTDAImpl;

public class Ejercicio9Grafos {
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

        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(3, 2, 15);
        grafo.agregarArista(4, 2, 20);
        grafo.agregarArista(5, 2, 25);

        int vertice = 2;
        int grado = calcularGrado(grafo, vertice);
        System.out.println("Grado del vértice " + vertice + ": " + grado);
    }

    // Metodo para calcular el grado de un vertice en un grafo
    // Costo Espacial: O(1), Costo Temporal: O(V) donde V es el número de vértices del grafo
    private static int calcularGrado(GrafoTDA grafo, int vertice) {
        int gradoSaliente = 0;
        int gradoEntrante = 0;

        // Calcular el grado saliente
        ConjuntoTDA verticesAdyacentes = grafo.vertices();
        ConjuntoTDA copiaVertices = new ConjuntoTDAImpl();
        copiaVertices.inicializarConjunto();
        while (!verticesAdyacentes.conjuntoVacio()) {
            int adyacente = verticesAdyacentes.elegir();
            verticesAdyacentes.sacar(adyacente);
            copiaVertices.agregar(adyacente);
            if (grafo.ExisteArista(vertice, adyacente)) {
                gradoSaliente++;
            }
        }

        // Calcular el grado entrante
        while (!copiaVertices.conjuntoVacio()) {
            int adyacente = copiaVertices.elegir();
            copiaVertices.sacar(adyacente);
            if (grafo.ExisteArista(adyacente, vertice)) {
                gradoEntrante++;
            }
        }

        // Retornar el grado total (entrante + saliente)
        return gradoSaliente + gradoEntrante;
    }
}
