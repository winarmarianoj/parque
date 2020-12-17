package logica.controladora;

import java.util.List;
import logica.logger.Errors;
import logica.Juego;
import logica.excepciones.JuegoException;
import logica.validador.Validar;
import persistencia.ControlPersisJuego;

public class ControlJuego {
    
    private final ControlPersisJuego cjue;
    private final Validar vjue;
    private final Errors errors;
    private final Juego jue;

    public ControlJuego(Validar vjue, ControlPersisJuego cjue, Errors errors, Juego jue) {
        this.cjue = cjue;
        this.vjue = vjue;
        this.errors = errors;
        this.jue = jue;
    }
    
    //Crea Juego
    public boolean creaJuego(Juego jue) throws JuegoException{
        boolean res = false;        
        try{
            if(!searchJuego(jue)){
                if(vjue.validJuego(jue)){
                   res = cjue.createJuego(jue);
                }
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
    
    private boolean searchJuego(Juego jue){
        boolean res = false;
        List<Juego> listJuego = traerJuego();
        for(Juego element : listJuego){
            if(element.getNombre().equals(jue.getNombre())){
                res = true;
                break;
            }
        }
        return res;
    }

    public Juego getJue() {
        return jue;
    }
    
}
