package impl;

import api.ConjuntoTDA;

public class ConjuntoAcotadoArreglo implements ConjuntoTDA {
    private int[] elementos;
    private int cantidad;

    public void inicializarConjunto() {
        elementos = new int[100]; // Tamaño máximo acotado
        cantidad = 0;
    }

    public void agregar(int x) {
        if (!pertenece(x) && cantidad < elementos.length) {
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

    public ConjuntoAcotadoArreglo union(ConjuntoAcotadoArreglo c1, ConjuntoAcotadoArreglo c2) {
        ConjuntoAcotadoArreglo resultado = new ConjuntoAcotadoArreglo();
        resultado.inicializarConjunto();

        for (int i = 0; i < c1.cantidad; i++) {
            resultado.agregar(c1.elementos[i]);
        }

        for (int i = 0; i < c2.cantidad; i++) {
            resultado.agregar(c2.elementos[i]);
        }

        return resultado;
    }

    public ConjuntoAcotadoArreglo interseccion(ConjuntoAcotadoArreglo c1, ConjuntoAcotadoArreglo c2) {
        ConjuntoAcotadoArreglo resultado = new ConjuntoAcotadoArreglo();
        resultado.inicializarConjunto();

        for (int i = 0; i < c1.cantidad; i++) {
            if (c2.pertenece(c1.elementos[i])) {
                resultado.agregar(c1.elementos[i]);
            }
        }

        return resultado;
    }

    public ConjuntoAcotadoArreglo diferencia(ConjuntoAcotadoArreglo c1, ConjuntoAcotadoArreglo c2) {
        ConjuntoAcotadoArreglo resultado = new ConjuntoAcotadoArreglo();
        resultado.inicializarConjunto();

        for (int i = 0; i < c1.cantidad; i++) {
            if (!c2.pertenece(c1.elementos[i])) {
                resultado.agregar(c1.elementos[i]);
            }
        }

        return resultado;
    }
}
