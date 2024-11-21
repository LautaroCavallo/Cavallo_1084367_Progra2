package api;

public interface ABBTDA {
    void inicializarArbol();
    int raiz();
    ABBTDA hijoIzq();
    ABBTDA hijoDer();
    boolean arbolVacio();
    void agregarElem(int elem);
    void eliminarElem(int elem);
}