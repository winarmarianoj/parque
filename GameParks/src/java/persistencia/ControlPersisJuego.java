package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Juego;
import logica.Usuario;
import persistencia.JPA.JuegoJpaController;
import persistencia.exceptions.NonexistentEntityException;

public class ControlPersisJuego {
    JuegoJpaController cjue = new JuegoJpaController();

    public boolean createJuego(Juego jue) {
        return cjue.create(jue);
    }

    public boolean modifJuego(Juego jue) {
        boolean res = false;
        try {
            if(cjue.edit(jue)){res=true;}
        } catch (Exception ex) {
            Logger.getLogger(ControlPersisJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean eliminaJuego(int jueId) {
        boolean res = false;
        try {
            if(cjue.destroy(jueId)){res=true;}
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlPersisJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public List<Juego> traerJuego() {
        return cjue.findJuegoEntities();
    }

    public Juego traerUnJuego(int id) {
        return cjue.findJuego(id);
    }
    
    
}
