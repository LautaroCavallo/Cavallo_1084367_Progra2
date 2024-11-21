package impl;

import api.ABBTDA;
import api.ConjuntoTDA;

public class MetodosExternosABB {

    // a) Dado un elemento, determinar si está o no en un ABB (iterativo y recursivo)
    // Costo Espacial: O(1), Costo Temporal: O(log n) en el mejor caso, O(n) en el peor caso
    public static boolean buscarElementoIterativo(ABBTDA arbol, int elem) {
        while (!arbol.arbolVacio()) {
            if (arbol.raiz() == elem) {
                return true;
            } else if (elem < arbol.raiz()) {
                arbol = arbol.hijoIzq();
            } else {
                arbol = arbol.hijoDer();
            }
        }
        return false;
    }

    // Costo Espacial: O(1), Costo Temporal: O(log n) en el mejor caso, O(n) en el peor caso
    public static boolean buscarElementoRecursivo(ABBTDA arbol, int elem) {
        if (arbol.arbolVacio()) {
            return false;
        } else if (arbol.raiz() == elem) {
            return true;
        } else if (elem < arbol.raiz()) {
            return buscarElementoRecursivo(arbol.hijoIzq(), elem);
        } else {
            return buscarElementoRecursivo(arbol.hijoDer(), elem);
        }
    }

    // b) Dado un elemento, determinar si es una hoja de un ABB
    // Costo Espacial: O(1), Costo Temporal: O(log n) en el mejor caso, O(n) en el peor caso
    public static boolean esHoja(ABBTDA arbol, int elem) {
        if (arbol.arbolVacio()) {
            return false;
        } else if (arbol.raiz() == elem) {
            return arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio();
        } else if (elem < arbol.raiz()) {
            return esHoja(arbol.hijoIzq(), elem);
        } else {
            return esHoja(arbol.hijoDer(), elem);
        }
    }

    // c) Dado un elemento, calcular su profundidad en el ABB
    // Costo Espacial: O(1), Costo Temporal: O(log n) en el mejor caso, O(n) en el peor caso
    public static int calcularProfundidad(ABBTDA arbol, int elem) {
        return calcularProfundidadRecursivo(arbol, elem, 0);
    }

    private static int calcularProfundidadRecursivo(ABBTDA arbol, int elem, int profundidad) {
        if (arbol.arbolVacio()) {
            return -1;
        } else if (arbol.raiz() == elem) {
            return profundidad;
        } else if (elem < arbol.raiz()) {
            return calcularProfundidadRecursivo(arbol.hijoIzq(), elem, profundidad + 1);
        } else {
            return calcularProfundidadRecursivo(arbol.hijoDer(), elem, profundidad + 1);
        }
    }

