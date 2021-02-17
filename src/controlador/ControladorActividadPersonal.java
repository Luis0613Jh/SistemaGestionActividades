
package controlador;

import controlador.cola.Cola;
import controlador.listaSimple.ListaSimple;
import controlador.servicio.ActividadPersonalServicio;
import modelo.ActividadPersonalModelo;
import modelo.PersonaModelo;
import java.time.LocalDateTime;

public class ControladorActividadPersonal {
    private ActividadPersonalModelo actividadPersonal;
    /**
     * Obtener la actividad personal
     * @return ActividadPersonalModelo retorna la actividad personal
     */
    public ActividadPersonalModelo getActividadPersonal() {
        if(actividadPersonal == null){
            actividadPersonal = new ActividadPersonalModelo();
        }
        return actividadPersonal;
    }
    /**
     * enviar la actividad personal
     * @param actividadPersonal  un objeto tipo ActividadPersonalModelo
     */
    public void setActividadPersonal(ActividadPersonalModelo actividadPersonal) {
        this.actividadPersonal = actividadPersonal;
    }
    /**
     * Metodo para obtener una lista de actividadesa personales
     * @param persona objeto tipo PersonaModelo
     * @return  una lista de actividades personales
     */
    public ListaSimple obtenerListaActividadesPersonales(PersonaModelo persona) {
        ActividadPersonalServicio aps = new ActividadPersonalServicio();
        ListaSimple listaCoincidencias = aps.listarActividadesPersonalesCoincidencias(aps.listarActividadesPersonales(), persona.getId(), ActividadPersonalServicio.PERSONA_ID);
        ListaSimple listaCoincidenciasActivas = aps.listarActividadesPersonalesActivas(listaCoincidencias);
        return listaCoincidenciasActivas;
    }
    /**
     * Meetodo para determinar segundos totales
     * @param horaF unstring
     * @return  int los segundos totales
     */
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
    /**
     * Metodo para determinar la hora
     * @param cola un objeto de tipo cola
     * @return retorna un string hora de la cola ingresada
     */
    public String determinarHora(Cola cola) {
        ActividadPersonalModelo ap = (ActividadPersonalModelo) cola.buscarPorPosicion(0);
        return ap.getHora();
    }
    /**
     * Metodo para guardar las actividades personales
     * @return true en caso de guardarse y false en caso contrario
     */
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
    /**
     * Metodo para enumerar los empleados
     * @return el numero existente de empleados
     */
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

