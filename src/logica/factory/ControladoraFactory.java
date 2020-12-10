
package logica.factory;

import logger.Errors;
import logica.controladora.ControlCliente;
import logica.controladora.ControlEmpleado;
import logica.controladora.ControlEntrada;
import logica.controladora.ControlHorario;
import logica.controladora.ControlJuego;
import logica.controladora.ControlUsuario;
import logica.validador.ValidaCliente;
import logica.validador.ValidaContacto;
import logica.validador.ValidaEmpleado;
import logica.validador.ValidaEntrada;
import logica.validador.ValidaHorario;
import logica.validador.ValidaJuego;
import logica.validador.ValidaUsuario;
import persistencia.ControlPersisCliente;
import persistencia.ControlPersisEmpleado;
import persistencia.ControlPersisEntrada;
import persistencia.ControlPersisHorario;
import persistencia.ControlPersisJuego;
import persistencia.ControlaPersisUsuario;
import persistencia.JPA.EmpleadoJpaController;


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
    
    public ControlCliente createControlCliente(){
        ValidaCliente vcli = new ValidaCliente();
        ControlPersisCliente ccli = new ControlPersisCliente();
        Errors errors = Errors.getInstance();
        return new ControlCliente(vcli,ccli,errors);
    }
    
    public ControlEmpleado createControlEmpleado(){
        ValidaEmpleado vemp = new ValidaEmpleado();
        ControlPersisEmpleado cemp = new ControlPersisEmpleado();
        Errors errors = Errors.getInstance();
        return new ControlEmpleado(vemp,cemp,errors);
    }
    
    public ControlEntrada createControlEntrada(){
        ValidaEntrada vent = new ValidaEntrada();
        ControlPersisEntrada cent = new ControlPersisEntrada();
        Errors errors = Errors.getInstance();
        return new ControlEntrada(vent,cent,errors);
    }
}
