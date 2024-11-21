package impl;

import api.ColaPrioridadTDA;
import api.DiccionarioMultipleTDA;

public class MetodosExternosColaPrioridad {

    // a) Generar un Diccionario Múltiple con los valores y prioridades de una ColaPrioridad
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static DiccionarioMultipleTDA generarDiccionarioDesdeColaPrioridad(ColaPrioridadTDA C) {
        DiccionarioMultipleTDA diccionario = new DiccionarioMultipleTDAImpl();
        diccionario.inicializarDiccionario();

        ColaPrioridadTDA copiaCola = copiarColaPrioridad(C);

        while (!copiaCola.colaVacia()) {
            int valor = copiaCola.primero();
            int prioridad = copiaCola.prioridad();
            diccionario.agregar(valor, prioridad);
            copiaCola.desacolar();
        }

        return diccionario;
    }

    // Metodo auxiliar para copiar la ColaPrioridad sin modificar la original
    private static ColaPrioridadTDA copiarColaPrioridad(ColaPrioridadTDA original) {
        ColaPrioridadTDA copia = new ColaPrioridadTDAImpl();
        copia.inicializarCola();
        ColaPrioridadTDA auxiliar = new ColaPrioridadTDAImpl();
        auxiliar.inicializarCola();

        while (!original.colaVacia()) {
            int valor = original.primero();
            int prioridad = original.prioridad();
            original.desacolar();
            auxiliar.acolarPrioridad(valor, prioridad);
        }

        while (!auxiliar.colaVacia()) {
            int valor = auxiliar.primero();
            int prioridad = auxiliar.prioridad();
            auxiliar.desacolar();
            original.acolarPrioridad(valor, prioridad);
            copia.acolarPrioridad(valor, prioridad);
        }

        return copia;
    }
}
