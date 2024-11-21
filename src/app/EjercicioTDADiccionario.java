package app;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import impl.DiccionarioSimpleTDAImpl;

public class EjercicioTDADiccionario {

    public int contarElementos(DiccionarioSimpleTDA diccionario) {
        ConjuntoTDA claves = diccionario.Claves();
        int contador = 0;

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);
            contador++;
        }

        return contador;
    }

    public void mostrarClaves(DiccionarioSimpleTDA diccionario) {
        ConjuntoTDA claves = diccionario.Claves();

        System.out.print("Claves en el diccionario: ");
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.print(clave + " ");
            claves.sacar(clave);
        }
        System.out.println();
    }

    public void mostrarDiccionario(DiccionarioSimpleTDA diccionario) {
        ConjuntoTDA claves = diccionario.Claves();

        System.out.println("Diccionario (clave - valor):");
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            int valor = diccionario.Recuperar(clave);
            System.out.println(clave + " - " + valor);
            claves.sacar(clave);
        }
    }

    public static void main(String[] args) {
        EjercicioTDADiccionario ejercicioTDADiccionario = new EjercicioTDADiccionario();

        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleTDAImpl();
        diccionario.InicializarDiccionario();

        diccionario.agregar(1,1);
        diccionario.agregar(2,1);
        diccionario.agregar(3,1);

        ejercicioTDADiccionario.mostrarDiccionario(diccionario);

        System.out.println("Cantidad de elementos en el diccionario: " + ejercicioTDADiccionario.contarElementos(diccionario));

        System.out.println("Valor asociado a la clave 2: " + diccionario.Recuperar(2));

        diccionario.Eliminar(2);
        System.out.println("Diccionario después de eliminar la clave 2:");
        ejercicioTDADiccionario.mostrarDiccionario(diccionario);

        ejercicioTDADiccionario.mostrarClaves(diccionario);
    }
}
