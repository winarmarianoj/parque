package logica.controladora;

import logica.factory.ControladoraFactory;

public class ManagerControl {
    
    private final ControlCliente ccli;
    private final ControlEmpleado cemp;
    private final ControlEntrada cent;
    private final ControlHorario chor;
    private final ControlJuego cjue;
    private final ControlUsuario cusu;
    
    public ManagerControl(){
        ControladoraFactory factory = new ControladoraFactory();
        this.ccli = factory.createControlCliente();
        this.cemp = factory.createControlEmpleado();
        this.cent = factory.createControlEntrada();
        this.chor = factory.createControlHorario();
        this.cjue = factory.createControlJuego();
        this.cusu = factory.createControlUsuario();
    }

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