    // d) Obtener el valor del menor elemento de un ABB
    // Costo Espacial: O(1), Costo Temporal: O(log n) en el mejor caso, O(n) en el peor caso
    public static int obtenerMinimo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            throw new RuntimeException("El árbol está vacío");
        }
        while (!arbol.hijoIzq().arbolVacio()) {
            arbol = arbol.hijoIzq();
        }
        return arbol.raiz();
    }

    // e) Calcular la cantidad de elementos que contiene un ABB
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static int cantidadElementos(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return 1 + cantidadElementos(arbol.hijoIzq()) + cantidadElementos(arbol.hijoDer());
    }

    // f) Calcular la suma de los elementos que contiene un ABB
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static int sumaElementos(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return arbol.raiz() + sumaElementos(arbol.hijoIzq()) + sumaElementos(arbol.hijoDer());
    }

    // g) Calcular la cantidad de hojas de un ABB
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static int cantidadHojas(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        } else if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            return 1;
        }
        return cantidadHojas(arbol.hijoIzq()) + cantidadHojas(arbol.hijoDer());
    }

    // h) Calcular la altura de un ABB
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static int altura(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return -1;
        }
        return 1 + Math.max(altura(arbol.hijoIzq()), altura(arbol.hijoDer()));
    }

    // i) Comprobar si dos ABBs tienen la misma forma
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static boolean mismaForma(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        } else if (arbol1.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        }
        return mismaForma(arbol1.hijoIzq(), arbol2.hijoIzq()) && mismaForma(arbol1.hijoDer(), arbol2.hijoDer());
    }

    // j) Comprobar si dos ABBs son iguales
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static boolean sonIguales(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        } else if (arbol1.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        } else if (arbol1.raiz() != arbol2.raiz()) {
            return false;
        }
        return sonIguales(arbol1.hijoIzq(), arbol2.hijoIzq()) && sonIguales(arbol1.hijoDer(), arbol2.hijoDer());
    }

    // k) Contar la cantidad de elementos que están en un cierto nivel N
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static int contarElementosEnNivel(ABBTDA arbol, int nivel) {
        return contarElementosEnNivelRecursivo(arbol, nivel, 0);
    }

    private static int contarElementosEnNivelRecursivo(ABBTDA arbol, int nivel, int nivelActual) {
        if (arbol.arbolVacio()) {
            return 0;
        } else if (nivel == nivelActual) {
            return 1;
        } else {
            return contarElementosEnNivelRecursivo(arbol.hijoIzq(), nivel, nivelActual + 1) +
                    contarElementosEnNivelRecursivo(arbol.hijoDer(), nivel, nivelActual + 1);
        }
    }

    // l) Mostrar por pantalla todos los elementos que contiene un ABB
    // i. In-orden (izquierda, raíz, derecha)
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static void mostrarInOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            mostrarInOrden(arbol.hijoIzq());
            System.out.print(arbol.raiz() + " ");
            mostrarInOrden(arbol.hijoDer());
        }
    }

    // ii. Pre-orden (raíz, izquierda, derecha)
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static void mostrarPreOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            System.out.print(arbol.raiz() + " ");
            mostrarPreOrden(arbol.hijoIzq());
            mostrarPreOrden(arbol.hijoDer());
        }
    }

    // iii. Post-orden (izquierda, derecha, raíz)
    // Costo Espacial: O(1), Costo Temporal: O(n)
    public static void mostrarPostOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            mostrarPostOrden(arbol.hijoIzq());
            mostrarPostOrden(arbol.hijoDer());
            System.out.print(arbol.raiz() + " ");
        }
    }

    // m) Dado un valor k, armar un conjunto con todos los elementos del ABB que son mayores que k
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static void elementosMayoresQueK(ABBTDA arbol, int k, ConjuntoTDA conjunto) {
        if (!arbol.arbolVacio()) {
            if (arbol.raiz() > k) {
                conjunto.agregar(arbol.raiz());
            }
            elementosMayoresQueK(arbol.hijoIzq(), k, conjunto);
            elementosMayoresQueK(arbol.hijoDer(), k, conjunto);
        }
    }

    // n) Dado un elemento de valor v (que está presente en el ABB), obtener el elemento del árbol que es inmediatamente anterior (en valor)
    // Costo Espacial: O(1), Costo Temporal: O(log n) en el mejor caso, O(n) en el peor caso
    public static int obtenerInmediatoAnterior(ABBTDA arbol, int v) {
        ABBTDA actual = arbol;
        int anterior = Integer.MIN_VALUE;

        while (!actual.arbolVacio()) {
            if (v > actual.raiz()) {
                anterior = actual.raiz();
                actual = actual.hijoDer();
            } else if (v < actual.raiz()) {
                actual = actual.hijoIzq();
            } else {
                if (!actual.hijoIzq().arbolVacio()) {
                    actual = actual.hijoIzq();
                    while (!actual.hijoDer().arbolVacio()) {
                        actual = actual.hijoDer();
                    }
                    anterior = actual.raiz();
                }
                break;
            }
        }
        return anterior;
    }
}
