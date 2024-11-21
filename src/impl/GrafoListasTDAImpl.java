package impl;

import api.GrafoTDA;
import api.ConjuntoTDA;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GrafoListasTDAImpl implements GrafoTDA {
    private Map<Integer, LinkedList<Arista>> grafo;

    private class Arista {
        int destino;
        int peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // Inicializa el grafo
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public void inicializarGrafo() {
        grafo = new HashMap<>();
    }

    // Agrega un vertice al grafo
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public void agregarVertice(int vertice) {
        if (!grafo.containsKey(vertice)) {
            grafo.put(vertice, new LinkedList<>());
        }
    }

    // Elimina un vertice del grafo
    // Costo Espacial: O(1), Costo Temporal: O(V + E) donde V es el número de vértices y E el número de aristas
    public void eliminarVertice(int vertice) {
        if (grafo.containsKey(vertice)) {
            grafo.remove(vertice);
            for (LinkedList<Arista> adyacentes : grafo.values()) {
                adyacentes.removeIf(arista -> arista.destino == vertice);
            }
        }
    }

    // Devuelve un conjunto con todos los vertices del grafo
    // Costo Espacial: O(V), Costo Temporal: O(V)
    public ConjuntoTDA vertices() {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        for (int vertice : grafo.keySet()) {
            conjunto.agregar(vertice);
        }
        return conjunto;
    }

    // Agrega una arista con un peso entre dos vertices del grafo
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public void agregarArista(int v1, int v2, int peso) {
        if (grafo.containsKey(v1) && grafo.containsKey(v2)) {
            grafo.get(v1).add(new Arista(v2, peso));
        }
    }

    // Elimina una arista entre dos vertices del grafo
    // Costo Espacial: O(1), Costo Temporal: O(E) donde E es el número de aristas adyacentes al vértice v1
    public void eliminarArista(int v1, int v2) {
        if (grafo.containsKey(v1)) {
            grafo.get(v1).removeIf(arista -> arista.destino == v2);
        }
    }

    // Verifica si existe una arista entre dos vertices del grafo
    // Costo Espacial: O(1), Costo Temporal: O(E) donde E es el número de aristas adyacentes al vértice v1
    public boolean ExisteArista(int v1, int v2) {
        if (grafo.containsKey(v1)) {
            for (Arista arista : grafo.get(v1)) {
                if (arista.destino == v2) {
                    return true;
                }
            }
        }
        return false;
    }

    // Devuelve el peso de una arista entre dos vertices del grafo
    // Costo Espacial: O(1), Costo Temporal: O(E) donde E es el número de aristas adyacentes al vértice v1
    public int pesoArista(int v1, int v2) {
        if (grafo.containsKey(v1)) {
            for (Arista arista : grafo.get(v1)) {
                if (arista.destino == v2) {
                    return arista.peso;
                }
            }
        }
        return 0;
    }
}
