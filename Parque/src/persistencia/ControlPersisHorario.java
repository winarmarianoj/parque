package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horario;
import persistencia.JPA.HorarioJpaController;
import persistencia.exceptions.NonexistentEntityException;

public class ControlPersisHorario {
    
    HorarioJpaController chor = new HorarioJpaController();
    
    public boolean createHorario(Horario hor) {
        return chor.create(hor);
    }

    public boolean modifHor(Horario hor) {
        boolean res = false;
        try {
            if(chor.edit(hor)){res=true;}
        } catch (Exception ex) {
            Logger.getLogger(ControlPersisHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean eliminaHor(int horId) {
        boolean res = false;
        try {
            if(chor.destroy(horId)){res=true;}
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlPersisHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public List<Horario> traerHorario() {
        return chor.findHorarioEntities();
    }

    public Horario traerUnHorario(int id) {
        return chor.findHorario(id);
    }
    
}
