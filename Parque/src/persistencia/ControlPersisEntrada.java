package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Entrada;
import persistencia.JPA.EntradaJpaController;
import persistencia.exceptions.NonexistentEntityException;

public class ControlPersisEntrada {
    
    EntradaJpaController cent = new EntradaJpaController();

    public boolean createEntrada(Entrada ent) {
        return cent.create(ent);
    }

    public boolean modifEntrada(Entrada ent) {
        boolean res = false;
        try {
            if(cent.edit(ent)){res=true;}
        } catch (Exception ex) {
            Logger.getLogger(ControlPersisEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean eliminaEntrada(int entId) {
        boolean res = false;
        try {
            if(cent.destroy(entId)){res=true;}
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlPersisEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public List<Entrada> traerEntrada() {
        return cent.findEntradaEntities();
    }

    public Entrada traerUnEntrada(int id) {
        return cent.findEntrada(id);
    }    
    
}
