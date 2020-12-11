package logica.controladora;

import java.util.List;
import logger.Errors;
import logica.Juego;
import logica.Usuario;
import logica.excepciones.JuegoException;
import logica.excepciones.UsuarioException;
import logica.validador.ValidaJuego;
import persistencia.ControlPersisJuego;

public class ControlJuego {
    
    private final ControlPersisJuego cjue;
    private final ValidaJuego vjue;
    private final Errors errors;

    public ControlJuego(ValidaJuego vjue, ControlPersisJuego cjue, Errors errors) {
        this.cjue = cjue;
        this.vjue = vjue;
        this.errors = errors;
    }
    
    //Crea Juego
    public boolean creaJuego(Juego jue) throws JuegoException{
        boolean res = false;        
        try{
            if(vjue.validJuego(jue)){
                res = cjue.createJuego(jue);
            }
        } catch(JuegoException e){
            errors.logError(e.getMessage());
        }         
        return res;
    }
    
    //Modifica Juego
    public boolean modifJuego(Juego jue){
        return cjue.modifJuego(jue);
    }
    
    //Elimina Juego
    public boolean eliminaJuego(int jueId){
        return cjue.eliminaJuego(jueId);
    }

    //Devuelve la Lista de Juegos
    public List<Juego> traerJuego() {
        return cjue.traerJuego();
    }

    //Devuelve a un Juego en Particular
    public Juego traerJuegoEnParticular(int id) {
        return cjue.traerUnJuego(id);
    }
    
}