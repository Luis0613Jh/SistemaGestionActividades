
package controlador;

import controlador.cola.Cola;
import controlador.listaSimple.ListaSimple;
import controlador.servicio.ActividadPersonalServicio;
import modelo.ActividadPersonalModelo;
import modelo.PersonaModelo;
import controlador.DAO.objetosDAO.PersonaDAO;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class ControladorActividadPersonal {
    private ActividadPersonalModelo actividadPersonal;

    public ActividadPersonalModelo getActividadPersonal() {
        if(actividadPersonal == null){
            actividadPersonal = new ActividadPersonalModelo();
        }
        return actividadPersonal;
    }

    public void setActividadPersonal(ActividadPersonalModelo actividadPersonal) {
        this.actividadPersonal = actividadPersonal;
    }
    
    public ListaSimple obtenerListaActividadesPersonales(PersonaModelo persona) {
        ActividadPersonalServicio aps = new ActividadPersonalServicio();
        ListaSimple listaCoincidencias = aps.listarActividadesPersonalesCoincidencias(aps.listarActividadesPersonales(), persona.getId(), ActividadPersonalServicio.PERSONA_ID);
        ListaSimple listaCoincidenciasActivas = aps.listarActividadesPersonalesActivas(listaCoincidencias);
        System.out.println("Actividades");
        listaCoincidenciasActivas.imprimir();
        return listaCoincidenciasActivas;
    }
    
    public int determinarSegundosTotales(String horaF) {
        // Hora en la que finaliza la actividad personal
        String[] arrayHora = horaF.split(":");

        int hF = (Integer.parseInt(arrayHora[0]) * 3600);
        int mF = (Integer.parseInt(arrayHora[1]) * 60);
        int sF = (Integer.parseInt(arrayHora[2]));
        int segundosF = hF + mF + sF;
        System.out.println("Segundos Totales F: " + segundosF);
        
        // Hora actual del sistema
        LocalDateTime locaDate = LocalDateTime.now();
        int hA = locaDate.getHour() * 3600;
        int mA = locaDate.getMinute() * 60;
        int sA = locaDate.getSecond();        
        int segundosA = hA + mA + sA;
        
        System.out.println("Segundos Totales A: " + segundosA);
        
        int segundosTotales = segundosF - segundosA;
        System.out.println("Segundos Totales: " + segundosTotales);
        
        return segundosTotales;
    }
    
    public String determinarHora(Cola cola) {
        ActividadPersonalModelo ap = (ActividadPersonalModelo) cola.buscarPorPosicion(0);
        return ap.getHora();
    }

    public boolean guardarActividadPersonal(){
        try {
            ActividadPersonalServicio servicio = new ActividadPersonalServicio();
            servicio.setActividadPersonal(actividadPersonal);
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
        if(lista == null){
            return 0;
        }else{
            return lista.tamanio();
        }
    }

}

