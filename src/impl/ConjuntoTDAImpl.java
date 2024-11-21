package impl;

import api.ConjuntoTDA;


public class ConjuntoTDAImpl implements ConjuntoTDA {
    private int[] elementos;
    private int cantidad;


    // Implementación de los métodos básicos de ConjuntoTDA
    @Override
    public void inicializarConjunto() {
        elementos = new int[100];
        cantidad = 0;
    }

    @Override
    public void agregar(int x) {
        if (!pertenece(x)) {
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public int elegir() {
        return elementos[cantidad - 1];
    }

    @Override
    public void sacar(int x) {
        int i = 0;
        while (i < cantidad && elementos[i] != x) {
            i++;
        }
        if (i < cantidad) {
            elementos[i] = elementos[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public boolean pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }
}
