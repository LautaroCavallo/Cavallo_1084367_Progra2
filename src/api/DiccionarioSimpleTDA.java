package api;

public interface DiccionarioSimpleTDA {
    void InicializarDiccionario();
    void agregar(int clave, int valor);
    void Eliminar(int clave);
    int Recuperar(int clave);
    ConjuntoTDA Claves();
}
