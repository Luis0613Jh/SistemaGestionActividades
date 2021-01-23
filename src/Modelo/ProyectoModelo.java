package modelo;

import java.util.Date;

public class ProyectoModelo {
    private String id;
    private PersonaModelo jefeProyecto;
    private Date fechaInicio;
    private Date fechaFinal;
    private int external_id;
    private String codigo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonaModelo getJefeProyecto() {
        return jefeProyecto;
    }

    public void setJefeProyecto(PersonaModelo jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getExternal_id() {
        return external_id;
    }

    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
}
