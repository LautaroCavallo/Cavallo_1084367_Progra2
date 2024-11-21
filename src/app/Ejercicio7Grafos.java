package app;

import api.GrafoTDA;
import impl.GrafoListasTDAImpl;
import impl.GrafoMatrizTDAImpl;
import api.ConjuntoTDA;
import impl.ConjuntoTDAImpl;

public class Ejercicio7Grafos {
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

        ConjuntoTDA verticesAislados = obtenerVerticesAislados(grafo);
        System.out.print("Vértices aislados: ");
        mostrarConjunto(verticesAislados);
    }

    // Metodo para obtener el conjunto de vértices aislados en un grafo
    // Costo Espacial: O(V), Costo Temporal: O(V^2) donde V es el número de vértices del grafo
    private static ConjuntoTDA obtenerVerticesAislados(GrafoTDA grafo) {
        ConjuntoTDA verticesAislados = new ConjuntoTDAImpl();
        verticesAislados.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();
        ConjuntoTDA verticesCopia = new ConjuntoTDAImpl();
        verticesCopia.inicializarConjunto();

        // Crear una copia de los vértices para iterar sin modificar el conjunto original
        ConjuntoTDA verticesOriginal = grafo.vertices();
        while (!verticesOriginal.conjuntoVacio()) {
            int vertice = verticesOriginal.elegir();
            verticesOriginal.sacar(vertice);
            verticesCopia.agregar(vertice);
        }

        // Verificar si cada vértice es aislado
        while (!verticesCopia.conjuntoVacio()) {
            int vertice = verticesCopia.elegir();
            verticesCopia.sacar(vertice);
            boolean tieneAristas = false;

            // Verificar si tiene aristas salientes o entrantes
            ConjuntoTDA verticesAdyacentes = grafo.vertices();
            while (!verticesAdyacentes.conjuntoVacio()) {
                int adyacente = verticesAdyacentes.elegir();
                verticesAdyacentes.sacar(adyacente);
                if (grafo.ExisteArista(vertice, adyacente) || grafo.ExisteArista(adyacente, vertice)) {
                    tieneAristas = true;
                    break;
                }
            }

            if (!tieneAristas) {
                verticesAislados.agregar(vertice);
            }
        }

        return verticesAislados;
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
