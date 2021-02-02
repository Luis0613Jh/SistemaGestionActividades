package modelo;

import java.util.Date;

public class ProyectoModelo {

    private int id;
    private PersonaModelo jefeProyecto;
    private Date fechaInicio;
    private Date fechaFinal;
    private int external_id;
    private String codigo;
    private boolean activo;
    
    /**
     * Metodo obtenr id
     *
     * @return Un String correspondiente a id
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo enviar id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo obtenr jefeProyecto
     *
     * @return Un PersonaModelo correspondiente a jefeProyecto
     */
    public PersonaModelo getJefeProyecto() {
        return jefeProyecto;
    }

    /**
     * Metodo enviar jefeProyecto
     *
     * @param jefeProyecto
     */
    public void setJefeProyecto(PersonaModelo jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    /**
     * Metodo obtener fechaInicio
     *
     * @return Un Date correspondiente a fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Metodo enviar fechaInicio
     *
     * @param fechaInicio
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Metodo obtener fechaFinal
     *
     * @return Un Date correspondiente a fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Metodo enviar fechaFinal
     *
     * @param fechaFinal
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Metdo obtener external_id
     *
     * @return Un int correspondiente a external_id
     */
    public int getExternal_id() {
        return external_id;
    }

    /**
     * Metodo enviar external_id
     *
     * @param external_id
     */
    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }

    /**
     * Metodo obtener codigo
     *
     * @return Un String correspondiente a codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo enviar codigo
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
