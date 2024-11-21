package app;

import api.GrafoTDA;
import impl.GrafoListasTDAImpl;
import impl.GrafoMatrizTDAImpl;
import api.ConjuntoTDA;
import impl.ConjuntoTDAImpl;

public class Ejercicio4Grafos {
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
        grafo.agregarArista(1, 3, 15);
        grafo.agregarArista(2, 4, 20);
        grafo.agregarArista(3, 4, 25);
        grafo.agregarArista(4, 5, 30);

        int vertice = 1;
        ConjuntoTDA adyacentesDobles = calcularAdyacentesDobles(grafo, vertice);
        System.out.print("Adyacentes dobles del vértice " + vertice + ": ");
        mostrarConjunto(adyacentesDobles);
    }


    private static ConjuntoTDA calcularAdyacentesDobles(GrafoTDA grafo, int vertice) {
        ConjuntoTDA adyacentesDobles = new ConjuntoTDAImpl();
        adyacentesDobles.inicializarConjunto();
        ConjuntoTDA adyacentes = grafo.vertices();

        while (!adyacentes.conjuntoVacio()) {
            int adyacente = adyacentes.elegir();
            adyacentes.sacar(adyacente);
            if (grafo.ExisteArista(vertice, adyacente)) {
                ConjuntoTDA adyacentesDeAdyacente = grafo.vertices();
                while (!adyacentesDeAdyacente.conjuntoVacio()) {
                    int adyacenteDoble = adyacentesDeAdyacente.elegir();
                    adyacentesDeAdyacente.sacar(adyacenteDoble);
                    if (grafo.ExisteArista(adyacente, adyacenteDoble)) {
                        adyacentesDobles.agregar(adyacenteDoble);
                    }
                }
            }
        }
        return adyacentesDobles;
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
