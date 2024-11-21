package impl;

import api.PilaTDA;

public class PilaTDAImpl implements PilaTDA {
    private int[] elementos;
    private int tope;

    // Implementación de los métodos básicos de PilaTDA
    @Override
    public void inicializarPila() {
        elementos = new int[100];
        tope = 0;
    }

    @Override
    public void apilar(int x) {
        elementos[tope] = x;
        tope++;
    }

    @Override
    public void desapilar() {
        if (!pilaVacia()) {
            tope--;
        }
    }

    @Override
    public int tope() {
        return elementos[tope - 1];
    }

    @Override
    public boolean pilaVacia() {
        return tope == 0;
    }
}
