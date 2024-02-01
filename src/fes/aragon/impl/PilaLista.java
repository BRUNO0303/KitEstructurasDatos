package fes.aragon.impl;

import fes.aragon.inter.Pila;
import fes.aragon.lista.simple.ListaSimple;

/**
 *
 * @author Bruno
 */
public class PilaLista<E> implements Pila<E> {

    private ListaSimple pila = new ListaSimple();

    @Override
    public void borrar() {
        pila = new ListaSimple();
    }

    @Override
    public boolean estaVacia() {
        return pila.esVacia();
    }

    @Override
    public void insertar(E dato) {
        pila.agregarEnCabeza(dato);
    }

    @Override
    public E extraer() {
        return (E) pila.eliminarEnCabeza();
    }

    @Override
    public E elementoSuperior() {
        Object tmp = pila.eliminarEnCabeza();
        pila.agregarEnCabeza(tmp);
        return (E) tmp;
    }

}
