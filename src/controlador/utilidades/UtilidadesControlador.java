
package controlador.utilidades;

import controlador.listaSimple.ListaSimple;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UtilidadesControlador {

    public static int compararObjetos(Object o, Object o1, String atributoClase) {
        int i = 0;

        if (extraerDatoDeObjeto(o, atributoClase) instanceof Integer && extraerDatoDeObjeto(o1, atributoClase) instanceof Integer) {
            Integer uno = (Integer) extraerDatoDeObjeto(o, atributoClase);
            Integer dos = (Integer) extraerDatoDeObjeto(o1, atributoClase);
            
            if (uno > dos) {
                i = 1;
            } else if (uno < dos) {
                i = -1;
            }

        } else if (extraerDatoDeObjeto(o, atributoClase) instanceof String && extraerDatoDeObjeto(o1, atributoClase) instanceof String) {
            String uno = extraerDatoDeObjeto(o, atributoClase).toString();
            String dos = extraerDatoDeObjeto(o1, atributoClase).toString();
            
            if (uno != null && dos != null) {
                i = uno.toUpperCase().compareTo(dos.toUpperCase());
            }
        }
        return i;
    }
    
    private static Object extraerDatoDeObjeto(Object obj, String atributoClase) {
        Class clase = obj.getClass();
        Field atributo = null;
        Object informacion = null;
        
        for (Field f : clase.getDeclaredFields()) {
            if (f.getName().toString().equalsIgnoreCase(atributoClase)) {
                atributo = f;
            }
        }
        
        if (atributo != null) {
            for (Method metodoAux : clase.getMethods()) {
                if (metodoAux.getName().startsWith("get")) {
                    if (metodoAux.getName().toLowerCase().endsWith(atributo.getName())) {
                        try {
                            informacion = metodoAux.invoke(obj);
                            break;
                        } catch (Exception e) {
                            System.out.println("Error en el método: " + e.getMessage());
                        }
                    }
                }
            }
        }
        return (informacion != null) ? informacion : null;
    }

    // Método Quicksort 
    public static void ordenarQuicksort(int inferior, int superior, ListaSimple lista, String atributo) {
        int i = inferior;
        int j = superior;

        Object objeto_Centro = lista.buscarPorPosicion((inferior + superior) / 2);

        while (i <= j) {

            while (compararObjetos(lista.buscarPorPosicion(i), objeto_Centro, atributo) < 0) {
                i++;
            }

            while (compararObjetos(lista.buscarPorPosicion(j), objeto_Centro, atributo) > 0) {
                j--;
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

//    //Método para buscar por dato con búsqueda binaria, retorna el objeto
//    public static Object buscarDatoBinaria_Objeto(String dato, String atributo, ListaSimple lista) {
//        Object objeto = null;
//        int centro = 0;
//        int inferior = 0;
//        int superior = lista.tamanio() - 1;
//        
//        while (inferior <= superior) {
//            
//            centro = (superior + inferior) / 2;
//            String objeto_Centro = UtilidadesControlador.extracciondato(lista.buscarPorPosicion(centro), atributo);
//
//            if (objeto_Centro.equalsIgnoreCase(dato)) {
//                objeto = objeto_Centro;
//                return objeto;
//            } else if (dato.toUpperCase().compareTo(objeto_Centro) < 0) {
//                superior = centro - 1;
//            } else {
//                inferior = centro + 1;
//            }
//        }
//        
//        return objeto;
//    }
}
