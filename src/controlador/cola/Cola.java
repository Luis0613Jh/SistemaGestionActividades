package controlador.cola;

import javax.swing.JOptionPane;

public class Cola {

    private NodoCola cabecera;

    public Cola() {
        cabecera = null;
    }

    public NodoCola getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoCola cabecera) {
        this.cabecera = cabecera;
    }

    public void queue(Object objeto) {
        NodoCola temporal = new NodoCola(objeto, null);
        if (estaVacio()) {
            temporal.setSiguiente(cabecera);
            cabecera = temporal;
        } else {
            NodoCola primero = cabecera;
            NodoCola siguiente = cabecera.getSiguiente();
            while (siguiente != null) {
                primero = siguiente;
                siguiente = siguiente.getSiguiente();
            }
            if (siguiente == null) {
                primero.setSiguiente(temporal);
            }
        }
    }

    public Object dequeue() {
        Object objeto = null;
        if (!estaVacio()) {
            objeto = cabecera.getObjeto();
            cabecera = cabecera.getSiguiente();
        }
        return objeto;
    }

    public boolean estaVacio() {
        return (this.cabecera == null);
    }

    public int tamanio() {
        int tamanio = 0;
        if (!estaVacio()) {
            NodoCola temporal = cabecera;
            while (temporal != null) {
                tamanio++;
                temporal = temporal.getSiguiente();
            }
        }
        return tamanio;
    }

    public void imprimir() {
        if (!estaVacio()) {
            NodoCola temporal = cabecera;
            while (temporal != null) {
                System.out.println(temporal.getObjeto());
                temporal = temporal.getSiguiente();
            }
        } else {
            System.out.println("La lista no contiene datos.");
        }
    }

    //Método para buscar por posición
    public Object buscarPorPosicion(int posicion) {
        Object objeto = null;
        if (!estaVacio()) {
            if (posicion >= 0 && posicion <= (tamanio() - 1)) {
                NodoCola temporal = cabecera;
                for (int i = 0; i < posicion; i++) {
                    temporal = temporal.getSiguiente();
                    if (temporal == null) {
                        break;
                    }
                }
                objeto = (temporal != null) ? temporal.getObjeto() : null;
            } else {
                JOptionPane.showMessageDialog(null, "La posición ingresada se encuentra fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
                throw new IndexOutOfBoundsException("Fuera de rango");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return objeto;
    }

    //Método para editar por posición
    public void editarPorPosicion(int posicion, Object objeto) {
        if (posicion >= 0 && posicion < tamanio()) {
            if (posicion == 0) {
                cabecera.setObjeto(objeto);
            } else {
                NodoCola aux = cabecera;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setObjeto(objeto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La posición ingresada se encuentra fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
