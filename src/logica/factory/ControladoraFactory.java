
package logica.factory;

import logger.Errors;
import logica.controladora.ControlContacto;
import logica.controladora.ControlHorario;
import logica.controladora.ControlJuego;
import logica.controladora.ControlUsuario;
import logica.validador.ValidaContacto;
import logica.validador.ValidaHorario;
import logica.validador.ValidaJuego;
import logica.validador.ValidaUsuario;
import persistencia.ControlPersisContacto;
import persistencia.ControlPersisHorario;
import persistencia.ControlPersisJuego;
import persistencia.ControlaPersisUsuario;


public class ControladoraFactory {
    
    public ControlUsuario createControlUsuario(){
        ValidaUsuario validaUsuario = new ValidaUsuario();
        ControlaPersisUsuario cusu = new ControlaPersisUsuario();
        Errors errors = Errors.getInstance();        
        return new ControlUsuario(validaUsuario, cusu,errors);
    }
    
    public ControlHorario createControlHorario(){
        ValidaHorario vhor = new ValidaHorario();
        ControlPersisHorario chor = new ControlPersisHorario();
        Errors errors = Errors.getInstance();        
        return new ControlHorario(vhor,chor,errors);
    }
    
    public ControlJuego createControlJuego(){
        ValidaJuego vjue = new ValidaJuego();
        ControlPersisJuego cjue = new ControlPersisJuego();
        Errors errors = Errors.getInstance();
        return new ControlJuego(vjue,cjue,errors);
    }
    
    public ControlContacto createControlContacto(){
        ValidaContacto vcon = new ValidaContacto();
        ControlPersisContacto ccon = new ControlPersisContacto();
        Errors errors = Errors.getInstance();
        return new ControlContacto(vcon,ccon,errors);
    }
    
}
