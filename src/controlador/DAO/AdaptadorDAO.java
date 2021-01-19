
package controlador.DAO;

import controlador.listaSimple.ListaSimple;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class AdaptadorDAO implements InterfazDAO{
    
    private ConexionDAO conexionDAO;
    private Class claseObjeto;

    public AdaptadorDAO(ConexionDAO conexionDAO, Class claseObjeto) {
        this.conexionDAO = conexionDAO;
        this.claseObjeto = claseObjeto;
    }

    @Override
    public ListaSimple listarObjetos() {
        ListaSimple listaAux = new ListaSimple();
        try {
            listaAux = (ListaSimple) conexionDAO.getXstream().fromXML(new FileReader(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + claseObjeto.getSimpleName() + File.separatorChar + claseObjeto.getSimpleName() + ".json"));
        } catch (Exception e) {
            System.out.println("ERROR al listar: " + e.getMessage());
        }
        return listaAux;
    }

    
    @Override
    public void guardarObjeto(Object objeto) throws Exception {
        ListaSimple listaAux = listarObjetos();
        listaAux.insertarFinal(objeto);
        conexionDAO.getXstream().toXML(listaAux, new FileOutputStream(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + claseObjeto.getSimpleName() + File.separatorChar + claseObjeto.getSimpleName() + ".json"));
    }

    
}
