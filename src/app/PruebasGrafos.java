package app;

import api.GrafoTDA;
import impl.GrafoListasTDAImpl;
import impl.GrafoMatrizTDAImpl;

public class PruebasGrafos {
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

        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(1, 3, 15);
        grafo.agregarArista(2, 4, 20);
        grafo.agregarArista(3, 4, 25);

        System.out.println("Existe arista entre 1 y 2: " + grafo.ExisteArista(1, 2));
        System.out.println("Existe arista entre 2 y 3: " + grafo.ExisteArista(2, 3));

        System.out.println("Peso de arista entre 1 y 3: " + grafo.pesoArista(1, 3));
        System.out.println("Peso de arista entre 3 y 4: " + grafo.pesoArista(3, 4));

        grafo.eliminarArista(1, 3);
        System.out.println("Existe arista entre 1 y 3 (después de eliminar): " + grafo.ExisteArista(1, 3));

        grafo.eliminarVertice(4);
        System.out.println("Existe arista entre 2 y 4 (después de eliminar vértice 4): " + grafo.ExisteArista(2, 4));
    }
}
