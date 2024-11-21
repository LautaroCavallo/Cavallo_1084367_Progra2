package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.DiccionarioSimpleTDA;

import static impl.MetodosExternosConjunto.copiarConjunto;
import static impl.MetodosExternosConjunto.obtenerValoresComunes;

public class MetodosExternosDiccionario {

    // 5.1) Generar un DiccionarioMultipleTDA a partir de dos DiccionarioMultipleTDA D1 y D2

    // a) Las claves presentes en D1 y D2, con todos los elementos asociados a cada clave
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static DiccionarioMultipleTDA unionDiccionarios(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleTDAImpl();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = D1.claves();
        ConjuntoTDA clavesD2 = D2.claves();

        agregarElementosDeDiccionario(resultado, D1, copiarConjunto(clavesD1));
        agregarElementosDeDiccionario(resultado, D2, copiarConjunto(clavesD2));

        return resultado;
    }

    // b) Las claves presentes en D1 y D2, con todos los elementos comunes a las claves coincidentes en ambos
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static DiccionarioMultipleTDA interseccionValoresComunes(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleTDAImpl();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = copiarConjunto(D1.claves());

        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            clavesD1.sacar(clave);
            if (D2.claves().pertenece(clave)) {
                ConjuntoTDA valoresD1 = copiarConjunto(D1.recuperar(clave));
                ConjuntoTDA valoresD2 = copiarConjunto(D2.recuperar(clave));
                ConjuntoTDA valoresComunes = obtenerValoresComunes(valoresD1, valoresD2);
                if (!valoresComunes.conjuntoVacio()) {
                    agregarValoresAlResultado(resultado, clave, valoresComunes);
                }
            }
        }

        return resultado;
    }

    // c) Las claves comunes de D1 y D2, con todos los elementos asociados a cada clave
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static DiccionarioMultipleTDA clavesComunesUnionValores(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleTDAImpl();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = copiarConjunto(D1.claves());

        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            clavesD1.sacar(clave);
            if (D2.claves().pertenece(clave)) {
                ConjuntoTDA valoresD1 = copiarConjunto(D1.recuperar(clave));
                ConjuntoTDA valoresD2 = copiarConjunto(D2.recuperar(clave));
                agregarValoresAlResultado(resultado, clave, valoresD1);
                agregarValoresAlResultado(resultado, clave, valoresD2);
            }
        }

        return resultado;
    }

    // d) Las claves comunes de D1 y D2, con todos los elementos comunes a las claves coincidentes en ambos
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    public static DiccionarioMultipleTDA clavesComunesInterseccionValores(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleTDAImpl();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = copiarConjunto(D1.claves());

        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            clavesD1.sacar(clave);
            if (D2.claves().pertenece(clave)) {
                ConjuntoTDA valoresD1 = copiarConjunto(D1.recuperar(clave));
                ConjuntoTDA valoresD2 = copiarConjunto(D2.recuperar(clave));
                ConjuntoTDA valoresComunes = obtenerValoresComunes(valoresD1, valoresD2);
                if (!valoresComunes.conjuntoVacio()) {
                    agregarValoresAlResultado(resultado, clave, valoresComunes);
                }
            }
        }

        return resultado;
    }

    // 5.2) Generar un Diccionario Múltiple DS a partir de un Diccionario Simple D
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static DiccionarioMultipleTDA generarDiccionarioSinonimos(DiccionarioSimpleTDA diccionarioSimple) {
        DiccionarioMultipleTDA diccionarioSinonimos = new DiccionarioMultipleTDAImpl();
        diccionarioSinonimos.inicializarDiccionario();

        ConjuntoTDA claves = diccionarioSimple.Claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            int significado = diccionarioSimple.Recuperar(clave);

            diccionarioSinonimos.agregar(significado, clave);
            claves.sacar(clave);
        }

        return diccionarioSinonimos;
    }

    // Metodo auxiliar para imprimir el contenido de un diccionario múltiple
    // Costo Espacial: O(n), Costo Temporal: O(n)
    public static void imprimirDiccionarioMultiple(DiccionarioMultipleTDA diccionario) {
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

    // Métodos auxiliares
    // Costo Espacial: O(n), Costo Temporal: O(n^2)
    private static void agregarElementosDeDiccionario(DiccionarioMultipleTDA resultado, DiccionarioMultipleTDA diccionario, ConjuntoTDA claves) {
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);
            ConjuntoTDA valores = copiarConjunto(diccionario.recuperar(clave));
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                valores.sacar(valor);
                resultado.agregar(clave, valor);
            }
        }
    }


    // Costo Espacial: O(n), Costo Temporal: O(n)
    private static void agregarValoresAlResultado(DiccionarioMultipleTDA resultado, int clave, ConjuntoTDA valores) {
        ConjuntoTDA copiaValores = copiarConjunto(valores);
        while (!copiaValores.conjuntoVacio()) {
            int valor = copiaValores.elegir();
            copiaValores.sacar(valor);
            resultado.agregar(clave, valor);
        }
    }

}
