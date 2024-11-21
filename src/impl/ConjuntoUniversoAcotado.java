package impl;

import api.ConjuntoTDA;

class ConjuntoUniversoAcotado implements ConjuntoTDA{
    private boolean[] universo;

    public void inicializarConjunto() {
        universo = new boolean[101]; // Universo de números entre 0 y 100
    }

    public void agregar(int x) {
        if (x >= 0 && x < universo.length) universo[x] = true;
    }

    public int elegir() {
        for (int i = 0; i < universo.length; i++) {
            if (universo[i]) return i;
        }
        return -1; // Indicador de conjunto vacío
    }

    public void sacar(int x) {
        if (x >= 0 && x < universo.length) universo[x] = false;
    }

    public boolean pertenece(int x) {
        return x >= 0 && x < universo.length && universo[x];
    }

    public boolean conjuntoVacio() {
        for (boolean b : universo) {
            if (b) return false;
        }
        return true;
    }
}
