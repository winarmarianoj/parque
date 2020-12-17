package logica.controladora;

import java.util.List;
import logica.logger.Errors;
import logica.Entrada;
import logica.excepciones.EntradaException;
import logica.validador.ValidaEntrada;
import persistencia.ControlPersisEntrada;

public class ControlEntrada {
    
    private final ControlPersisEntrada cent;
    private final ValidaEntrada vent;
    private final Errors errors;
    private final Entrada ent;

    public ControlEntrada(ValidaEntrada vent, ControlPersisEntrada cent, Errors errors, Entrada ent) {
        this.cent = cent;
        this.vent = vent;
        this.errors = errors;
        this.ent = ent;
    }
    
    //Crea Entrada
    public boolean creaEntrada(Entrada ent){        
        boolean res = false;        
        try{
            if(vent.validaEntrada(ent)){
               res = cent.createEntrada(ent);
            }
        } catch(EntradaException e){
            errors.logError(e.getMessage());
        }         
        return res;
    }
    
    //Modifica Entrada
    public boolean modifEntrada(Entrada ent){
        return cent.modifEntrada(ent);
    }
    
    //Elimina Entrada
    public boolean eliminaEntrada(int entId){
        return cent.eliminaEntrada(entId);
    }

    //Devuelve la Lista de Entradas
    public List<Entrada> traerEntradas() {
        return cent.traerEntrada();
    }

    //Devuelve a un Entrada en Particular
    public Entrada traerEntradaEnParticular(int id) {
        return cent.traerUnEntrada(id);
    }  

    public Entrada getEnt() {
        return ent;
    }
    
}
