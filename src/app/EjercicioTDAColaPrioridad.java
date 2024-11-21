package app;

import api.ColaPrioridadTDA;
import impl.ColaPrioridadTDAImpl;

public class EjercicioTDAColaPrioridad {

    public static void main(String[] args) {
        EjercicioTDAColaPrioridad ejercicioTDAColaPrioridad = new EjercicioTDAColaPrioridad();

        ColaPrioridadTDA cola1 = new ColaPrioridadTDAImpl();
        cola1.inicializarCola();
        cola1.acolarPrioridad(10, 3);
        cola1.acolarPrioridad(20, 2);

        ColaPrioridadTDA cola2 = new ColaPrioridadTDAImpl();
        cola2.inicializarCola();
        cola2.acolarPrioridad(30, 3);
        cola2.acolarPrioridad(40, 1);

        ColaPrioridadTDA combinada = ejercicioTDAColaPrioridad.combinarColas(cola1, cola2);
        System.out.println("Cola combinada:");
        while (!combinada.colaVacia()) {
            System.out.println("Elemento: " + combinada.primero() + ", Prioridad: " + combinada.prioridad());
            combinada.desacolar();
        }

        while (!combinada.colaVacia()) {
            System.out.println("Elemento: " + combinada.primero() + ", Prioridad: " + combinada.prioridad());
            combinada.desacolar();
        }

        boolean sonIguales = ejercicioTDAColaPrioridad.sonIdenticas(cola1, cola2);
        System.out.println("\n¿Son idénticas las colas originales? " + sonIguales);

        ColaPrioridadTDA cola3 = new ColaPrioridadTDAImpl();
        cola3.inicializarCola();
        cola3.acolarPrioridad(10, 3);
        cola3.acolarPrioridad(20, 2);

        boolean sonIguales2 = ejercicioTDAColaPrioridad.sonIdenticas(cola1, cola3);
        System.out.println("\n¿Son idénticas cola1 y cola3? " + sonIguales2);
    }
    public ColaPrioridadTDA combinarColas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
        ColaPrioridadTDA combinada = new ColaPrioridadTDAImpl();
        combinada.inicializarCola();

        ColaPrioridadTDA respaldo1 = new ColaPrioridadTDAImpl();
        respaldo1.inicializarCola();
        ColaPrioridadTDA respaldo2 = new ColaPrioridadTDAImpl();
        respaldo2.inicializarCola();

        while (!cp1.colaVacia() || !cp2.colaVacia()) {
            if (!cp1.colaVacia() && (cp2.colaVacia() || cp1.prioridad() > cp2.prioridad())) {
                combinada.acolarPrioridad(cp1.primero(), cp1.prioridad());
                cp1.desacolar();
            } else if (!cp2.colaVacia() && (cp1.colaVacia() || cp1.prioridad() < cp2.prioridad())) {
                combinada.acolarPrioridad(cp2.primero(), cp2.prioridad());
                cp2.desacolar();
            } else { // Si las prioridades son iguales
                combinada.acolarPrioridad(cp1.primero(), cp1.prioridad());
                cp1.desacolar();
            }
        }

        return combinada;
    }


    public boolean sonIdenticas(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
        ColaPrioridadTDA auxiliar1 = new ColaPrioridadTDAImpl();
        auxiliar1.inicializarCola();
        ColaPrioridadTDA auxiliar2 = new ColaPrioridadTDAImpl();
        auxiliar2.inicializarCola();

        boolean iguales = true;

        while (!cola1.colaVacia() && !cola2.colaVacia()) {
            if (cola1.primero() != cola2.primero() || cola1.prioridad() != cola2.prioridad()) {
                iguales = false;
            }
            auxiliar1.acolarPrioridad(cola1.primero(), cola1.prioridad());
            auxiliar2.acolarPrioridad(cola2.primero(), cola2.prioridad());
            cola1.desacolar();
            cola2.desacolar();
        }

        if (!cola1.colaVacia() || !cola2.colaVacia()) {
            iguales = false;
        }

        while (!auxiliar1.colaVacia()) {
            cola1.acolarPrioridad(auxiliar1.primero(), auxiliar1.prioridad());
            auxiliar1.desacolar();
        }

        while (!auxiliar2.colaVacia()) {
            cola2.acolarPrioridad(auxiliar2.primero(), auxiliar2.prioridad());
            auxiliar2.desacolar();
        }

        return iguales;
    }
}
