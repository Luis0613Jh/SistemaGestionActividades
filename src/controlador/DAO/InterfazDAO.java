
package controlador.DAO;

import controlador.listaSimple.ListaSimple;

public interface InterfazDAO {
    
    public void guardarObjeto(Object objeto) throws Exception;
    public ListaSimple listarObjetos();  
}
