package impl;

import api.ABBTDA;

public class ABBTDAImpl implements ABBTDA {
    private class Nodo {
        int valor;
        Nodo hijoIzq;
        Nodo hijoDer;
    }

    private Nodo raiz;

    // Inicializa el árbol
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public void inicializarArbol() {
        raiz = null;
    }

    // Devuelve la raíz del árbol
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public int raiz() {
        if (raiz == null) {
            throw new RuntimeException("El árbol está vacío");
        }
        return raiz.valor;
    }

    // Devuelve el subárbol izquierdo
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public ABBTDA hijoIzq() {
        if (raiz == null) {
            throw new RuntimeException("El árbol está vacío");
        }
        ABBTDAImpl hijoIzqArbol = new ABBTDAImpl();
        hijoIzqArbol.raiz = raiz.hijoIzq;
        return hijoIzqArbol;
    }

    // Devuelve el subárbol derecho
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public ABBTDA hijoDer() {
        if (raiz == null) {
            throw new RuntimeException("El árbol está vacío");
        }
        ABBTDAImpl hijoDerArbol = new ABBTDAImpl();
        hijoDerArbol.raiz = raiz.hijoDer;
        return hijoDerArbol;
    }

    // Indica si el árbol está vacío
    // Costo Espacial: O(1), Costo Temporal: O(1)
    public boolean arbolVacio() {
        return raiz == null;
    }

    // Agrega un elemento al árbol
    // Costo Espacial: O(1) por cada nuevo nodo, Costo Temporal: O(log n) en el mejor caso (árbol balanceado), O(n) en el peor caso (arbol degenerado)
    public void agregarElem(int elem) {
        raiz = agregarRecursivo(raiz, elem);
    }

    private Nodo agregarRecursivo(Nodo nodo, int elem) {
        if (nodo == null) {
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.valor = elem;
            nuevoNodo.hijoIzq = null;
            nuevoNodo.hijoDer = null;
            return nuevoNodo;
        }

        if (elem < nodo.valor) {
            nodo.hijoIzq = agregarRecursivo(nodo.hijoIzq, elem);
        } else if (elem > nodo.valor) {
            nodo.hijoDer = agregarRecursivo(nodo.hijoDer, elem);
        }

        return nodo;
    }

    // Elimina un elemento del árbol
    // Costo Espacial: O(1), Costo Temporal: O(log n) en el mejor caso (árbol balanceado), O(n) en el peor caso (arbol degenerado)
    public void eliminarElem(int elem) {
        raiz = eliminarRecursivo(raiz, elem);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int elem) {
        if (nodo == null) {
            return null;
        }

        if (elem < nodo.valor) {
            nodo.hijoIzq = eliminarRecursivo(nodo.hijoIzq, elem);
        } else if (elem > nodo.valor) {
            nodo.hijoDer = eliminarRecursivo(nodo.hijoDer, elem);
        } else { // elem == nodo.valor
            if (nodo.hijoIzq == null && nodo.hijoDer == null) {
                return null;
            } else if (nodo.hijoIzq == null) {
                return nodo.hijoDer;
            } else if (nodo.hijoDer == null) {
                return nodo.hijoIzq;
            } else {
                int minValor = encontrarMinimo(nodo.hijoDer);
                nodo.valor = minValor;
                nodo.hijoDer = eliminarRecursivo(nodo.hijoDer, minValor);
            }
        }

        return nodo;
    }

    // Encuentra el valor mínimo en un árbol
    // Costo Espacial: O(1), Costo Temporal: O(log n) en el mejor caso (árbol balanceado), O(n) en el peor caso (arbol degenerado)
    private int encontrarMinimo(Nodo nodo) {
        while (nodo.hijoIzq != null) {
            nodo = nodo.hijoIzq;
        }
        return nodo.valor;
    }
}
