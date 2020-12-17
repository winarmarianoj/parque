package logica.controladora;

import java.util.List;
import logica.logger.Errors;
import logica.Horario;
import logica.excepciones.HorarioException;
import logica.validador.Validar;
import persistencia.ControlPersisHorario;

public class ControlHorario {
    
    private final ControlPersisHorario chor;
    private final Validar validhor;
    private final Errors errors;
    private final Horario hor;

    public ControlHorario(Validar vhor, ControlPersisHorario chor, Errors errors, Horario hor) {
        this.chor = chor;
        this.validhor = vhor;
        this.errors = errors;
        this.hor = hor;
    }
    
    //Crea Horario
    public boolean creaHorario(Horario hor){
        boolean res = false;        
        try{
            if(!searchHorario(hor)){
                if(validhor.validHorario(hor)){
                res = chor.createHorario(hor);
                }
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
    
    private boolean searchHorario(Horario hor){
        boolean res = false;
        List<Horario> listHoras = traerHorario();
        for(Horario element : listHoras){
            if(element.getHora_inicio().equals(hor.getHora_inicio())){
                res = true;
                break;
            }                
        }
        return res;
    }

    public Horario getHor() {
        return hor;
    }
    
}
