package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import java.io.File;
import modelo.RolModelo;

public class RolDAO extends AdaptadorDAO {

    private RolModelo rol;

    public RolDAO() {
        super(new ConexionDAO(), RolModelo.class, new ConexionDAO().getCARPETA_ROLES());
    }

    public RolModelo getRol() {
        if (rol == null) {
            rol = new RolModelo();
        }
        return rol;
    }

    public void setRol(RolModelo rol) {
        this.rol = rol;
    }

    public Boolean guardarRol() {
        try {
            this.guardarObjeto(this.getRol());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar rol: " + e);
            return false;
        }
    }

    public ListaSimple ordenarRoles(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    public RolModelo buscarRol(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarRoles(lista, atributo);
        RolModelo cuenta = (RolModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }

    public Boolean crearRoles(){
        boolean bandera = false;
        File archivo = new File(new ConexionDAO().getCARPETA_CONTENEDORA() + File.separatorChar + new ConexionDAO().getCARPETA_ROLES());
        
        if (!archivo.exists()) {
            System.out.println("Se han creado roles");
            
            RolModelo administradorRol = new RolModelo();
            administradorRol.setActivo(true);
            administradorRol.setExternal_id(654984);
            administradorRol.setId(1);
            administradorRol.setRol("Administrador");
            setRol(administradorRol);
            bandera = guardarRol();
            
            RolModelo jefeProyectoRol = new RolModelo();
            jefeProyectoRol.setActivo(true);
            jefeProyectoRol.setExternal_id(3657);
            jefeProyectoRol.setId(2);
            jefeProyectoRol.setRol("Jefe de Proyecto");
            setRol(jefeProyectoRol);
            bandera = guardarRol();
            
            RolModelo encargadoRol = new RolModelo();
            encargadoRol.setActivo(true);
            encargadoRol.setExternal_id(1234);
            encargadoRol.setId(3);
            encargadoRol.setRol("Encargado");
            setRol(encargadoRol);
            bandera = guardarRol();
            
            RolModelo personalRol = new RolModelo();
            personalRol.setActivo(true);
            personalRol.setExternal_id(13254);
            personalRol.setId(4);
            personalRol.setRol("Personal");
            setRol(personalRol);
            bandera = guardarRol();
            
        } else {
            System.out.println("Roles ya creados");
        }
        return bandera;
    }

    public Boolean modificarRol(Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar rol: " + e);
            return false;
        }
    }

    public Boolean darDeBajaRol(String dato, String atributo, ListaSimple lista) {
        RolModelo rol = buscarRol(dato, atributo, lista);
        rol.setActivo(false);
        try {
            // Se modifica
            modificarRol(rol, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el rol: " + e);
            return false;
        }
    }
    
    public int obtenerIdRol(ListaSimple lista, Object dato, String atributo) {
        lista = ordenarRoles(lista, atributo);
        System.out.println("Lista ordenada");
        lista.imprimir();
        RolModelo rol = (RolModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        System.out.println("Rol: " + rol.getRol());
        return rol.getId();
    }
}
