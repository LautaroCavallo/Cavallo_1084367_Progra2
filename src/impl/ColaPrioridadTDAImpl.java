package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadTDAImpl implements ColaPrioridadTDA {
    private int[] elementos;
    private int[] prioridades;
    private int cantidad;


    // Implementación de los métodos básicos de ColaPrioridadTDA
    @Override
    public void inicializarCola() {
        elementos = new int[100];
        prioridades = new int[100];
        cantidad = 0;
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        int i = cantidad;
        while (i > 0 && prioridades[i - 1] < p) {
            elementos[i] = elementos[i - 1];
            prioridades[i] = prioridades[i - 1];
            i--;
        }
        elementos[i] = x;
        prioridades[i] = p;
        cantidad++;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            for (int i = 0; i < cantidad - 1; i++) {
                elementos[i] = elementos[i + 1];
                prioridades[i] = prioridades[i + 1];
            }
            cantidad--;
        }
    }


    @Override
    public int primero() {
        return elementos[0];
    }

    @Override
    public int prioridad() {
        return prioridades[0];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }
}
