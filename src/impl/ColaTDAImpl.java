package impl;

import api.ColaTDA;

public class ColaTDAImpl implements ColaTDA {
    private int[] elementos;
    private int indiceInicio;
    private int indiceFin;


    @Override
    public void inicializarCola() {
        elementos = new int[100];
        indiceInicio = 0;
        indiceFin = 0;
    }

    @Override
    public void acolar(int x) {
        elementos[indiceFin] = x;
        indiceFin++;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            indiceInicio++;
        }
    }

    @Override
    public int primero() {
        return elementos[indiceInicio];
    }

    @Override
    public boolean colaVacia() {
        return indiceInicio == indiceFin;
    }
}
