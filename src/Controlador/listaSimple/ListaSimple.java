package controlador.listaSimple;

import controlador.utilidades.UtilidadesControlador;
import javax.swing.JOptionPane;

public class ListaSimple {

    private Nodo cabecera;

    /**
     * Construye una lista simple
     */
    public ListaSimple() {
        this.cabecera = null;
    }

    /**
     * Metodo para obtener la cabecera de la lista
     *
     * @return Retorna la cabecera de la lista
     */
    public Nodo getCabecera() {
        return cabecera;
    }

    /**
     * Metodo enviar cabecera
     *
     * @param cabecera Recibe un Nodo el cual seria el Nodo inicial de la lista
     */
    public void setCabecera(Nodo cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * Método para verificar si la lista es vacia
     *
     * @return Un boolean para saber si la lista esta o no vacia
     */
    public boolean estaVacia() {
        return (this.cabecera == null);
    }

    /**
     * Método para obtener el tamaño de la lista
     *
     * @return Un entero el cual es el tamaño de la lista
     */
    public int tamanio() {
        int tamanio = 0;
        if (!estaVacia()) {
            Nodo temporal = cabecera;
            while (temporal != null) {
                tamanio++;
                temporal = temporal.getSiguiente();
            }
        } else {
            //JOptionPane.showMessageDialog(null, "La lista se encuentra vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return tamanio;
    }

    /**
     * Método para insertar al inicio de la lista
     *
     * @param objeto Recibe el objeto a insertar en la posicion inicial
     */
    public void insertarInicio(Object objeto) {
        Nodo temporal = new Nodo(objeto);
        temporal.setSiguiente(cabecera);
        cabecera = temporal;
    }

    /**
     * Método para agregar un elemento por posición
     *
     * @param objeto Recibe el objeto a insertar
     * @param posicion Recibe la posicion del objeto a insertar
     */
    public void insertarPorPosicion(Object objeto, int posicion) {
        if (estaVacia() || posicion == 0) {
            insertarInicio(objeto);
        } else {
            Nodo iterador = this.cabecera;
            for (int i = 0; i < posicion - 1; i++) {
                if (iterador.getSiguiente() == null) {
                    break;
                }
                iterador = iterador.getSiguiente();
            }
            Nodo temporal = new Nodo(objeto, iterador.getSiguiente());
            iterador.setSiguiente(temporal);
        }
    }

    /**
     * Método para agregar un elemento al final
     *
     * @param objeto Recibe un objeto a insertar en la posición final
     */
    public void insertarFinal(Object objeto) {
        if (tamanio() >= 1) {
            insertarPorPosicion(objeto, tamanio());
        } else {
            insertarPorPosicion(objeto, tamanio() - 1);
        }
    }

    /**
     * Método para buscar por posición
     *
     * @param posicion Recibe la posicion del objeto a buscar
     * @return objeto a buscar
     */
    public Object buscarPorPosicion(int posicion) {
        Object objeto = null;
        if (!estaVacia()) {
            if (posicion >= 0 && posicion <= (tamanio() - 1)) {
                Nodo temporal = cabecera;
                for (int i = 0; i < posicion; i++) {
                    temporal = temporal.getSiguiente();
                    if (temporal == null) {
                        break;
                    }
                }
                objeto = (temporal != null) ? temporal.getObjeto() : null;
            } else {
                throw new IndexOutOfBoundsException("Fuera de rango");
            }
        } else {
            System.out.println("La lista se encuentra vacía.");
        }
        return objeto;
    }

    /**
     * Método para buscar por dato
     *
     * @param dato Recibe un string a buscar
     * @return objeto a buscar
     */
    public String buscarPosiciones(String dato) {
        String datosEncontrados = "";
        boolean estaIniciada = false;

        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Nodo iterador = cabecera;
            int cont = 0;
            while (iterador != null) {
                if (iterador.getObjeto().equals(dato)) {
                    if (!estaIniciada) {
                        datosEncontrados += cont;
                        estaIniciada = true;
                    } else {
                        datosEncontrados += ", " + cont;
                    }
                }
                cont++;
                iterador = iterador.getSiguiente();
            }
        }
        return datosEncontrados;
    }

    /**
     * Método para eliminar toda la lista
     */
    public void eliminarTodaLaLista() {
        cabecera = null;
    }

    /**
     * Método para eliminar por posición
     *
     * @param posicion Recibe la posicion a eliminar
     */
    public void eliminarPorPosicion(int posicion) {
        if (!estaVacia()) {
            if (posicion == 0) {
                cabecera = cabecera.getSiguiente();
            } else if (posicion <= (tamanio() - 1)) {
                Nodo aux = cabecera;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }
                Nodo siguiente = aux.getSiguiente();
                aux.setSiguiente(siguiente.getSiguiente());
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("La lista se encuentra vacía.");
        }
    }

    /**
     * Método para editar por posición
     *
     * @param posicion Recibe la posicion del dato a editar
     * @param objeto Recibe el objeto a editar
     */
    public void editarPorPosicion(int posicion, Object objeto) {
        if (posicion >= 0 && posicion < tamanio()) {
            if (posicion == 0) {
                cabecera.setObjeto(objeto);
            } else {
                Nodo aux = cabecera;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setObjeto(objeto);
            }
        } else {
            throw new IndexOutOfBoundsException("Fuera de rango");
        }
    }

    public void editarPorDato(Object dato, String atributo, Object objeto) {
        Nodo temporal = cabecera;

        while (temporal != null) {
            int num = UtilidadesControlador.compararObjetoDato(temporal.getObjeto(), dato, atributo);
            if (num == 0) {
                temporal.setObjeto(objeto);
                break;
            } else {
                temporal = temporal.getSiguiente();
            }
        }
    }

    /**
     * Método para imprimir toda la lista
     */
    public void imprimir() {

        if (!estaVacia()) {
            Nodo temporal = cabecera;

            while (temporal != null) {
                System.out.println("Dato: " + temporal.getObjeto().toString());
                temporal = temporal.getSiguiente();
            }
        }
    }

    /**
     * Método para eliminar por dato
     *
     * @param dato Recibe un string a eliminar
     */
    public void eliminarPorDato(String dato) {
        if (cabecera.getObjeto().equals(dato)) {
            cabecera = cabecera.getSiguiente();
        } else {
            Nodo aux = cabecera;
            while (!((aux.getSiguiente().getObjeto().equals(dato)))) {
                aux = aux.getSiguiente();
            }
            Nodo siguiente = aux.getSiguiente().getSiguiente();
            aux.setSiguiente(siguiente);
        }
    }
    
    public void eliminarPorObjeto(Object objeto) {
        if (cabecera.getObjeto().equals(objeto)) {
            cabecera = cabecera.getSiguiente();
        } else {
            Nodo aux = cabecera;
            while (!((aux.getSiguiente().getObjeto().equals(objeto)))) {
                aux = aux.getSiguiente();
            }
            Nodo siguiente = aux.getSiguiente().getSiguiente();
            aux.setSiguiente(siguiente);
        }
    }

}
