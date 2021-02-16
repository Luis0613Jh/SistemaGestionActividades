package controlador.utilidades;

import controlador.ControladorRol;
import controlador.DAO.objetosDAO.RolDAO;
import controlador.cola.Cola;
import controlador.listaSimple.ListaSimple;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import modelo.ActividadPersonalModelo;
import modelo.PersonaModelo;
import modelo.RolModelo;
import vista.EditarEmpleadoVista;

public class UtilidadesControlador {

    /**
     * Método que compara dos objetos, según el atributo de la clase
     * especificado.
     *
     * @param objeto1 Primer objeto a comparar, es de tipo Object.
     * @param objeto2 Segundo objeto a comparar, es de tipo Object.
     * @param atributoClase Atributo del modelo a comparar entre ambos objetos,
     * es de tipo string.
     * @return Retorna un entero según la comparación entre ambos objetos con el
     * atributo especificado. > Devuelve 0 sin son iguales. > Devuelve 1 si
     * objeto1 es mayor a objeto2. > Devuelve -1 si objeto1 es menor a objeto2.
     */
    public static int compararObjetos(Object objeto1, Object objeto2, String atributoClase) {
        int i = 0;

        if (extraerDatoDeObjeto(objeto1, atributoClase) instanceof Integer && extraerDatoDeObjeto(objeto2, atributoClase) instanceof Integer) {
            Integer uno = (Integer) extraerDatoDeObjeto(objeto1, atributoClase);
            Integer dos = (Integer) extraerDatoDeObjeto(objeto2, atributoClase);

            if (uno > dos) {
                i = 1;
            } else if (uno < dos) {
                i = -1;
            }

        } else if (extraerDatoDeObjeto(objeto1, atributoClase) instanceof String && extraerDatoDeObjeto(objeto2, atributoClase) instanceof String) {
            String uno = extraerDatoDeObjeto(objeto1, atributoClase).toString();
            String dos = extraerDatoDeObjeto(objeto2, atributoClase).toString();

            if (uno != null && dos != null) {
                i = uno.toUpperCase().compareTo(dos.toUpperCase());
            }
        }
        return i;
    }

    /**
     * Método que compara un objeto con un dato, según el atributo de la clase
     * especificado para el objeto.
     *
     * @param objeto Objeto a comparar, es de tipo Object.
     * @param dato Dato a comparar, es de tipo Object.
     * @param atributoClase Atributo del modelo del objeto a comparar con el
     * dato, es de tipo string.
     * @return Retorna un entero según la comparación entre el objeto y el dato
     * con el atributo especificado. > Devuelve 0 sin son iguales. > Devuelve 1
     * si objeto es mayor a dato. > Devuelve -1 si objeto es menor a dato.
     */
    public static int compararObjetoDato(Object objeto, Object dato, String atributoClase) {
        int i = 0;

        if (dato instanceof Integer) {
            Integer objetoEntero = (Integer) extraerDatoDeObjeto(objeto, atributoClase);
            Integer datoEntero = (int) dato;

            if (objetoEntero > datoEntero) {
                i = 1;
            } else if (objetoEntero < datoEntero) {
                i = -1;
            }

        } else if (dato instanceof String) {
            String objetoString = extraerDatoDeObjeto(objeto, atributoClase).toString();
            String datoString = dato.toString();

            if (objetoString != null && datoString != null) {
                i = objetoString.toUpperCase().compareTo(datoString.toUpperCase());
            }
        } else if (dato instanceof Boolean) {
            Boolean objetoBoolean = (Boolean) extraerDatoDeObjeto(objeto, atributoClase);
            Boolean datoBoolean = (Boolean) dato;

            if (objetoBoolean != null && datoBoolean != null) {
                i = objetoBoolean.compareTo(datoBoolean);
            }
        }
        return i;
    }

    public static Object extraerDato(Object objeto, String atributoClase) {
        return extraerDatoDeObjeto(objeto, atributoClase);
    }

