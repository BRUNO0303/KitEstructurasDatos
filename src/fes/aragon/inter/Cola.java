package fes.aragon.inter;

/**
 *
 * @author Bruno
 */
public interface Cola<E> {

    void borrar();

    boolean estaVacia();

    void insertar(E dato);

    E extraer();

    E elementoSuperior();
}
