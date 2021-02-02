package sistemagestionactividades;

import controlador.listaSimple.ListaSimple;
import controlador.servicio.PersonaServicio;
import controlador.servicio.RolServicio;
import modelo.RolModelo;

public class SistemaGestionActividades {

    public static void main(String[] args) {

        //new BienvenidaVista().setVisible(true);
//        PersonaServicio ps = new PersonaServicio();
//        RolServicio rs = new RolServicio();
//        ListaSimple lista = ps.listarPersonasCoincidencias(ps.listarPersonas(), rs.obtenerIdRol(rs.listarRoles(), "Personal", RolServicio.TIPO), PersonaServicio.ID_ROL);
//        lista.imprimir();
        RolServicio rolSer = new RolServicio();
//        System.out.println("Se guardo : "+ rolServicio.crearRoles());
        
        System.out.println("ID personal"+((RolModelo)(rolSer.buscarRol("Personal","tipo"))).getId());
    }

}
