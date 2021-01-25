/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.DepartamentoModelo;

/**
 *
 * @author Patricio
 */
public class ControladorDepartamento {

    private DepartamentoModelo depatamento = new DepartamentoModelo();

    /**
     * Metodo obtener departamento
     *
     * @return Un DepartamentoModelo correspndiente a depatamento
     */
    public DepartamentoModelo getDepatamento() {
        return depatamento;
    }

    /**
     * Metodo enviar depatamento
     *
     * @param depatamento
     */
    public void setDepatamento(DepartamentoModelo depatamento) {
        this.depatamento = depatamento;
    }

    /**
     * Metodo para clonar el modelo temporaal de departamento y manejar ids
     */
    public void clonarDepartamento() {
        DepartamentoModelo aux = new DepartamentoModelo();

    }

    /**
     * Metodo para guardar el departmento en el json
     *
     * @return Si se guardo o no en el departamento
     */
    public boolean guardarDepartamento() {
        try {

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
