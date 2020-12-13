package logica.controladora;

import logger.Errors;
import logica.Empleado;
import logica.Usuario;
import logica.excepciones.UsuarioException;
import logica.factory.ControladoraFactory;

public class ManagerControl {
    
    private final ControlCliente ccli;
    private final ControlEmpleado cemp;
    private final ControlEntrada cent;
    private final ControlHorario chor;
    private final ControlJuego cjue;
    private final ControlUsuario cusu;
    private final Errors errors;
    
    public ManagerControl(){
        ControladoraFactory factory = new ControladoraFactory();
        this.ccli = factory.createControlCliente();
        this.cemp = factory.createControlEmpleado();
        this.cent = factory.createControlEntrada();
        this.chor = factory.createControlHorario();
        this.cjue = factory.createControlJuego();
        this.cusu = factory.createControlUsuario();
        this.errors = Errors.getInstance();
    }
    
    public boolean logIn(Usuario usu){
        return cusu.logIn(usu);
    }

    public boolean logOut(Usuario usu){
        return cusu.logOut(usu);
    }    

    // Getters de todos los Controladores
    public ControlCliente getCcli() {
        return ccli;
    }

    public ControlEmpleado getCemp() {
        return cemp;
    }

    public ControlEntrada getCent() {
        return cent;
    }

    public ControlHorario getChor() {
        return chor;
    }

    public ControlJuego getCjue() {
        return cjue;
    }

    public ControlUsuario getCusu() {
        return cusu;
    }
    
    
    
}
