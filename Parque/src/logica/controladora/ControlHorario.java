package logica.controladora;

import java.util.List;
import logger.Errors;
import logica.Horario;
import logica.Usuario;
import logica.excepciones.HorarioException;
import logica.excepciones.UsuarioException;
import logica.validador.ValidaHorario;
import logica.validador.ValidaUsuario;
import persistencia.ControlPersisHorario;
import persistencia.ControlaPersisUsuario;

public class ControlHorario {
    
    private final ControlPersisHorario chor;
    private final ValidaHorario validhor;
    private final Errors errors;

    public ControlHorario(ValidaHorario vhor, ControlPersisHorario chor, Errors errors) {
        this.chor = chor;
        this.validhor = vhor;
        this.errors = errors;
    }
    
    //Crea Horario
    public boolean creaHorario(Horario hor){
        boolean res = false;        
        try{
            if(validhor.validHorario(hor)){
            res = chor.createHorario(hor);
            }
        } catch(HorarioException e){
            errors.logError(e.getMessage());
        }         
        return res;
    }
    
    //Modifica Horario
    public boolean modifHorario(Horario hor){
        return chor.modifHor(hor);
    }
    
    //Elimina Horario
    public boolean eliminaHor(int horId){
        return chor.eliminaHor(horId);
    }

    //Devuelve la Lista de Horarios
    public List<Horario> traerHorario() {
        return chor.traerHorario();
    }

    //Devuelve a un Horario en Particular
    public Horario traerHorarioEnParticular(int id) {
        return chor.traerUnHorario(id);
    }
}
