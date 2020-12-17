package logica.factory;

import logica.Cliente;
import logica.Empleado;
import logica.Entrada;
import logica.Horario;
import logica.Juego;
import logica.Usuario;
import logica.logger.Errors;
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
        Usuario usu = new Usuario();
        return new ControlUsuario(vusu, cusu,errors,usu);
    }
    
    public ControlHorario createControlHorario(){
        Validar vhor = new Validar();
        ControlPersisHorario chor = new ControlPersisHorario();
        Errors errors = Errors.getInstance();    
        Horario hor = new Horario();
        return new ControlHorario(vhor,chor,errors,hor);
    }
    
    public ControlJuego createControlJuego(){
        Validar vjue = new Validar();
        ControlPersisJuego cjue = new ControlPersisJuego();
        Errors errors = Errors.getInstance();
        Juego jue = new Juego();
        return new ControlJuego(vjue,cjue,errors,jue);
    }
    
    public ControlCliente createControlCliente(){
        Validar vcli = new Validar();
        ControlPersisCliente ccli = new ControlPersisCliente();
        Errors errors = Errors.getInstance();
        Cliente cli = new Cliente();
        return new ControlCliente(vcli,ccli,errors,cli);
    }
    
    public ControlEmpleado createControlEmpleado(){
        Validar vemp = new Validar();
        ControlPersisEmpleado cemp = new ControlPersisEmpleado();
        Errors errors = Errors.getInstance();
        Empleado emp = new Empleado();
        return new ControlEmpleado(vemp,cemp,errors,emp);
    }
    
    public ControlEntrada createControlEntrada(){
        ValidaEntrada vent = new ValidaEntrada();
        ControlPersisEntrada cent = new ControlPersisEntrada();
        Errors errors = Errors.getInstance();
        Entrada ent = new Entrada();
        return new ControlEntrada(vent,cent,errors,ent);
    }
}
