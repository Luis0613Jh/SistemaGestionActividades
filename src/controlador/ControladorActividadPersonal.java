
package controlador;

import controlador.DAO.objetosDAO.PersonaDAO;
import controlador.listaSimple.ListaSimple;
import controlador.servicio.ActividadPersonalServicio;
import javax.swing.JOptionPane;
import modelo.ActividadPersonalModelo;

public class ControladorActividadPersonal {
    private ActividadPersonalModelo actividad;

    public ActividadPersonalModelo getActividad() {
        if(actividad == null){
            actividad = new ActividadPersonalModelo();
        }
        return actividad;
    }

    public void setActividad(ActividadPersonalModelo actividad) {
        this.actividad = actividad;
    }
    
    public boolean guardarActividadPersonal(){
        try {
            ActividadPersonalServicio servicio = new ActividadPersonalServicio();
            servicio.setActividadPersonal(actividad);
            if(servicio.guardarActividadPersonal()){
                return true;
            }else{
                return false;
            }            
        } catch (Exception e) {
            System.out.println(" Error al insertar ");
            return false;
        }
    }
    public int numeroEmpleados() {
        ActividadPersonalServicio servicio = new ActividadPersonalServicio();
        ListaSimple lista = servicio.listarActividadesPersonales();
        return lista.tamanio();
    }
}
