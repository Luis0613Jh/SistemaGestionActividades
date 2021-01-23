
package controlador.utilidades;

import controlador.listaSimple.ListaSimple;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UtilidadesControlador {

    public static String extracciondato(Object obj, String atributoClase) {
        System.out.println("Atributo clase: " + atributoClase);
        Class clase = obj.getClass();
        Field atributo = null;
        Object informacion = null;
        for (Field f : clase.getDeclaredFields()) {
            System.out.println("F: " + f);
            if (f.getName().toString().equalsIgnoreCase(atributoClase)) {
                atributo = f;
                System.out.println("Atributo: " + atributo);
            }
        }
        System.out.println("Atributo a comparar: " + atributo);
        if (atributo != null) {
            for (Method metodoAux : clase.getMethods()) {
                System.out.println("Método: " + metodoAux);
                if (metodoAux.getName().startsWith("get")) {
                    System.out.println("Nombre aytributo: " + atributo.getName());
                    if (metodoAux.getName().toLowerCase().endsWith(atributo.getName())) {
                        try {
                            System.out.println("Método a invocar: " + metodoAux);
                            System.out.println("Invocación del método: " + metodoAux.invoke(obj));
                            informacion = metodoAux.invoke(obj);
                            System.out.println("Informacion: " + informacion);
                            break;
                        } catch (Exception e) {
                            System.out.println("Error de metodo " + e);
                        }
                    }
                }
            }
        }
        return (informacion != null) ? informacion.toString() : null;
    }

    // Método Quicksort normal
    public static void ordenarQuicksort(int inferior, int superior, ListaSimple lista, String atributo) {
        int i = inferior;
        int j = superior;
        
        String objeto_Centro = extracciondato(lista.buscarPorPosicion((inferior + superior) / 2), atributo);

        while (i <= j) {

            String objeto_I = extracciondato(lista.buscarPorPosicion(i), atributo);
            String objeto_J = extracciondato(lista.buscarPorPosicion(j), atributo);

            while (objeto_I.toUpperCase().compareTo(objeto_Centro.toUpperCase()) < 0) {
                i++;
                objeto_I = extracciondato(lista.buscarPorPosicion(i), atributo);
            }

            while (objeto_J.toUpperCase().compareTo(objeto_Centro.toUpperCase()) > 0) {
                j--;
                objeto_J = extracciondato(lista.buscarPorPosicion(j), atributo);
            }

            if (i <= j) {
                Object objetoTemporal = lista.buscarPorPosicion(i);
                lista.editarPorPosicion(i, lista.buscarPorPosicion(j));
                lista.editarPorPosicion(j, objetoTemporal);
                i++;
                j--;
            }
        }
        if (inferior < j) {
            ordenarQuicksort(inferior, j, lista, atributo);
        }
        if (i < superior) {
            ordenarQuicksort(i, superior, lista, atributo);
        }
    }

    //Método para buscar por dato con búsqueda binaria, retorna el objeto
    public static Object buscarDatoBinaria_Objeto(String dato, String atributo, ListaSimple lista) {
        Object objeto = null;
        int centro = 0;
        int inferior = 0;
        int superior = lista.tamanio() - 1;
        
        while (inferior <= superior) {
            
            centro = (superior + inferior) / 2;
            String objeto_Centro = UtilidadesControlador.extracciondato(lista.buscarPorPosicion(centro), atributo);

            if (objeto_Centro.equalsIgnoreCase(dato)) {
                objeto = objeto_Centro;
                return objeto;
            } else if (dato.toUpperCase().compareTo(objeto_Centro) < 0) {
                superior = centro - 1;
            } else {
                inferior = centro + 1;
            }
        }
        
        return objeto;
    }
}
