
package controlador.cola;

public class NodoCola {
    
    public Object objeto;
    public NodoCola siguiente;
    
    public NodoCola() {
        this.objeto = null;
        this.siguiente=null;
    }
    
    public NodoCola(Object dato, NodoCola siguiente) {
        this.objeto = dato;
        this.siguiente = siguiente;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}
