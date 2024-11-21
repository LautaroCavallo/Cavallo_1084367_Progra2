package impl;

import api.ColaPrioridadTDA;
import api.ColaTDA;
import api.PilaTDA;

public class ImplementacionesListasDinamicas {

    // TDA Pila con Lista Dinámica
    public class PilaListaDinamica implements PilaTDA {
        private Nodo tope;

        private class Nodo {
            int dato;
            Nodo siguiente;
        }

        @Override
        public void inicializarPila() {
            tope = null; // La pila comienza vacía
        }

        @Override
        public void apilar(int x) {
            Nodo nuevo = new Nodo();
            nuevo.dato = x;
            nuevo.siguiente = tope;
            tope = nuevo;
        }

        @Override
        public void desapilar() {
            if (!pilaVacia()) {
                tope = tope.siguiente;
            }
        }

        @Override
        public int tope() {
            return tope.dato;
        }

        @Override
        public boolean pilaVacia() {
            return tope == null;
        }
    }
// Costos:
// apilar: O(1)
// desapilar: O(1)
// tope: O(1)

// Comparación con la implementación basada en arreglos:
// Misma complejidad para todas las operaciones, pero la implementación dinámica no tiene restricciones de tamaño fijo.

    // TDA Cola con Lista Dinámica
    public class ColaListaDinamica implements ColaTDA {
        private Nodo inicio;
        private Nodo fin;

        private class Nodo {
            int dato;
            Nodo siguiente;
        }

        @Override
        public void inicializarCola() {
            inicio = null;
            fin = null;
        }

        @Override
        public void acolar(int x) {
            Nodo nuevo = new Nodo();
            nuevo.dato = x;
            nuevo.siguiente = null;

            if (colaVacia()) {
                inicio = nuevo;
            } else {
                fin.siguiente = nuevo;
            }
            fin = nuevo;
        }

        @Override
        public void desacolar() {
            if (!colaVacia()) {
                inicio = inicio.siguiente;
                if (inicio == null) { // Si la cola queda vacía
                    fin = null;
                }
            }
        }

        @Override
        public int primero() {
            return inicio.dato;
        }

        @Override
        public boolean colaVacia() {
            return inicio == null;
        }
    }
// Costos:
// acolar: O(1)
// desacolar: O(1)
// primero: O(1)

// Comparación con la implementación basada en arreglos:
// Misma complejidad para todas las operaciones, pero la implementación dinámica elimina la necesidad de índices circulares y evita problemas de desbordamiento.

    // TDA Cola con Prioridades con Lista Dinámica
    public class ColaPrioridadListaDinamica implements ColaPrioridadTDA {
        private Nodo inicio;

        private class Nodo {
            int dato;
            int prioridad;
            Nodo siguiente;
        }

        @Override
        public void inicializarCola() {
            inicio = null;
        }

        @Override
        public void acolarPrioridad(int x, int p) {
            Nodo nuevo = new Nodo();
            nuevo.dato = x;
            nuevo.prioridad = p;

            if (inicio == null || p > inicio.prioridad) {
                nuevo.siguiente = inicio;
                inicio = nuevo;
            } else {
                Nodo actual = inicio;
                while (actual.siguiente != null && actual.siguiente.prioridad >= p) {
                    actual = actual.siguiente;
                }
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
            }
        }

        @Override
        public void desacolar() {
            if (!colaVacia()) {
                inicio = inicio.siguiente;
            }
        }

        @Override
        public int primero() {
            return inicio.dato;
        }

        @Override
        public int prioridad() {
            return inicio.prioridad;
        }

        @Override
        public boolean colaVacia() {
            return inicio == null;
        }
    }
// Costos:
// acolarPrioridad: O(n) (recorrer para insertar en el lugar correcto).
// desacolar: O(1)
// primero: O(1)

// Comparación con la implementación basada en arreglos:
// Misma complejidad para todas las operaciones, pero la implementación dinámica evita problemas de desbordamiento y es más flexible al crecer en tamaño.

}

//
/*
Comparación de costos entre implementaciones basadas en arreglos y listas dinámicas:

TDA Pila:
- inicializarPila: O(1) en todas las implementaciones.
- apilar:
  * O(1) en arreglos estáticos.
  * O(1) amortizado en arreglos dinámicos (por el redimensionamiento).
  * O(1) en listas dinámicas.
- desapilar: O(1) en todas las implementaciones.
- tope: O(1) en todas las implementaciones.
- pilaVacia: O(1) en todas las implementaciones.

TDA Cola:
- inicializarCola: O(1) en todas las implementaciones.
- acolar:
  * O(1) en arreglos estáticos.
  * O(1) amortizado en arreglos dinámicos (por el redimensionamiento).
  * O(1) en listas dinámicas.
- desacolar: O(1) en todas las implementaciones.
- primero: O(1) en todas las implementaciones.
- colaVacia: O(1) en todas las implementaciones.

TDA Cola con Prioridades:
- inicializarCola: O(1) en todas las implementaciones.
- acolarPrioridad:
  * O(n) en arreglos estáticos.
  * O(n) amortizado en arreglos dinámicos (por el redimensionamiento).
  * O(n) en listas dinámicas.
- desacolar: O(1) en todas las implementaciones.
- primero: O(1) en todas las implementaciones.
- prioridad: O(1) en todas las implementaciones.
- colaVacia: O(1) en todas las implementaciones.

Conclusiones:
1. Las implementaciones basadas en arreglos estáticos son eficientes si el tamaño es conocido y fijo.
2. Las implementaciones dinámicas (arreglos o listas) son más flexibles y manejan mejor el crecimiento dinámico de los datos.
3. Las listas dinámicas consumen más memoria debido a los punteros, pero no requieren redimensionamiento.
4. Si se prioriza la eficiencia, los arreglos estáticos son preferibles para tamaños pequeños o conocidos. Si se prioriza la flexibilidad, las listas dinámicas o los arreglos dinámicos son mejores.
*/
