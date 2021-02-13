
package controlador;

import controlador.cola.Cola;
import controlador.listaSimple.ListaSimple;
import controlador.servicio.ActividadPersonalServicio;
import modelo.ActividadPersonalModelo;
import modelo.PersonaModelo;

public class ControladorActividadPersonal {
    private ActividadPersonalModelo actividadPersonal = new ActividadPersonalModelo();

    public ActividadPersonalModelo getActividadPersonal() {
        return actividadPersonal;
    }

    public void setActividadPersonal(ActividadPersonalModelo actividadPersonal) {
        this.actividadPersonal = actividadPersonal;
    }
    
    public ListaSimple obtenerListaActividadesPersonales(PersonaModelo persona) {
        ListaSimple lista = new ActividadPersonalServicio().listarActividadesPersonalesCoincidencias(new ActividadPersonalServicio().listarActividadesPersonales(), persona.getId(), "id");
        return lista;
    }
    
    public int determinarSegundosTotales(String hora) {
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
    
    public String determinarHora(Cola cola) {
        ActividadPersonalModelo ap = (ActividadPersonalModelo) cola.buscarPorPosicion(0);
        return ap.getHora();
    }
}
