package sistemagestionactividades;

import controlador.listaSimple.ListaSimple;
import controlador.servicio.PersonaServicio;
import controlador.servicio.RolServicio;

public class SistemaGestionActividades {

    public static void main(String[] args) {

        //new BienvenidaVista().setVisible(true);
        PersonaServicio ps = new PersonaServicio();
        //        RolServicio rs = new RolServicio();
        System.out.println("Personas:");
        ListaSimple lista = ps.listarPersonas();
        lista.imprimir();
        
        System.out.println("Personas Activas:");
        ListaSimple listaActivas = ps.listarPersonasActivas(ps.listarPersonas());
        listaActivas.imprimir();
        
        System.out.println("Personas Inactivas:");
        ListaSimple listaInactivas = ps.listarPersonasInactivas(ps.listarPersonas());
        listaInactivas.imprimir();
//        //ListaSimple lista = ps.listarPersonasCoincidencias(ps.listarPersonas(), rs.obtenerIdRol(rs.listarRoles(), "Personal", RolServicio.TIPO), PersonaServicio.ID_ROL);
//        ListaSimple lista = ps.listarPersonasCoincidencias(ps.listarPersonas(), "activo", PersonaServicio.ACTIVO);
//        System.out.println("Consulta");
//        lista.imprimir();
    }

}
