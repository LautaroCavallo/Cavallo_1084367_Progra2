package impl;

import api.GrafoTDA;
import api.ConjuntoTDA;

public class GrafoMatrizTDAImpl implements GrafoTDA {
    private static final int MAX_VERTICES = 100;
    private int[][] matrizAdyacencia;
    private int[] vertices;
    private int cantidadVertices;

    // Inicializa el grafo
    // Costo Espacial: O(n^2), Costo Temporal: O(n^2)
    public void inicializarGrafo() {
        matrizAdyacencia = new int[MAX_VERTICES][MAX_VERTICES];
        vertices = new int[MAX_VERTICES];
        cantidadVertices = 0;
    }

    // Agrega un vertice al grafo
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public void agregarVertice(int vertice) {
        if (!existeVertice(vertice)) {
            vertices[cantidadVertices] = vertice;
            cantidadVertices++;
        }
    }

    // Elimina un vertice del grafo
    // Costo Espacial: O(1), Costo Temporal: O(n^2)
    public void eliminarVertice(int vertice) {
        int index = indiceVertice(vertice);
        if (index != -1) {
            for (int i = 0; i < cantidadVertices; i++) {
                matrizAdyacencia[index][i] = 0;
                matrizAdyacencia[i][index] = 0;
            }
            for (int i = index; i < cantidadVertices - 1; i++) {
                vertices[i] = vertices[i + 1];
                for (int j = 0; j < cantidadVertices; j++) {
                    matrizAdyacencia[i][j] = matrizAdyacencia[i + 1][j];
                    matrizAdyacencia[j][i] = matrizAdyacencia[j][i + 1];
                }
            }
            cantidadVertices--;
        }
    }

    // Devuelve un conjunto con todos los vertices del grafo
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public ConjuntoTDA vertices() {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        for (int i = 0; i < cantidadVertices; i++) {
            conjunto.agregar(vertices[i]);
        }
        return conjunto;
    }

    // Agrega una arista con un peso entre dos vertices del grafo
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public void agregarArista(int v1, int v2, int peso) {
        int index1 = indiceVertice(v1);
        int index2 = indiceVertice(v2);
        if (index1 != -1 && index2 != -1) {
            matrizAdyacencia[index1][index2] = peso;
        }
    }

    // Elimina una arista entre dos vertices del grafo
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public void eliminarArista(int v1, int v2) {
        int index1 = indiceVertice(v1);
        int index2 = indiceVertice(v2);
        if (index1 != -1 && index2 != -1) {
            matrizAdyacencia[index1][index2] = 0;
        }
    }

    // Verifica si existe una arista entre dos vertices del grafo
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public boolean ExisteArista(int v1, int v2) {
        int index1 = indiceVertice(v1);
        int index2 = indiceVertice(v2);
        return index1 != -1 && index2 != -1 && matrizAdyacencia[index1][index2] != 0;
    }

    // Devuelve el peso de una arista entre dos vertices del grafo
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public int pesoArista(int v1, int v2) {
        int index1 = indiceVertice(v1);
        int index2 = indiceVertice(v2);
        if (index1 != -1 && index2 != -1) {
            return matrizAdyacencia[index1][index2];
        }
        return 0;
    }

    // Metodo auxiliar para verificar si un vértice existe
    // Costo Espacial: O(1), Costo Temporal: O(n)
    private boolean existeVertice(int vertice) {
        for (int i = 0; i < cantidadVertices; i++) {
            if (vertices[i] == vertice) {
                return true;
            }
        }
        return false;
    }

    // Metodo auxiliar para obtener el índice de un vértice
    // Costo Espacial: O(1), Costo Temporal: O(n)
    private int indiceVertice(int vertice) {
        for (int i = 0; i < cantidadVertices; i++) {
            if (vertices[i] == vertice) {
                return i;
            }
        }
        return -1;
    }
}
