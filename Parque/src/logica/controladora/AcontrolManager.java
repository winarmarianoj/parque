package logica.controladora;

import logica.factory.ControladoraFactory;

public class AcontrolManager {
    
    private final ControlCliente ccli;
    private final ControlEmpleado cemp;
    private final ControlEntrada cent;
    private final ControlHorario chor;
    private final ControlJuego cjue;
    private final ControlUsuario cusu;
    
    public AcontrolManager(){
        ControladoraFactory factory = new ControladoraFactory();
        this.ccli = factory.createControlCliente();
        this.cemp = factory.createControlEmpleado();
        this.cent = factory.createControlEntrada();
        this.chor = factory.createControlHorario();
        this.cjue = factory.createControlJuego();
        this.cusu = factory.createControlUsuario();
    }
    
    
    
}
