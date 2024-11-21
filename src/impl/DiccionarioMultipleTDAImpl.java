package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class DiccionarioMultipleTDAImpl implements DiccionarioMultipleTDA {
    private int[] claves;
    private ConjuntoTDA[] valores;
    private int cantidad;


    @Override
    public void inicializarDiccionario() {
        claves = new int[100];
        valores = new ConjuntoTDA[100];
        cantidad = 0;

        // Inicializar cada elemento de valores como una instancia de ConjuntoTDA
        for (int i = 0; i < valores.length; i++) {
            valores[i] = new ConjuntoTDAImpl();
            valores[i].inicializarConjunto();
        }
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
            valores[cantidad] = new ConjuntoTDAImpl();
            valores[cantidad].inicializarConjunto();
            valores[cantidad].agregar(valor);
            cantidad++;
        } else {
            valores[pos].agregar(valor);  // Agregar valor si la clave ya existe
        }
    }

    @Override
    public void eliminar(int clave) {
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
    public void eliminarValor(int clave, int valor) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                valores[i].sacar(valor);  // Elimina el valor específico si existe
                break;
            }
        }
    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                return valores[i];
            }
        }
        return null;  // Devuelve null si la clave no existe
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        for (int i = 0; i < cantidad; i++) {
            conjunto.agregar(claves[i]);
        }
        return conjunto;
    }
}
