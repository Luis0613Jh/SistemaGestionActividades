
package controlador.listaSimple;

public class Nodo {
    public Object objeto;
    public Nodo siguiente;
    
    public Nodo() {
        this.objeto = null;
        this.siguiente = null;
    }
    
    public Nodo(Object objeto) {
        this.objeto = objeto;
        this.siguiente = null;
    }
    
    public Nodo(Object objeto, Nodo siguiente) {
        this.objeto = objeto;
        this.siguiente = siguiente;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
