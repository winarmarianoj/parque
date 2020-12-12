package logica.factory;

import logger.Errors;
import logica.controladora.ControlCliente;
import logica.controladora.ControlEmpleado;
import logica.controladora.ControlEntrada;
import logica.controladora.ControlHorario;
import logica.controladora.ControlJuego;
import logica.controladora.ControlUsuario;
import logica.validador.ValidaEntrada;
import logica.validador.Validar;
import persistencia.ControlPersisCliente;
import persistencia.ControlPersisEmpleado;
import persistencia.ControlPersisEntrada;
import persistencia.ControlPersisHorario;
import persistencia.ControlPersisJuego;
import persistencia.ControlaPersisUsuario;


public class ControladoraFactory {
    
    public ControlUsuario createControlUsuario(){
        Validar vusu = new Validar();
        ControlaPersisUsuario cusu = new ControlaPersisUsuario();
        Errors errors = Errors.getInstance();        
        return new ControlUsuario(vusu, cusu,errors);
    }
    
    public ControlHorario createControlHorario(){
        Validar vhor = new Validar();
        ControlPersisHorario chor = new ControlPersisHorario();
        Errors errors = Errors.getInstance();        
        return new ControlHorario(vhor,chor,errors);
    }
    
    public ControlJuego createControlJuego(){
        Validar vjue = new Validar();
        ControlPersisJuego cjue = new ControlPersisJuego();
        Errors errors = Errors.getInstance();
        return new ControlJuego(vjue,cjue,errors);
    }
    
    public ControlCliente createControlCliente(){
        Validar vcli = new Validar();
        ControlPersisCliente ccli = new ControlPersisCliente();
        Errors errors = Errors.getInstance();
        return new ControlCliente(vcli,ccli,errors);
    }
    
    public ControlEmpleado createControlEmpleado(){
        Validar vemp = new Validar();
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
