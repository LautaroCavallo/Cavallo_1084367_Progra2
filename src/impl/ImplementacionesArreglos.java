package impl;

import api.ColaPrioridadTDA;
import api.ColaTDA;
import api.PilaTDA;

// TDA Pila - Implementación 1: Arreglo Estático
class PilaArregloEstatico implements PilaTDA {
    private int[] elementos;
    private int tope;

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

// TDA Pila - Implementación 2: Arreglo Circular
class PilaArregloCircular implements PilaTDA {
    private int[] elementos;
    private int tope;

    @Override
    public void inicializarPila() {
        elementos = new int[100];
        tope = -1;
    }

    @Override
    public void apilar(int x) {
        tope = (tope + 1) % elementos.length;
        elementos[tope] = x;
    }

    @Override
    public void desapilar() {
        if (!pilaVacia()) {
            tope = (tope - 1 + elementos.length) % elementos.length;
        }
    }

    @Override
    public int tope() {
        return elementos[tope];
    }

    @Override
    public boolean pilaVacia() {
        return tope == -1;
    }
}

// TDA Pila - Implementación 3: Arreglo Dinámico
class PilaArregloDinamico implements PilaTDA {
    private int[] elementos;
    private int tope;

    @Override
    public void inicializarPila() {
        elementos = new int[10];
        tope = 0;
    }

    @Override
    public void apilar(int x) {
        if (tope == elementos.length) {
            int[] nuevoArreglo = new int[elementos.length * 2];
            System.arraycopy(elementos, 0, nuevoArreglo, 0, elementos.length);
            elementos = nuevoArreglo;
        }
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

// TDA Cola - Implementación 1: Arreglo Estático
class ColaArregloEstatico implements ColaTDA {
    private int[] elementos;
    private int inicio;
    private int fin;
    private int cantidad;

    @Override
    public void inicializarCola() {
        elementos = new int[100];
        inicio = 0;
        fin = 0;
        cantidad = 0;
    }

    @Override
    public void acolar(int x) {
        if (cantidad < elementos.length) {
            elementos[fin] = x;
            fin = (fin + 1) % elementos.length;
            cantidad++;
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            inicio = (inicio + 1) % elementos.length;
            cantidad--;
        }
    }

    @Override
    public int primero() {
        return elementos[inicio];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }
}

// TDA Cola - Implementación 2: Arreglo Circular
class ColaArregloCircular implements ColaTDA {
    private int[] elementos;
    private int inicio;
    private int fin;
    private int cantidad;

    @Override
    public void inicializarCola() {
        elementos = new int[100];
        inicio = 0;
        fin = 0;
        cantidad = 0;
    }

    @Override
    public void acolar(int x) {
        if (cantidad < elementos.length) {
            elementos[fin] = x;
            fin = (fin + 1) % elementos.length;
            cantidad++;
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            inicio = (inicio + 1) % elementos.length;
            cantidad--;
        }
    }

    @Override
    public int primero() {
        return elementos[inicio];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }
}

// TDA Cola - Implementación 3: Arreglo Dinámico
class ColaArregloDinamico implements ColaTDA {
    private int[] elementos;
    private int inicio;
    private int fin;

    @Override
    public void inicializarCola() {
        elementos = new int[10];
        inicio = 0;
        fin = 0;
    }

    @Override
    public void acolar(int x) {
        if ((fin + 1) % elementos.length == inicio) {
            int[] nuevoArreglo = new int[elementos.length * 2];
            for (int i = 0; i < elementos.length - 1; i++) {
                nuevoArreglo[i] = elementos[(inicio + i) % elementos.length];
            }
            inicio = 0;
            fin = elementos.length - 1;
            elementos = nuevoArreglo;
        }
        elementos[fin] = x;
        fin = (fin + 1) % elementos.length;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            inicio = (inicio + 1) % elementos.length;
        }
    }

    @Override
    public int primero() {
        return elementos[inicio];
    }

    @Override
    public boolean colaVacia() {
        return inicio == fin;
    }
}

// TDA Cola con Prioridades - Implementación 1: Estática
class ColaPrioridadEstatico implements ColaPrioridadTDA {
    private int[] elementos;
    private int[] prioridades;
    private int cantidad;

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

// TDA Cola con Prioridades - Implementación 2: Dinámica
class ColaPrioridadDinamico implements ColaPrioridadTDA {
    private int[] elementos;
    private int[] prioridades;
    private int cantidad;

    @Override
    public void inicializarCola() {
        elementos = new int[10];
        prioridades = new int[10];
        cantidad = 0;
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        if (cantidad == elementos.length) {
            int[] nuevoElementos = new int[elementos.length * 2];
            int[] nuevasPrioridades = new int[prioridades.length * 2];
            System.arraycopy(elementos, 0, nuevoElementos, 0, elementos.length);
            System.arraycopy(prioridades, 0, nuevasPrioridades, 0, prioridades.length);
            elementos = nuevoElementos;
            prioridades = nuevasPrioridades;
        }
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

// Comparación de costos:
// Implementaciones basadas en arreglos estáticos y dinámicos tienen costos similares en la mayoría de las operaciones.
// - Estático: acolar/desacolar O(1), tope/prioridad O(1), redimensionamiento no es necesario.
// - Dinámico: acolarPrioridad puede ser O(n) si redimensiona, pero tiene mayor flexibilidad en tamaño.
