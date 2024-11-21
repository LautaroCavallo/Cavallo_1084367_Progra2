package impl;

import api.ConjuntoTDA;

public class ConjuntoAcotadoListaDinamica implements ConjuntoTDA {
    private Nodo inicio;

    private class Nodo {
        int dato;
        Nodo siguiente;
    }

    public void inicializarConjunto() {
        inicio = null;
    }

    public void agregar(int x) {
        if (!pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.dato = x;
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
    }

    public int elegir() {
        return inicio.dato;
    }

    public void sacar(int x) {
        Nodo actual = inicio, anterior = null;
        while (actual != null && actual.dato != x) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual != null) {
            if (anterior == null) inicio = actual.siguiente;
            else anterior.siguiente = actual.siguiente;
        }
    }

    public boolean pertenece(int x) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.dato == x) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean conjuntoVacio() {
        return inicio == null;
    }
}

