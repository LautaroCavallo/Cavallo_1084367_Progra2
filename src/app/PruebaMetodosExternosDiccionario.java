package app;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.DiccionarioSimpleTDA;
import impl.MetodosExternosDiccionario;
import impl.DiccionarioMultipleTDAImpl;
import impl.DiccionarioSimpleTDAImpl;

import static impl.MetodosExternosDiccionario.generarDiccionarioSinonimos;

public class PruebaMetodosExternosDiccionario {

    public static void main(String[] args) {
        // Crear instancias de DiccionarioMultipleTDA para las pruebas
        DiccionarioMultipleTDA D1 = new DiccionarioMultipleTDAImpl();
        DiccionarioMultipleTDA D2 = new DiccionarioMultipleTDAImpl();
        D1.inicializarDiccionario();
        D2.inicializarDiccionario();

        // Agregar elementos a los diccionarios D1 y D2
        D1.agregar(1, 10);
        D1.agregar(1, 20);
        D1.agregar(2, 30);
        D1.agregar(3, 40);

        D2.agregar(1, 20);
        D2.agregar(1, 50);
        D2.agregar(2, 30);
        D2.agregar(4, 60);

        // 5.1) a) Prueba de unión de diccionarios
        DiccionarioMultipleTDA unionDiccionarios = MetodosExternosDiccionario.unionDiccionarios(D1, D2);
        System.out.println("Unión de D1 y D2:");
        imprimirDiccionarioMultiple(unionDiccionarios);

        // 5.1) b) Prueba de intersección de valores comunes
        DiccionarioMultipleTDA interseccionValoresComunes = MetodosExternosDiccionario.interseccionValoresComunes(D1, D2);
        System.out.println("Intersección de valores comunes de D1 y D2:");
        imprimirDiccionarioMultiple(interseccionValoresComunes);

        // 5.1) c) Prueba de claves comunes con unión de valores
        DiccionarioMultipleTDA clavesComunesUnionValores = MetodosExternosDiccionario.clavesComunesUnionValores(D1, D2);
        System.out.println("Claves comunes con unión de valores de D1 y D2:");
        imprimirDiccionarioMultiple(clavesComunesUnionValores);

        // 5.1) d) Prueba de claves comunes con intersección de valores
        DiccionarioMultipleTDA clavesComunesInterseccionValores = MetodosExternosDiccionario.clavesComunesInterseccionValores(D1, D2);
        System.out.println("Claves comunes con intersección de valores de D1 y D2:");
        imprimirDiccionarioMultiple(clavesComunesInterseccionValores);

        // 5.2) Prueba de generación de diccionario de sinónimos
        DiccionarioSimpleTDA diccionarioSimple = new DiccionarioSimpleTDAImpl();
        diccionarioSimple.InicializarDiccionario();
        diccionarioSimple.agregar(1, 100);
        diccionarioSimple.agregar(2, 200);
        diccionarioSimple.agregar(3, 100);
        diccionarioSimple.agregar(4, 300);

        DiccionarioMultipleTDA diccionarioSinonimos = generarDiccionarioSinonimos(diccionarioSimple);
        System.out.println("Diccionario de sinónimos generado a partir del Diccionario Simple:");
        imprimirDiccionarioMultiple(diccionarioSinonimos);
    }

    // Metodo auxiliar para imprimir el contenido de un diccionario múltiple
    private static void imprimirDiccionarioMultiple(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.print("Clave: " + clave + " -> Valores: ");
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
