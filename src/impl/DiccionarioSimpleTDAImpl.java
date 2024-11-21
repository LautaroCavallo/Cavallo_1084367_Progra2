package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimpleTDAImpl implements DiccionarioSimpleTDA {
    private int[] claves;
    private int[] valores;
    private int cantidad;


    @Override
    public void InicializarDiccionario() {
        claves = new int[100];
        valores = new int[100];
        cantidad = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        int pos = -1;
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            claves[cantidad] = clave;
            valores[cantidad] = valor;
            cantidad++;
        } else {
            valores[pos] = valor;  // Actualizar el valor si la clave ya existe
        }
    }

    @Override
    public void Eliminar(int clave) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                claves[i] = claves[cantidad - 1];
                valores[i] = valores[cantidad - 1];
                cantidad--;
                break;
            }
        }
    }

    @Override
    public int Recuperar(int clave) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                return valores[i];
            }
        }
        return -1;  // Devuelve un valor indicativo si la clave no existe
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        for (int i = 0; i < cantidad; i++) {
            conjunto.agregar(claves[i]);
        }
        return conjunto;
    }
}
