package fes.aragon.ordenamiento;

import fes.aragon.lista.simple.ListaSimple;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Bruno
 */
public class MetodosOrdenamiento {

    /**
     * Meotodo De Ordenamiento Seleccion Este metedo va a buscar el elemento
     * mas pequeño de nuestra lista y lo colocalara en la primera posicion
     * repitiendo el proceso con el segundo, tercer y lista.getLongitud-1
     * 
     * Complejidad:O(n2)
     *
     * @param lista - Este metodo recibe una Lista Simple
     */
    public static void seleccion(ListaSimple lista) {
        int min = 0;
        for (int i = 0; i < lista.getLongitud(); i++) {
            min = i;
            for (int j = i + 1; j < lista.getLongitud(); j++) {
                if ((Integer) lista.obtenerNodo(j) < (Integer) lista.obtenerNodo(min)) {
                    min = j;
                }
            }
            if (i != min) {
                Object tmp = lista.obtenerNodo(i);
                lista.insertarEnIndice(lista.obtenerNodo(min), i);
                lista.insertarEnIndice(tmp, min);
            }
        }
    }

    /**
     * Meotodo De Ordenamiento Seleccion Este metedo va a buscar el elemento
     * mas pequeño de nuestra lista y lo colocalara en la primera posicion
     * repitiendo el proceso con el segundo, tercer y lista.getLongitud-1
     * 
     * Complejidad:O(n2)
     *
     * @param lista - Este metodo recibe una Lista Simple
     * @param lamina - Este metodo recibe un JPanel
     */
    public static void seleccion(ListaSimple lista, JPanel lamina) {
        int min = 0;
        for (int i = 0; i < lista.getLongitud(); i++) {
            min = i;
            for (int j = i + 1; j < lista.getLongitud(); j++) {
                if ((Integer) lista.obtenerNodo(j) < (Integer) lista.obtenerNodo(min)) {
                    min = j;
                }
            }
            if (i != min) {
                Object tmp = lista.obtenerNodo(i);
                lista.insertarEnIndice(lista.obtenerNodo(min), i);
                lista.insertarEnIndice(tmp, min);
            }
            lamina.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Meotodo De Ordenamiento Burbuja Este metodo va a comparar pares de 
     * elementos adyacentes en la lista y si estan desordenados los va a 
     * intercambiar
     * 
     * Complejidad: O(n2)
     *
     * @param lista - Este metodo recibe una Lista Simple
     */
    public static void burbuja(ListaSimple lista) {
        for (int i = 1; i < lista.getLongitud(); i++) {
            for (int j = 0; j < lista.getLongitud() - i; j++) {
                if ((Integer) lista.obtenerNodo(j) > (Integer) lista.obtenerNodo(j + 1)) {
                    Object tmp = lista.obtenerNodo(j);
                    lista.insertarEnIndice(lista.obtenerNodo(j + 1), j);
                    lista.insertarEnIndice(tmp, j + 1);
                }
            }
        }
    }

    /**
     * Meotodo De Ordenamiento Burbuja Este metodo va a comparar pares de 
     * elementos adyacentes en la lista y si estan desordenados los va a 
     * intercambiar
     * 
     * Complejidad: O(n2)
     *
     * @param lista - Este metodo recibe una Lista Simple
     * @param lamina - Este metodo recibe un JPanel
     */
    public static void burbuja(ListaSimple lista, JPanel lamina) {
        for (int i = 1; i < lista.getLongitud(); i++) {
            for (int j = 0; j < lista.getLongitud() - i; j++) {
                if ((Integer) lista.obtenerNodo(j) > (Integer) lista.obtenerNodo(j + 1)) {
                    Object tmp = lista.obtenerNodo(j);
                    lista.insertarEnIndice(lista.obtenerNodo(j + 1), j);
                    lista.insertarEnIndice(tmp, j + 1);
                    lamina.repaint();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
    
    /**
     * Metodo De Ordenamiento Inserccion. Este metodo va ir comparando un dato 
     * izquierdo con el derecho. Si el de la derecha es menor al de la izquierda
     * se intercambian 
     * 
     * Complejidad: Depende de la distribucion de datos
     * Datos en mayor cantidad : O(n)
     * Datos en menor canitdad : O(n2)
     * 
     * @param lista - Este metodo recibe una Lista Simple
     */
    public static void inserccion(ListaSimple lista){ 
        int j;
        int aux;
        for (int i = 1; i < lista.getLongitud(); i++) {
            aux = (Integer) lista.obtenerNodo(i);
            j = i - 1;
            while ((j >= 0) && ( aux < (Integer) lista.obtenerNodo(j))) {
                Object tmp = lista.obtenerNodo(j);             
                lista.insertarEnIndice(lista.obtenerNodo(j+1), j);
                lista.insertarEnIndice(tmp, j+1);                  
                j--;
            }
        }
    }
    
    /**
     * Metodo De Ordenamiento Inserccion. Este metodo va ir comparando un dato 
     * izquierdo con el derecho. Si el de la derecha es menor al de la izquierda
     * se intercambian 
     * 
     * Complejidad: Depende de la distribucion de datos
     * Datos en mayor cantidad : O(n)
     * Datos en menor canitdad : O(n2)
     * 
     * @param lista - Este metodo recibe una Lista Simple
     * @param lamina - Este metodo recibe un JPanel
     */
    public static void inserccion(ListaSimple lista, JPanel lamina){ 
        int j;
        int aux;
        for (int i = 1; i < lista.getLongitud(); i++) {
            aux = (Integer) lista.obtenerNodo(i);
            j = i - 1;
            while ((j >= 0) && ( aux < (Integer) lista.obtenerNodo(j))) {
                try {
                    Object tmp = lista.obtenerNodo(j);
                    lista.insertarEnIndice(lista.obtenerNodo(j+1), j);
                    lista.insertarEnIndice(tmp, j+1);
                    j--;
                    lamina.repaint();
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }    
    
    /**
     * Metodo De Ordenamiento QuickSort. Este metodo consiste en usar un elemento
     * como pivote que estara en medio de la lista o en alguna posicion de esta.
     * Tendremos dos variables de tipo contador al final (j) y al inicio (i) de la lista
     * y hacemos comparaciones respecto al pivote. Si i es menor o igual al pivote
     * aumenta i. Si j es mayor al pivote disminuye j y si i es menor a j cambialos
     * hasta ordenar la lista
     * 
     * @param lista - Este metodo recibe una Lista Simple
     * @param primero - Este metodo recibe un contador en la posicion 0
     * @param ultimo - Este metodo recibe un contador en la posicion getLongitud-1
     * 
     * Complejidad: O(n2)
     */
    public static void quicksort(ListaSimple lista, int primero, int ultimo) {
        int i, j, tmp;
        int central = (primero + ultimo) / 2;
        int pivote = (Integer) lista.obtenerNodo(central);
        i = primero;
        j = ultimo;
        while (i <= j) {
            while ((Integer) lista.obtenerNodo(i) < pivote) {
                i++;
            }
            while ((Integer) lista.obtenerNodo(j) > pivote) {
                j--;
            }
            if (i <= j) {
                tmp = (Integer) lista.obtenerNodo(i);
                lista.insertarEnIndice(lista.obtenerNodo(j), i);
                lista.insertarEnIndice(tmp, j);
                i++;
                j--;
            }
        }
        if (primero < j) {
            quicksort(lista, primero, j);
        }
        if (i < ultimo) {
            quicksort(lista, i, ultimo);
        }
    }
    
     /**
     * Metodo De Ordenamiento QuickSort. Este metodo consiste en usar un elemento
     * como pivote que estara en medio de la lista o en alguna posicion de esta.
     * Tendremos dos variables de tipo contador al final (j) y al inicio (i) de la lista
     * y hacemos comparaciones respecto al pivote. Si i es menor o igual al pivote
     * aumenta i. Si j es mayor al pivote disminuye j y si i es menor a j cambialos
     * hasta ordenar la lista
     * 
     * @param lista - Este metodo recibe una Lista Simple
     * @param primero - Este metodo recibe un contador en la posicion 0
     * @param ultimo - Este metodo recibe un contador en la posicion getLongitud-1
     * @param lamina - Este metodo recibe un JFrame
     * 
     * Complejidad: O(n2)
     */
    public static void quicksort(ListaSimple lista, int primero, int ultimo, JPanel lamina) {
        int i, j, tmp;
        int central = (primero + ultimo) / 2;
        int pivote = (Integer) lista.obtenerNodo(central);
        i = primero;
        j = ultimo;
        while (i <= j) {
            lamina.repaint();
            while ((Integer) lista.obtenerNodo(i) < pivote) {
                i++;
                lamina.repaint();
            }
            while ((Integer) lista.obtenerNodo(j) > pivote) {      
                j--;
                lamina.repaint();
            }
            if (i <= j) {
                tmp = (Integer) lista.obtenerNodo(i);
                lista.insertarEnIndice(lista.obtenerNodo(j), i);
                lista.insertarEnIndice(tmp, j);
                i++;
                j--;
                lamina.repaint();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (primero < j) {
            quicksort(lista, primero, j);
            lamina.repaint();
        }
        if (i < ultimo) {
            quicksort(lista, i, ultimo);
            lamina.repaint();
        }
    }
      
}
