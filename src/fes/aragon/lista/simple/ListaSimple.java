package fes.aragon.lista.simple;

/**
 * Clase ListaSimple: Esta clase almacenara cualquier tipo de dato
 * @author Bruno Hernandez Hernandez
 * Univseridad Nacional Autonoma De México 
 * Facultad De Estudios Superiores Aragon
 */

public class ListaSimple { //Las listas son agrupaciones de Nodos. Con dos nodos especialez; Cabeza y Cola
   private Nodo cabeza;
   private Nodo cola;
   protected int longitud=0;
   
   public ListaSimple(){
       cabeza=cola=null; //Cabeza y Cola valen Null
   }
   //Metodo para ver si esta vacia 
   public boolean esVacia(){
       return cabeza==null;
   }
   //Metodo para agregar en cabeza
   public void agregarEnCabeza(Object dato){
       cabeza=new Nodo(dato,cabeza);//Crea el objeto y regresa la diereccion 
       if(cola==null){
           cola=cabeza;
       }
       longitud++;
   }
   //Metodo agrega en Cola
   public void agregarEnCola(Object dato){
       Nodo n = new Nodo(dato);
       if(cabeza==null){
           cabeza= cola = new Nodo(dato);
           //cabeza=cola;
       }else{
           cola.setSiguiente(new Nodo(dato));
           cola=cola.getSiguiente();
       }
       longitud++;
   }
   
   public Object eliminarEnCabeza(){
       Object dato=0;
       if(cabeza!=null){ //Si cabeza tiene un dato
           dato=cabeza.getDato();
           if(cabeza==cola){//Si solo hay un elemento:
               cabeza=cola=null; //cambialos a null
           }else{
               cabeza=cabeza.getSiguiente();
           }
           longitud--;
       }
       return dato;
   }
   
   public Object eliminarEnCola(){
       Object dato=null;
       if(cola!=null){
           dato=cola.getDato();
           if(cabeza==cola){
               cabeza=cola=null;
           }else{
               Nodo tmp;
               for(tmp=cabeza; tmp.getSiguiente()!=cola; tmp=tmp.getSiguiente());
               cola=tmp;
               cola.setSiguiente(null);
           }
           longitud--;
       }
       return dato;
   }
   
   public boolean eliminaEnDato(Object dato){
        boolean borrado = false;
        if (cabeza != null) {
            if (cabeza == cola && dato.equals(cabeza.getDato()) ) {
                cabeza = cola = null;
                borrado = true;
                longitud--;
            } else if (dato == cabeza.getDato()) {
                cabeza = cabeza.getSiguiente();
                borrado = true;
                longitud--;
            } else {
                Nodo prd, tmp;
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
   
   public boolean buscaDato(Object dato){
    Nodo tmp;
    for(tmp=cabeza; tmp!=null && !tmp.getDato().equals(dato); tmp=tmp.getSiguiente());
    return tmp!=null;
   }
   
   public void imprimirElementos(){
       for(Nodo tmp=cabeza; tmp!=null; tmp=tmp.getSiguiente()){
           System.out.println(tmp.getDato());
       }
   }
   
    public Object obtenerNodo(int indice) {
        Nodo tmp = null;
        if (indice <= longitud) {
            tmp = cabeza;
            for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente());
        }
        if (tmp != null) {
            return tmp.getDato();
        } else {
            return null;
        }
    }
    
    public boolean insertarEnIndice(Object dato, int indice){
        Nodo tmp = null;
        if (indice <= longitud) {
            tmp = cabeza;
            for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente());
        }
        if (tmp != null) {
            tmp.setDato(dato);
            return true;
        } else {
            return false;
        }        
    }
    
   public boolean eliminaEnIndice(int indice){
        boolean borrado = false;
        if(indice<=longitud){
        if (cabeza != null) {
            if (cabeza == cola && indice==0) {
                cabeza = cola = null;
                borrado = true;
                longitud--;
            } else if (indice==0) {
                cabeza = cabeza.getSiguiente();
                borrado = true;
                longitud--;
            } else {
                Nodo prd, tmp;
                int contador=1;
                for (prd = cabeza, tmp = cabeza.getSiguiente();
                        contador<indice;
                        prd = prd.getSiguiente(), tmp = tmp.getSiguiente(),contador++);
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

    public int getLongitud() {
        return longitud;
    }
 
   
}
