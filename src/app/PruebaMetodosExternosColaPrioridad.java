package app;

import api.ColaPrioridadTDA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.MetodosExternosColaPrioridad;
import impl.ColaPrioridadTDAImpl;

public class PruebaMetodosExternosColaPrioridad {

    public static void main(String[] args) {
        // Crear una instancia de ColaPrioridadTDA
        ColaPrioridadTDA colaPrioridad = new ColaPrioridadTDAImpl();
        colaPrioridad.inicializarCola();

        // Agregar elementos a la cola con sus prioridades
        colaPrioridad.acolarPrioridad(5, 1);
        colaPrioridad.acolarPrioridad(3, 2);
        colaPrioridad.acolarPrioridad(7, 1);
        colaPrioridad.acolarPrioridad(5, 3);
        colaPrioridad.acolarPrioridad(3, 4);

        // Generar el diccionario múltiple a partir de la cola de prioridad
        DiccionarioMultipleTDA diccionario = MetodosExternosColaPrioridad.generarDiccionarioDesdeColaPrioridad(colaPrioridad);

        // Imprimir el diccionario múltiple
        imprimirDiccionario(diccionario);
    }

    // Metodo auxiliar para imprimir el contenido de un diccionario múltiple
    private static void imprimirDiccionario(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.print("Clave: " + clave + " -> Prioridades: ");
            ConjuntoTDA valores = diccionario.recuperar(clave);
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                System.out.print(valor + " ");
                valores.sacar(valor);
            }
            System.out.println();
            claves.sacar(clave);
        }
    }
}
