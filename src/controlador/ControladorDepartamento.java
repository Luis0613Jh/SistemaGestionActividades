/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.DAO.objetosDAO.DepartamentoDAO;
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
        if(depatamento == null){
            depatamento = new DepartamentoModelo();
        }
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
     * Metodo para guardar el departmento en el json
     *
     * @return Si se guardo o no en el departamento
     */
    public boolean guardarDepartamento() {
        try {
            DepartamentoDAO dep = new DepartamentoDAO();
            dep.setDepartamento(depatamento);
            dep.guardarDepartamento();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
