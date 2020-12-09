
package logica.controladora;

import java.util.List;
import logger.Errors;
import logica.Contacto;
import logica.Juego;
import logica.excepciones.ContactoException;
import logica.excepciones.JuegoException;
import logica.validador.ValidaContacto;
import persistencia.ControlPersisContacto;

public class ControlContacto {
    
    private final ControlPersisContacto ccon;
    private final ValidaContacto vcon;
    private final Errors errors;

    public ControlContacto(ValidaContacto vcon, ControlPersisContacto ccon, Errors errors) {
        this.ccon = ccon;
        this.vcon = vcon;
        this.errors = errors;
    }
    
    //Crea Contacto
    public boolean creaContacto(Contacto con) {
        boolean res = false;        
        try{
            if(vcon.validaContacto(con)){
            res = ccon.createContacto(con);
            }
        } catch(ContactoException e){
            errors.logError(e.getMessage());
        }         
        return res;
    }
    
    //Modifica Contacto
    public boolean modifContacto(Contacto con){
        return ccon.modifContacto(con);
    }
    
    //Elimina Contacto
    public boolean eliminaContacto(int conId){
        return ccon.eliminaContacto(conId);
    }

    //Devuelve la Lista de Contactos
    public List<Contacto> traerContacto() {
        return ccon.traerContacto();
    }

    //Devuelve a un Contacto en Particular
    public Contacto traerContactoEnParticular(int id) {
        return ccon.traerUnContacto(id);
    }

    
    
    
}
