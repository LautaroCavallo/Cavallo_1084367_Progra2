package app;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.ConjuntoTDAImpl;
import impl.DiccionarioMultipleTDAImpl;

public class EjercicioTDADiccionarioMultiple {

    public int contarValores(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();
        int contador = 0;

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            ConjuntoTDA valores = copiarConjunto(diccionario.recuperar(clave));
            while (!valores.conjuntoVacio()) {
                valores.sacar(valores.elegir());
                contador++;
            }
            claves.sacar(clave);
        }

        return contador;
    }

    public void mostrarDiccionario(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();
        System.out.println("Diccionario Múltiple (clave - valores):");

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            ConjuntoTDA valores = copiarConjunto(diccionario.recuperar(clave));
            System.out.print(clave + " - ");
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                System.out.print(valor + " ");
                valores.sacar(valor);
            }
            System.out.println();
            claves.sacar(clave);
        }
    }

    private ConjuntoTDA copiarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA copia = new ConjuntoTDAImpl();
        copia.inicializarConjunto();

        ConjuntoTDA auxiliar = new ConjuntoTDAImpl();
        auxiliar.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            copia.agregar(elemento);
            auxiliar.agregar(elemento);
            conjunto.sacar(elemento);
        }

        while (!auxiliar.conjuntoVacio()) {
            int elemento = auxiliar.elegir();
            conjunto.agregar(elemento);
            auxiliar.sacar(elemento);
        }

        return copia;
    }

    public static void main(String[] args) {
        EjercicioTDADiccionarioMultiple ejercicioTDADiccionarioMultiple = new EjercicioTDADiccionarioMultiple();

        DiccionarioMultipleTDA diccionario = new DiccionarioMultipleTDAImpl();
        diccionario.inicializarDiccionario();

        diccionario.agregar(1, 100);
        diccionario.agregar(1, 150);
        diccionario.agregar(2, 200);
        diccionario.agregar(3, 300);
        diccionario.agregar(3, 350);

        System.out.println("Diccionario después de agregar valores:");
        ejercicioTDADiccionarioMultiple.mostrarDiccionario(diccionario);

        System.out.println("Cantidad total de valores en el diccionario: " + ejercicioTDADiccionarioMultiple.contarValores(diccionario));

        ConjuntoTDA valoresClave1 = ejercicioTDADiccionarioMultiple.copiarConjunto(diccionario.recuperar(1));
        System.out.print("Valores asociados a la clave 1: ");
        while (!valoresClave1.conjuntoVacio()) {
            int valor = valoresClave1.elegir();
            System.out.print(valor + " ");
            valoresClave1.sacar(valor);
        }
        System.out.println();

        diccionario.eliminarValor(3, 300);
        System.out.println("Diccionario después de eliminar el valor 300 de la clave 3:");
        ejercicioTDADiccionarioMultiple.mostrarDiccionario(diccionario);
    }
}
