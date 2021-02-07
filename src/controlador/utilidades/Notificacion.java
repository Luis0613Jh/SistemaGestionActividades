
package Controlador.utilidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Notificacion {
    
    public static void main(String[] args) {
        Notificacion not = new Notificacion();
        not.instanciarTimerMilisegundos(1000);
        not.iniciarTimer("01:01:20");
    }
    private Timer timer;
    private int segundos;
    private ActionListener accion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundos--;
            System.out.println("Segundos: " + segundos);
            if (segundos == 0) {
                System.out.println("Se terminó el tiempo");
            }
        }
    };
    
    public void instanciarTimerMilisegundos(int milisegundos) {
        timer = new Timer(milisegundos, accion);
    }
    
    public void iniciarTimer(String hora) {
        // 01:50:36
        String[] arrayHora = hora.split(":");
        System.out.println("ARRAY");

        int h = (Integer.parseInt(arrayHora[0]) * 3600);
        System.out.println("Hora: " + h);
        int m = (Integer.parseInt(arrayHora[1]) * 60);
        System.out.println("Minuto: " + m);
        int s = (Integer.parseInt(arrayHora[2]));
        System.out.println("Segundo: " + s);
        segundos = h + m + s;
        System.out.println("Segundos Totales: " + segundos);
        timer.start();
        System.out.println("Se inició el timer");
    }
    
    
}
