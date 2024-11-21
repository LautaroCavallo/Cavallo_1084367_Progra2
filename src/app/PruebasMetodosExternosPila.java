package app;

import api.PilaTDA;
import impl.MetodosExternosPila;
import impl.PilaTDAImpl;

public class PruebasMetodosExternosPila {

    public static void main(String[] args) {
        // Crear instancias de PilaTDAImpl para las pruebas
        PilaTDA pilaOriginal = new PilaTDAImpl();
        pilaOriginal.inicializarPila();

        // Agregar elementos a la pila original
        pilaOriginal.apilar(1);
        pilaOriginal.apilar(2);
        pilaOriginal.apilar(3);
        pilaOriginal.apilar(2);
        pilaOriginal.apilar(1);

        // 1(a) - Probar si la pila es capicúa
        PilaTDA copiaPilaCapicua = copiarPila(pilaOriginal);
        boolean esCapicua = MetodosExternosPila.esCapicua(copiaPilaCapicua);
        System.out.println("¿La pila es capicúa?: " + esCapicua);

        // 1(b) - Probar eliminar repeticiones
        PilaTDA copiaPilaEliminarRepeticiones = copiarPila(pilaOriginal);
        System.out.println("Pila original antes de eliminar repeticiones:");
        imprimirPila(copiaPilaEliminarRepeticiones);

        MetodosExternosPila.eliminarRepeticiones(copiaPilaEliminarRepeticiones);
        System.out.println("Pila después de eliminar repeticiones:");
        imprimirPila(copiaPilaEliminarRepeticiones);

        // 1(c) - Probar repartir la pila en dos mitades (asegúrate de que tiene número par de elementos)
        PilaTDA copiaPilaRepartir = copiarPila(copiaPilaEliminarRepeticiones);
        int totalElementos = contarElementos(copiaPilaRepartir);

        if (totalElementos % 2 == 0) {
            PilaTDA mitad1 = new PilaTDAImpl();
            PilaTDA mitad2 = new PilaTDAImpl();
            mitad1.inicializarPila();
            mitad2.inicializarPila();

            MetodosExternosPila.repartirMitades(copiaPilaRepartir, mitad1, mitad2);
            System.out.println("Mitad 1 de la pila:");
            imprimirPila(mitad1);
            System.out.println("Mitad 2 de la pila:");
            imprimirPila(mitad2);
        } else {
            System.out.println("La pila no tiene un número par de elementos, no se puede repartir en mitades iguales.");
        }

        // 1(d) - Probar obtener elementos repetidos
        PilaTDA copiaPilaRepetidos = copiarPila(pilaOriginal);
        PilaTDA elementosRepetidos = MetodosExternosPila.obtenerElementosRepetidos(copiaPilaRepetidos);
        System.out.println("Elementos repetidos en la pila original:");
        imprimirPila(elementosRepetidos);
    }

    // Metodo auxiliar para imprimir los elementos de una pila
    private static void imprimirPila(PilaTDA pila) {
        PilaTDA copia = copiarPila(pila);
        while (!copia.pilaVacia()) {
            System.out.print(copia.tope() + " ");
            copia.desapilar();
        }
        System.out.println();
    }

    // Metodo auxiliar para copiar una pila (similar al de MetodosExternosPila)
    private static PilaTDA copiarPila(PilaTDA original) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();
        PilaTDA copia = new PilaTDAImpl();
        copia.inicializarPila();

        while (!original.pilaVacia()) {
            int elemento = original.tope();
            original.desapilar();
            auxiliar.apilar(elemento);
        }

        while (!auxiliar.pilaVacia()) {
            int elemento = auxiliar.tope();
            auxiliar.desapilar();
            original.apilar(elemento);
            copia.apilar(elemento);
        }

        return copia;
    }

    // Metodo auxiliar para contar los elementos de una pila
    private static int contarElementos(PilaTDA pila) {
        int contador = 0;
        PilaTDA copia = copiarPila(pila);
        while (!copia.pilaVacia()) {
            copia.desapilar();
            contador++;
        }
        return contador;
    }
}
