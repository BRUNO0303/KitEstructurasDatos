package fes.aragon.impl;

import fes.aragon.inter.Cola;
import fes.aragon.lista.simple.ListaSimple;

/**
 *
 * @author Bruno
 */
public class ColaLista<E> implements Cola<E> {

    private ListaSimple cola = new ListaSimple();
    private int longitud = 10;

    //Constructor de longitud
    public ColaLista(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public void borrar() {
        cola = new ListaSimple();
    }

    @Override
    public boolean estaVacia() {
        return cola.esVacia();
    }

    @Override
    public void insertar(E dato) {
        if (cola.getLongitud() < longitud) {
            cola.agregarEnCola(dato);
        } else {
            System.out.println("Cola llena");
        }
    }

    @Override
    public E extraer() {
        return (E) cola.eliminarEnCabeza();
    }

    @Override
    public E elementoSuperior() {
        Object tmp = cola.eliminarEnCabeza();
        cola.agregarEnCabeza(tmp);
        return (E) tmp;
    }

    //Nuevos metodos    
    public void insertarAlInicio(E dato) {
        cola.agregarEnCabeza(dato);
    }

    public void imprimirCola() {
        cola.imprimirElementos();
    }

    public Object elementosCola(int indice) {
        return cola.obtenerNodo(indice);
    }

    //Setters and Getters
    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

}