    /**
     * Método que extrae la información de un objeto según su atributo de clase
     * especificado.
     *
     * @param objeto Objeto a extraer su información, es de tipo Object.
     * @param atributoClase Atributo de la clase del objeto a extraer su
     * información, es de tipo string.
     * @return Devuelve un objeto que contiene la información especificada del
     * objeto según su atributo de clase. > En caso de encontrar una
     * coincidencia, devuelve un objeto con referencia a una string o a un
     * entero según el tipo de dato establecido. > En caso de no encontrar
     * ninguna coincidencia, devuelve null.
     */
    private static Object extraerDatoDeObjeto(Object objeto, String atributoClase) {
        Class clase = objeto.getClass();
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
                            informacion = metodoAux.invoke(objeto);
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

    /**
     * Método que ordena una lista en orden ascendente según el atributo
     * indicado.
     *
     * @param inferior Posición inicial en donde va a empezar a ordenar el
     * método, generalmente se indica la primera posición (0).
     * @param superior Posición final en donde va a finalizar a ordenar el
     * método, generalmente se indica la última posiciónn (lista.tamanio() -1).
     * @param lista Lista a ordenar.
     * @param atributo Atributo por el cual se va a ordenar la lista, es de tipo
     * string.
     */
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

    /**
     * Método que busca un objeto por medio del algoritmo de búsqueda binaria,
     * según el atributo especificado de la clase del objeto a buscar.
     *
     * @param dato Dato a encontrar en el objeto, es de tipo Object.
     * @param atributo Atributo por el cual se va buscar en el objeto, es de
     * tipo String.
     * @param lista Lista en donde se va a buscar el objeto especificado.
     * @return Devuelve un objeto que contiene la información especificada del
     * objeto según su atributo de clase. > En caso de encontrar una
     * coincidencia, devuelve un objeto con la información del objeto
     * encontrado, es de tipo Object. > En caso de no encontrar ninguna
     * coincidencia, devuelve null.
     */
    public static Object buscarObjetoPorBusquedaBinariaPorDato(Object dato, String atributo, ListaSimple lista) {
        Object objeto = null;
        int centro = 0;
        int inferior = 0;
        int superior = lista.tamanio() - 1;

        while (inferior <= superior) {

            centro = (superior + inferior) / 2;
            Object objeto_Centro = lista.buscarPorPosicion(centro);

            if (compararObjetoDato(objeto_Centro, dato, atributo) == 0) {
                return objeto_Centro;
            } else if (compararObjetoDato(objeto_Centro, dato, atributo) < 0) {
                inferior = centro + 1;
            } else {
                superior = centro - 1;
            }
        }
        return objeto;
    }

    public static int generarId() {
        return (int) Math.random() * 1000;
    }

    public static void cargarComboBoxDias(JComboBox cdx, String[] dato) {
        cdx.removeAllItems();
        for (int i = 0; i < dato.length; i++) {
            cdx.addItem(dato[i]);
        }

    }

    public static void cargarComboBoxEmpleados(JComboBox cdx, ListaSimple dato) {
        cdx.removeAllItems();
        for (int i = 0; i < dato.tamanio(); i++) {
            cdx.addItem(((PersonaModelo) dato.buscarPorPosicion(i)).getNombre());
        }

    }

    public static void cargarComboBoxEmpleadosParaDepartamento(JComboBox cdx, ListaSimple dato) {
        cdx.removeAllItems();
        ControladorRol rol = new ControladorRol();
        for (int i = 0; i < dato.tamanio(); i++) {
            PersonaModelo aux = (PersonaModelo) dato.buscarPorPosicion(i);
            RolModelo aux2 = rol.obtenerRolPor_Id(aux.getId_rol());
            if (!aux2.getTipo().equalsIgnoreCase("Administrador") && aux2.getTipo() != null) {
                cdx.addItem(aux.getNombre());
            }
        }
    }

    public static void inicioRoles() throws Exception {

        RolModelo rol1 = new RolModelo(1, generarId(), "Personal");
        RolModelo rol2 = new RolModelo(2, generarId(), "Administrador");
        RolModelo rol3 = new RolModelo(3, generarId(), "Encargado");
        RolDAO r = new RolDAO();
        r.guardarObjeto(rol1);
        r.guardarObjeto(rol2);
        r.guardarObjeto(rol3);
    }

    /**
     * Método que valida una string para comprobar si es un número entero
     * (positivo o negativo).
     *
     * @param numero String a verificar
     * @return Retorna true si cumple con el formato de la expresión regular,
     * caso contrario, retorna false.
     */
    public static boolean validarNumeroEntero(String numero) {
        return numero.matches("^[-]?[0-9]+$");
    }

    /**
     * Método que valida una string para comprobar si es un número con o sin
     * decimales (positivo o negativo).
     *
     * @param numero String a verificar
     * @return Retorna true si cumple con el formato de la expresión regular,
     * caso contrario, retorna false.
     */
    public static boolean validarNumeroConDecimal(String numero) {
        return numero.matches("^[-]?[0-9]+([.][0-9]+)?$");
    }

    /**
     * Método que valida una string para comprobar si es una cadena solo
     * alfabetica (solo letras).
     *
     * @param numero String a verificar
     * @return Retorna true si cumple con el formato de la expresión regular,
     * caso contrario, retorna false.
     */
    public static boolean validarCadenaSoloLetras(String cadena) {
        return cadena.matches("^([A-Za-z]+[ ]?)+$");
    }

    /**
     * Método que valida una string para comprobar si es un nombre válido (sin
     * números o caracteres especiales), admite espacios para el apellido.
     *
     * @param numero String a verificar
     * @return Retorna true si cumple con el formato de la expresión regular,
     * caso contrario, retorna false.
     */
    public static boolean validarNombre(String nombre) {
        return nombre.matches("^(([A-Za-z]{1})?[a-z]+[ ]?)+$");
    }

    /**
     * Método que valida una string para comprobar si cumple con el número de
     * dígitos de una cédula.
     *
     * @param numero String a verificar
     * @return Retorna true si cumple con el formato de la expresión regular,
     * caso contrario, retorna false.
     */
    public static boolean validarCedula(String cedula) {
        return cedula.matches("^[0-9]{10}$");
    }

    public static ListaSimple unirDosListas(ListaSimple l1, ListaSimple l2) {
        ListaSimple aux = new ListaSimple();
        for (int i = 0; i < l1.tamanio(); i++) {
            if(l1.buscarPorPosicion(i) != null){
                aux.insertarFinal(l1.buscarPorPosicion(i));
            }            
        }
        for (int i = 0; i < l2.tamanio(); i++) {
            if(l2.buscarPorPosicion(i) != null){
                aux.insertarFinal(l2.buscarPorPosicion(i));
            } 
        }
        return aux;
    }

    public static int determinarSegundosTotales(String hora) {
        String[] arrayHora = hora.split(":");
        System.out.println("ARRAY");

        int h = (Integer.parseInt(arrayHora[0]) * 3600);
        System.out.println("Hora: " + h);
        int m = (Integer.parseInt(arrayHora[1]) * 60);
        System.out.println("Minuto: " + m);
        int s = (Integer.parseInt(arrayHora[2]));
        System.out.println("Segundo: " + s);
        int segundos = h + m + s;
        System.out.println("Segundos Totales: " + segundos);
        return segundos;
    }

    public static Cola obtenerNotificacionesActividadesPersonal(ListaSimple lista) {
        Cola cola = null;
        double tiempo;
        double auxTiempo = -99.00;
        int auxIndice = -1;
        ActividadPersonalModelo actividadPersonal;
        if (lista != null) {
            cola = new Cola();
            while (!lista.estaVacia()) {
                for (int i = 0; i < lista.tamanio(); i++) {
                    actividadPersonal = (ActividadPersonalModelo) lista.buscarPorPosicion(i);
                    tiempo = determinarSegundosTotales(actividadPersonal.getHora());

                    if (auxTiempo < tiempo) {
                        auxTiempo = tiempo;
                        auxIndice = i;
                    }
                }
                cola.queue(lista.buscarPorPosicion(auxIndice));
                lista.eliminarPorPosicion(auxIndice);
            }
        }
        return cola;
    }
}
