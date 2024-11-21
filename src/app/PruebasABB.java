package app;

import api.ABBTDA;
import api.ConjuntoTDA;
import impl.ABBTDAImpl;
import impl.ConjuntoTDAImpl;
import impl.MetodosExternosABB;

public class PruebasABB {
    public static void main(String[] args) {
        // Inicialización del árbol binario de búsqueda (ABB)
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Prueba de agregar elementos
        arbol.agregarElem(50);
        arbol.agregarElem(30);
        arbol.agregarElem(70);
        arbol.agregarElem(20);
        arbol.agregarElem(40);
        arbol.agregarElem(60);
        arbol.agregarElem(80);
        System.out.println("Prueba de agregar elementos: ");
        MetodosExternosABB.mostrarInOrden(arbol);
        System.out.println();

        // Prueba de buscar un elemento (iterativo y recursivo)
        System.out.println("Buscar elemento 40 (iterativo): " + MetodosExternosABB.buscarElementoIterativo(arbol, 40));
        System.out.println("Buscar elemento 90 (iterativo): " + MetodosExternosABB.buscarElementoIterativo(arbol, 90));
        System.out.println("Buscar elemento 60 (recursivo): " + MetodosExternosABB.buscarElementoRecursivo(arbol, 60));
        System.out.println("Buscar elemento 25 (recursivo): " + MetodosExternosABB.buscarElementoRecursivo(arbol, 25));

        // Prueba de determinar si un elemento es una hoja
        System.out.println("Elemento 20 es hoja: " + MetodosExternosABB.esHoja(arbol, 20));
        System.out.println("Elemento 30 es hoja: " + MetodosExternosABB.esHoja(arbol, 30));

        // Prueba de calcular la profundidad de un elemento
        System.out.println("Profundidad del elemento 60: " + MetodosExternosABB.calcularProfundidad(arbol, 60));
        System.out.println("Profundidad del elemento 20: " + MetodosExternosABB.calcularProfundidad(arbol, 20));

        // Prueba de obtener el valor mínimo
        System.out.println("Valor mínimo del ABB: " + MetodosExternosABB.obtenerMinimo(arbol));

        // Prueba de calcular la cantidad de elementos
        System.out.println("Cantidad de elementos en el ABB: " + MetodosExternosABB.cantidadElementos(arbol));

        // Prueba de calcular la suma de los elementos
        System.out.println("Suma de los elementos en el ABB: " + MetodosExternosABB.sumaElementos(arbol));

        // Prueba de calcular la cantidad de hojas
        System.out.println("Cantidad de hojas en el ABB: " + MetodosExternosABB.cantidadHojas(arbol));

        // Prueba de calcular la altura del ABB
        System.out.println("Altura del ABB: " + MetodosExternosABB.altura(arbol));

        // Prueba de contar elementos en un cierto nivel
        System.out.println("Cantidad de elementos en el nivel 2: " + MetodosExternosABB.contarElementosEnNivel(arbol, 2));

        // Prueba de mostrar elementos en diferentes órdenes
        System.out.println("Elementos en in-orden: ");
        MetodosExternosABB.mostrarInOrden(arbol);
        System.out.println();
        System.out.println("Elementos en pre-orden: ");
        MetodosExternosABB.mostrarPreOrden(arbol);
        System.out.println();
        System.out.println("Elementos en post-orden: ");
        MetodosExternosABB.mostrarPostOrden(arbol);
        System.out.println();

        // Prueba de armar un conjunto con elementos mayores que k
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        int k = 45;
        MetodosExternosABB.elementosMayoresQueK(arbol, k, conjunto);
        System.out.println("Elementos mayores que " + k + ": ");
        mostrarConjunto(conjunto);

        // Prueba de obtener el elemento inmediatamente anterior
        int valor = 60;
        System.out.println("Elemento inmediatamente anterior a " + valor + ": " + MetodosExternosABB.obtenerInmediatoAnterior(arbol, valor));
    }

    // Metodo auxiliar para mostrar el contenido de un conjunto
    private static void mostrarConjunto(ConjuntoTDA conjunto) {
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.print(elemento + " ");
            conjunto.sacar(elemento);
        }
        System.out.println();
    }
}
