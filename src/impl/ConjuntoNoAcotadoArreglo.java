package impl;

import api.ConjuntoTDA;

public class ConjuntoNoAcotadoArreglo implements ConjuntoTDA{
    private int[] elementos;
    private int cantidad;

    public void inicializarConjunto() {
        elementos = new int[10];
        cantidad = 0;
    }

    public void agregar(int x) {
        if (!pertenece(x)) {
            if (cantidad == elementos.length) {
                int[] nuevoArreglo = new int[elementos.length * 2];
                System.arraycopy(elementos, 0, nuevoArreglo, 0, elementos.length);
                elementos = nuevoArreglo;
            }
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    public int elegir() {
        return elementos[cantidad - 1];
    }

    public void sacar(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                elementos[i] = elementos[cantidad - 1];
                cantidad--;
                return;
            }
        }
    }

    public boolean pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) return true;
        }
        return false;
    }

    public boolean conjuntoVacio() {
        return cantidad == 0;
    }
}

