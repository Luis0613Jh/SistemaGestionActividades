package modelo;

import java.util.Date;

public class ProyectoModelo {

    private int id;
    private int id_jefeProyecto;
    private String nombreProyecto;
    private Date fechaInicio;
    private Date fechaFinal;
    private int external_id;
    private String codigo;
    private String estado;
    
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
    public int getId_jefeProyecto() {
        return id_jefeProyecto;
    }

    /**
     * Metodo enviar jefeProyecto
     *
     * @param jefeProyecto
     */
    public void setId_jefeProyecto(int id_jefeProyecto) {
        this.id_jefeProyecto= id_jefeProyecto;
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

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    /**
     * Método que obtiene el dato almacenado en estado.
     * @return Retrona una string correspondiente a estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que sobreescribe el dato almacenado en estado.
     * @param estado String que va reemplazar el dato en estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que convierte el objeto ProyectoModelo en un string.
     * @return Devuelve un string con el nombre del proyecto.
     */
    @Override
    public String toString() {
        return nombreProyecto;
    }

}
