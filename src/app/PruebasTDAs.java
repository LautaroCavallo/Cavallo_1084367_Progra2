package app;

import impl.ColaTDAImpl;
import impl.PilaTDAImpl;
import impl.ConjuntoTDAImpl;
import impl.DiccionarioSimpleTDAImpl;
import impl.DiccionarioMultipleTDAImpl;
import impl.ColaPrioridadTDAImpl;
import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import api.DiccionarioMultipleTDA;
import api.PilaTDA;
import api.ColaTDA;

public class PruebasTDAs {
    public static void main(String[] args) {

        // Prueba de Pila
        System.out.println("---- Prueba de Pila ----");
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);
        System.out.println("Tope de pila: " + pila.tope());
        pila.desapilar();
        System.out.println("Tope de pila después de desapilar: " + pila.tope());
        System.out.println("Pila vacía: " + pila.pilaVacia());

        // Prueba de Cola
        System.out.println("\n---- Prueba de Cola ----");
        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();
        cola.acolar(10);
        cola.acolar(20);
        cola.acolar(30);
        System.out.println("Primero en cola: " + cola.primero());
        cola.desacolar();
        System.out.println("Primero en cola después de desacolar: " + cola.primero());
        System.out.println("Cola vacía: " + cola.colaVacia());

        // Prueba de Conjunto
        System.out.println("\n---- Prueba de Conjunto ----");
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        conjunto.agregar(10);
        conjunto.agregar(20);
        conjunto.agregar(30);
        System.out.println("Pertenece 20: " + conjunto.pertenece(20));
        conjunto.sacar(20);
        System.out.println("Pertenece 20 después de sacarlo: " + conjunto.pertenece(20));
        System.out.println("Conjunto vacío: " + conjunto.conjuntoVacio());

        // Prueba de Diccionario Simple
        System.out.println("\n---- Prueba de Diccionario Simple ----");
        DiccionarioSimpleTDA diccionarioSimple = new DiccionarioSimpleTDAImpl();
        diccionarioSimple.InicializarDiccionario();
        diccionarioSimple.agregar(1, 1);
        diccionarioSimple.agregar(2, 1);
        diccionarioSimple.agregar(3, 1);
        System.out.println("Recuperar clave 2: " + diccionarioSimple.Recuperar(2));
        diccionarioSimple.Eliminar(2);
        System.out.println("Recuperar clave 2 después de eliminar: " + diccionarioSimple.Recuperar(2));
        System.out.print("Claves en diccionario simple: ");
        ConjuntoTDA clavesSimple = diccionarioSimple.Claves();
        while (!clavesSimple.conjuntoVacio()) {
            int clave = clavesSimple.elegir();
            System.out.print(clave + " ");
            clavesSimple.sacar(clave);
        }
        System.out.println();

        // Prueba de Diccionario Múltiple
        System.out.println("\n---- Prueba de Diccionario Múltiple ----");
        DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultipleTDAImpl();
        diccionarioMultiple.inicializarDiccionario();
        diccionarioMultiple.agregar(1, 100);
        diccionarioMultiple.agregar(1, 150);
        diccionarioMultiple.agregar(2, 200);
        diccionarioMultiple.agregar(3, 300);
        System.out.print("Valores de clave 1: ");
        ConjuntoTDA valoresClave1 = diccionarioMultiple.recuperar(1);
        while (!valoresClave1.conjuntoVacio()) {
            int valor = valoresClave1.elegir();
            System.out.print(valor + " ");
            valoresClave1.sacar(valor);
        }
        System.out.println();

        diccionarioMultiple.eliminarValor(1, 150);
        System.out.print("Valores de clave 1 después de eliminar 150: ");
        valoresClave1 = diccionarioMultiple.recuperar(1);
        while (!valoresClave1.conjuntoVacio()) {
            int valor = valoresClave1.elegir();
            System.out.print(valor + " ");
            valoresClave1.sacar(valor);
        }
        System.out.println();

        System.out.print("Claves en diccionario múltiple: ");
        ConjuntoTDA clavesMultiple = diccionarioMultiple.claves();
        while (!clavesMultiple.conjuntoVacio()) {
            int clave = clavesMultiple.elegir();
            System.out.print(clave + " ");
            clavesMultiple.sacar(clave);
        }
        System.out.println();

        // Prueba de Cola con Prioridad
        System.out.println("\n---- Prueba de Cola con Prioridad ----");
        ColaPrioridadTDAImpl colaPrioridad = new ColaPrioridadTDAImpl();
        colaPrioridad.inicializarCola();
        colaPrioridad.acolarPrioridad(10, 2);
        colaPrioridad.acolarPrioridad(20, 1);
        colaPrioridad.acolarPrioridad(30, 3);
        System.out.println("Primero en cola con prioridad: " + colaPrioridad.primero());
        System.out.println("Prioridad del primero: " + colaPrioridad.prioridad());
        colaPrioridad.desacolar();
        System.out.println("Primero después de desacolar: " + colaPrioridad.primero());
        System.out.println("Cola con prioridad vacía: " + colaPrioridad.colaVacia());
    }
}
