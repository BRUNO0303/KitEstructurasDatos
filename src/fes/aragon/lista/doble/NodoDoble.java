package fes.aragon.lista.doble;

/**
 * Clase Nodo Doble
 * @author BRUNO HERNANDEZ HERNANDEZ UNIVERSIDAD NACIONAL AUTONOMA DE MÉXICO
 */
public class NodoDoble {

    private Object dato;
    protected NodoDoble siguiente;
    protected NodoDoble anterior;

    //Constructor cuando no hay nodos
    public NodoDoble(Object dato) {
        this(dato, null, null);
    }

    //Constructor cuando hay nodos
    public NodoDoble(Object dato, NodoDoble siguiente, NodoDoble anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

}
