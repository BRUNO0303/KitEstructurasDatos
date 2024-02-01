package fes.aragon.inter;

/**
 *
 * @author Bruno
 */
public interface Pila<E> {

    void borrar();

    boolean estaVacia();

    void insertar(E dato);

    E extraer();

    E elementoSuperior();
}
