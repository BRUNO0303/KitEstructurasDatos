package fes.aragon.lista.doble;

/**
 * Clase ListaDoble: Esta clase almacenara datos en forma de lista 
 * @author Bruno Hernandez Hernandez - Universidad Nacional Autonoma De México
 * @param <E> - Esta Clase puede aceptar cualquier tipo de parametro permitido por la 
 * variable de tipo Object 
 */
public class ListaDoble<E> {

    private NodoDoble cabeza;
    private NodoDoble cola;
    private int longitud;

    //Inicializamos valores (Constructor) 
    public ListaDoble() {
        cabeza = cola = null;
    }

    /**
     * Metodo: Verifica si la lista esta vacia
     *
     * @return Un true en caso de que nuestra lista este vacia. De lo contrario
     * es false.
     */
    public boolean estaVacia() {
        return cabeza == null; 
    }

    /**
     * Metodo: Agregar los elementos al final de la lista
     *
     * @param dato Valor del elemento que queremos agregar al final de nuestra
     * lista. Siempre debe ser el mismo tipo del valor ingresado: E.
     */
    public void agregarEnCola(E dato) {
        if (!estaVacia()) {
            cola = new NodoDoble(dato, null, cola);
            cola.anterior.siguiente = cola;
        } else {
            cabeza = cola = new NodoDoble(dato);
        }
        longitud++;
    }

