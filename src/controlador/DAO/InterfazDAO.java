
package controlador.DAO;

import controlador.listaSimple.ListaSimple;

public interface InterfazDAO {
    
    public void guardarObjeto(Object objeto) throws Exception;
    
    /**
     * Método que recupera toda la información de una lista.
     * @return Retorna la lista con toda la información recuperada.
     */
    public ListaSimple listarObjetos();  
}
