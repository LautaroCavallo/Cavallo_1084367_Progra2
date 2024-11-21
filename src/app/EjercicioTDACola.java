package app;

import api.ColaTDA;
import impl.ColaTDAImpl;
import impl.PilaTDAImpl;
import api.PilaTDA;

public class EjercicioTDACola {

    public static void main(String[] args) {
        EjercicioTDACola ejercicioTDACola = new EjercicioTDACola();

        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();
        cola.acolar(10);
        cola.acolar(20);
        cola.acolar(30);

        System.out.println("Primero en cola: " + ejercicioTDACola.obtenerPrimero(cola));
        System.out.println("Cantidad de elementos en la cola: " + ejercicioTDACola.contarElementos(cola));
        System.out.println("Suma de elementos en la cola: " + ejercicioTDACola.sumarElementos(cola));
        System.out.println("Promedio de elementos en la cola: " + ejercicioTDACola.promedioElementos(cola));

        ColaTDA colaInversa = new ColaTDAImpl();
        colaInversa.inicializarCola();
        ejercicioTDACola.transferirEnOrdenInversoConPila(cola, colaInversa);
        System.out.println("Cola original después de transferir con Pila Auxiliar: " + ejercicioTDACola.contarElementos(cola) + " elementos");
        System.out.println("Primero en cola inversacon Pila Auxiliar: " + ejercicioTDACola.obtenerPrimero(colaInversa));

        ejercicioTDACola.transferirEnOrdenInverso(cola, colaInversa);
        System.out.println("Cola original después de transferir: " + ejercicioTDACola.contarElementos(cola) + " elementos");
        System.out.println("Primero en cola inversa: " + ejercicioTDACola.obtenerPrimero(colaInversa));

        ColaTDA colaCapicua = new ColaTDAImpl();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(2);
        cola.acolar(1);

        boolean capicua = ejercicioTDACola.esCapicua(colaCapicua);

        System.out.println("¿La cola es capicúa? " + capicua);

        ColaTDA cola1 = new ColaTDAImpl();
        ColaTDA cola2 = new ColaTDAImpl();

        cola1.inicializarCola();
        cola2.inicializarCola();

        cola1.acolar(1);
        cola1.acolar(2);
        cola1.acolar(3);

        cola2.acolar(3);
        cola2.acolar(2);
        cola2.acolar(1);

        boolean inversa = ejercicioTDACola.sonInversas(cola1, cola2);

        System.out.println("¿Las colas son inversas? " + inversa);


    }

    public int obtenerPrimero(ColaTDA cola) {
        if (!cola.colaVacia()) {
            return cola.primero();
        }
        return -1;
    }

    public int contarElementos(ColaTDA cola) {
        int contador = 0;
        ColaTDA auxiliar = new ColaTDAImpl();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            auxiliar.acolar(cola.primero());
            cola.desacolar();
            contador++;
        }

        while (!auxiliar.colaVacia()) {
            cola.acolar(auxiliar.primero());
            auxiliar.desacolar();
        }

        return contador;
    }

    public int sumarElementos(ColaTDA cola) {
        int suma = 0;
        ColaTDA auxiliar = new ColaTDAImpl();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            suma += elemento;
            auxiliar.acolar(elemento);
            cola.desacolar();
        }

        while (!auxiliar.colaVacia()) {
            cola.acolar(auxiliar.primero());
            auxiliar.desacolar();
        }

        return suma;
    }

    public double promedioElementos(ColaTDA cola) {
        int suma = sumarElementos(cola);
        int cantidad = contarElementos(cola);
        return cantidad == 0 ? 0 : (double) suma / cantidad;
    }

    public void transferirEnOrdenInverso(ColaTDA origen, ColaTDA destino) {
        ColaTDA auxiliar1 = new ColaTDAImpl();
        auxiliar1.inicializarCola();

        ColaTDA auxiliar2 = new ColaTDAImpl();
        auxiliar2.inicializarCola();

        while (!origen.colaVacia()) {
            int elemento = origen.primero();
            auxiliar1.acolar(elemento);
            auxiliar2.acolar(elemento);
            origen.desacolar();
        }

        while (!auxiliar2.colaVacia()) {
            destino.acolar(auxiliar2.primero());
            auxiliar2.desacolar();
        }

        while (!auxiliar1.colaVacia()) {
            origen.acolar(auxiliar1.primero());
            auxiliar1.desacolar();
        }
    }
    public void transferirEnOrdenInversoConPila(ColaTDA origen, ColaTDA destino) {
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();

        while (!origen.colaVacia()) {
            pila.apilar(origen.primero());
            origen.desacolar();
        }

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            destino.acolar(elemento);
            pila.desapilar();
            origen.acolar(elemento); // Restaurar la cola original
        }
    }

    public boolean esCapicua(ColaTDA cola) {
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();
        ColaTDA auxiliar = new ColaTDAImpl();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            pila.apilar(elemento);
            auxiliar.acolar(elemento);
            cola.desacolar();
        }

        while (!auxiliar.colaVacia()) {
            int elementoCola = auxiliar.primero();
            cola.acolar(elementoCola);
            auxiliar.desacolar();
            if (elementoCola != pila.tope()) {
                pila.desapilar();
                return false;
            }
            pila.desapilar();
        }

        return true;
    }

    public boolean sonInversas(ColaTDA cola1, ColaTDA cola2) {
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();
        ColaTDA auxiliar1 = new ColaTDAImpl();
        auxiliar1.inicializarCola();
        ColaTDA auxiliar2 = new ColaTDAImpl();
        auxiliar2.inicializarCola();

        while (!cola1.colaVacia()) {
            int elemento = cola1.primero();
            pila.apilar(elemento);
            auxiliar1.acolar(elemento);
            cola1.desacolar();
        }

        while (!cola2.colaVacia()) {
            int elemento = cola2.primero();
            auxiliar2.acolar(elemento);
            if (pila.pilaVacia() || pila.tope() != elemento) {
                return false;
            }
            pila.desapilar();
            cola2.desacolar();
        }

        if (!pila.pilaVacia()) {
            return false;
        }

        while (!auxiliar1.colaVacia()) {
            cola1.acolar(auxiliar1.primero());
            auxiliar1.desacolar();
        }

        while (!auxiliar2.colaVacia()) {
            cola2.acolar(auxiliar2.primero());
            auxiliar2.desacolar();
        }

        return true;
    }

}