    /**
     * Metodo: Elimina los elementos al final de la lista
     *
     * @return Puede regresar un true en caso de que el elemento sea borrado. De
     * lo contrario regresa un false.
     */
    public boolean eliminarEnCola() {
        Object dato = null;
        if (cola != null) {
            dato = cola.getDato();
            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                NodoDoble tmp;
                for (tmp = cabeza; tmp.getSiguiente() != cola; tmp = tmp.getSiguiente());
                cola = tmp;
                cola.setSiguiente(null);
            }
            longitud--;
        }
        return false;
    }

    /**
     * Metodo: Agrega los elementos al inicio de la lista.
     *
     * @param dato Valor del elemento que queremos agregar al inicio de nuestra
     * lista. Siempre debe ser el mismo tipo del valor ingresado: E.
     */
    public void agregarEnCabeza(E dato) {
        if (!estaVacia()) {
            cabeza = new NodoDoble(dato, cabeza, null);
            cabeza.siguiente.anterior = cabeza;
        } else {
            cabeza = cola = new NodoDoble(dato);
        }
        longitud++;
    }

    /**
     * Metodo: Elimina los elementos al inicio de la lista
     *
     * @return Puede regresar un true en caso de que el elemento sea borrado. De
     * lo contrario regresa un false.
     */
    public boolean eliminarEnCabeza() {
        Object dato = null;
        if (cabeza != null) { //Si cabeza tiene un dato
            dato = cabeza.getDato();
            if (cabeza == cola) {//Si solo hay un elemento:
                cabeza = cola = null; //cambialos a null
            } else {
                cabeza = cabeza.getSiguiente();
            }
            longitud--;
        }
        return false;
    }

    /**
     * Metodo: Elimina cualquier elemento de la lista. Siempre y cuando el
     * elemento se encuentre en ella.
     *
     * @param dato Valor del elemento que queremos agregar al inicio de nuestra
     * lista. Siempre debe ser el mismo tipo del valor ingresado: E.
     * @return Puede regresar un true en caso de que el elemento sea borrado. De
     * lo contrario regresa un false.
     */
    public boolean eliminaEnDato(E dato) {
        boolean borrado = false;
        if (cabeza != null) {
            if (cabeza == cola && dato.equals(cabeza.getDato())) {
                cabeza = cola = null;
                borrado = true;
                longitud--;
            } else if (dato == cabeza.getDato()) {
                cabeza = cabeza.getSiguiente();
                borrado = true;
                longitud--;
            } else {
                NodoDoble prd, tmp;
                for (prd = cabeza, tmp = cabeza.getSiguiente();
                        tmp != null && !tmp.getDato().equals(dato);
                        prd = prd.getSiguiente(), tmp = tmp.getSiguiente());
                if (tmp != null) {
                    borrado = true;
                    longitud--;
                    prd.setSiguiente(tmp.getSiguiente());
                    if (tmp == cola) {
                        cola = prd;
                    }
                }
            }
        }
        return borrado;
    }

    /**
     * Metodo: Se ingresa el indice y borra el elemento que se encuentra en
     * este.
     *
     * @param indice Este es el indice de 0 a longitud-1. Solo acepta tipo
     * entero.
     * @return Puede regresar un true en caso de que el indice sea borrado. De
     * lo contrario regresa un false.
     */
    public boolean eliminaEnIndice(int indice) {
        boolean borrado = false;
        if (indice <= longitud) {
            if (cabeza != null) {
                if (cabeza == cola && indice == 0) {
                    cabeza = cola = null;
                    borrado = true;
                    longitud--;
                } else if (indice == 0) {
                    cabeza = cabeza.getSiguiente();
                    borrado = true;
                    longitud--;
                } else {
                    NodoDoble prd, tmp;
                    int contador = 1;
                    for (prd = cabeza, tmp = cabeza.getSiguiente();
                            contador < indice;
                            prd = prd.getSiguiente(), tmp = tmp.getSiguiente(), contador++);
                    if (tmp != null) {
                        borrado = true;
                        longitud--;
                        prd.setSiguiente(tmp.getSiguiente());
                        if (tmp == cola) {
                            cola = prd;
                        }
                    }
                }
            }
        }
        return borrado;
    }

    /**
     * Metodo: Limpia todo elemento existente en nuestra lista
     */
    public void eliminarLista() {
        if (!estaVacia()) {
            cola = cabeza = null;
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    /**
     * Metodo: Busca el elemento ingresado
     *
     * @param dato Valor del elemento que queremos agregar al inicio de nuestra
     * lista. Siempre debe ser el mismo tipo del valor ingresado: E.
     * @return Puede regresar un true en caso de que el dato sea encontrado. De
     * lo contrario regresa un false.
     */
    public boolean buscaDato(E dato) {
        NodoDoble tmp;
        for (tmp = cabeza; tmp != null && !tmp.getDato().equals(dato); tmp = tmp.getSiguiente());
        return tmp != null;
    }

    /**
     * Metodo: Ingresamos el indice del elemento deseado y nos muestra el
     * elemento dentro de este.
     *
     * @param indice Este es el indice de 0 a longitud-1. Solo acepta tipo
     * entero.
     * @return Puede regresar un true en caso de que el indice sea encontrado.
     * De lo contrario regresa un false.
     */
    public Object obtenerNodo(int indice) {
        NodoDoble tmp = null;
        if (indice <= longitud) {
            tmp = cabeza;
            for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente());
        }
        if (longitud == 0 || indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("No existe el indice: " + indice);
        }        
        if (tmp != null) {
            return tmp.getDato();
        } else {
            return null;
        }
    }

    /**
     * Metodo: Ingresamos el elemento nuevo junto al indice y nos remueve el
     * elemento que se econtraba anteriormente
     *
     * @param dato Valor del elemento que queremos agregar al inicio de nuestra
     * lista. Siempre debe ser el mismo tipo del valor ingresado: E.
     * @param indice Este es el indice de 0 a longitud-1. Solo acepta tipo
     * entero.
     * @return Puede regresar un true en caso de que el indice sea encontrado.
     * De lo contrario regresa un false.
     */
    public boolean insertarElementoRemoviendo(E dato, int indice) {
        NodoDoble tmp = null;
        if (indice <= longitud) {
            tmp = cabeza;
            for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente());
        }
        if (longitud == 0 || indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("No existe el indice: " + indice);
        }
        if (tmp != null) {
            tmp.setDato(dato);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo: Ingresamos el elemento nuevo junto al indice y nos recorre el
     * elemento que se encontraba anteriormente a la derecha (+1)
     *
     * @param dato Valor del elemento que queremos agregar al inicio de nuestra
     * lista. Siempre debe ser el mismo tipo del valor ingresado: E.
     * @param indice Este es el indice de 0 a longitud-1. Solo acepta tipo
     * entero.
     */
    public void insertarElementoRecorriendo(E dato, int indice) {
        if (indice == 0) {
            agregarEnCabeza(dato);
            longitud++;
        } else if (indice == longitud - 1) {
            agregarEnCola(dato);
            longitud++;
        } else {
            NodoDoble posi = recorreLista(indice);
            NodoDoble nuevo = new NodoDoble(dato, posi, posi.anterior);
            posi.anterior.siguiente = nuevo;
            posi.anterior = nuevo;
            longitud++;
        }
    }

    /**
     * Metodo: Imprime en consola los elementos de orden: inicio a fin
     */
    public void imprimirListaIF() {
        if (!estaVacia()) {
            for (NodoDoble tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                System.out.println(tmp.getDato());
            }
        }
    }

    /**
     * Metodo: Imprime en consola los elementos de orden: fin a inicio
     */
    public void imprimirListaFI() {
        if (!estaVacia()) {
            for (NodoDoble tmp = cola; tmp != null; tmp = tmp.getAnterior()) {
                System.out.println(tmp.getDato());
            }
        }
    }

    /**
     * Metodo: Nos da el tamaño de nuestra lista
     *
     * @return Regresa un entero del tamaño actual de nuestra lista.
     */
    public int tamaño() {
        return longitud;
    }

    /**
     * Metodo Auxiliar para recorrer la lista
     *
     * @param indice Este es el indice de 0 a longitud-1. Solo acepta tipo
     * entero.
     */
    private NodoDoble recorreLista(int indice) {
        if (longitud == 0 || indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("No existe el indice");
        }
        int media = longitud / 2;
        NodoDoble tmp = null;
        if (indice <= media) {
            tmp = cabeza;
            for (int i = 0; i < indice; i++) {
                tmp = tmp.siguiente;
            }
        } else {
            tmp = cola;
            for (int i = longitud - 1; i < indice; i--) {
                tmp = tmp.anterior;
            }
        }
        return tmp;
    }
}
