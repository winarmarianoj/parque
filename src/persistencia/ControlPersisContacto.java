package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Contacto;
import persistencia.JPA.ContactoJpaController;
import persistencia.exceptions.NonexistentEntityException;

public class ControlPersisContacto {
    ContactoJpaController ccon = new ContactoJpaController();

    public boolean createContacto(Contacto con) {
        return ccon.create(con);
    }

    public boolean modifContacto(Contacto con) {
        boolean res = false;
        try {
            if(ccon.edit(con)){res=true;}
        } catch (Exception ex) {
            Logger.getLogger(ControlPersisContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean eliminaContacto(int conId) {
        boolean res = false;
        try {
            if(ccon.destroy(conId)){res=true;}
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlPersisContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public List<Contacto> traerContacto() {
        return ccon.findContactoEntities();
    }

    public Contacto traerUnContacto(int id) {
        return ccon.findContacto(id);
    }
    
}
