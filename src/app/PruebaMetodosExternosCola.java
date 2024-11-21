package app;

import api.ColaTDA;
import impl.MetodosExternosCola;
import impl.ColaTDAImpl;

public class PruebaMetodosExternosCola {

    public static void main(String[] args) {
        // Crear instancias de ColaTDAImpl para las pruebas
        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();

        // Agregar elementos a la cola
        cola.acolar(4);
        cola.acolar(5);
        cola.acolar(6);
        cola.acolar(4);
        cola.acolar(7);
        cola.acolar(5);

        // a) Probar eliminar repeticiones
        System.out.println("Cola original antes de eliminar repeticiones:");
        imprimirCola(cola);

        // Hacer una copia de la cola original para futuras pruebas
        ColaTDA copiaColaOriginal = MetodosExternosCola.copiarCola(cola);

        // Eliminar repeticiones
        MetodosExternosCola.eliminarRepeticiones(cola);
        System.out.println("Cola después de eliminar repeticiones:");
        imprimirCola(cola);

        // b) Probar repartir la cola en dos mitades
        ColaTDA mitad1 = new ColaTDAImpl();
        ColaTDA mitad2 = new ColaTDAImpl();
        mitad1.inicializarCola();
        mitad2.inicializarCola();
        MetodosExternosCola.repartirMitades(cola, mitad1, mitad2);
        System.out.println("Mitad 1 de la cola:");
        imprimirCola(mitad1);
        System.out.println("Mitad 2 de la cola:");
        imprimirCola(mitad2);

        // c) Probar obtener elementos repetidos usando la copia de la cola original
        ColaTDA elementosRepetidos = MetodosExternosCola.obtenerElementosRepetidos(copiaColaOriginal);
        System.out.println("Elementos repetidos en la cola original:");
        imprimirCola(elementosRepetidos);
    }

    // Metodo auxiliar para imprimir los elementos de una cola
    private static void imprimirCola(ColaTDA cola) {
        ColaTDA copia = MetodosExternosCola.copiarCola(cola);
        while (!copia.colaVacia()) {
            System.out.print(copia.primero() + " ");
            copia.desacolar();
        }
        System.out.println();
    }
}
