package logica.controladora;

import java.util.List;
import logger.Errors;
import logica.Empleado;
import logica.Usuario;
import logica.excepciones.EmpleadoException;
import logica.excepciones.UsuarioException;
import logica.validador.ValidaEmpleado;
import persistencia.ControlPersisEmpleado;
import persistencia.JPA.EmpleadoJpaController;

public class ControlEmpleado {
    
    private final ControlPersisEmpleado cemp;
    private final ValidaEmpleado vemp;
    private final Errors errors;

    public ControlEmpleado(ValidaEmpleado vemp, ControlPersisEmpleado cemp, Errors errors) {
        this.cemp = cemp;
        this.vemp = vemp;
        this.errors = errors;
    }    
    
    //Crea Empleado
    public boolean creaEmpleado(Empleado emp){
        boolean res = false;        
        try{
            if(vemp.validaEmpleado(emp)){
            res = cemp.createEmpleado(emp);
            }
        } catch(EmpleadoException e){
            errors.logError(e.getMessage());
        }         
        return res;
    }
    
    //Modifica Empleado
    public boolean modifEmpleado(Empleado emp){
        return cemp.modifEmp(emp);
    }
    
    //Elimina Empleado
    public boolean eliminaEmpleado(int empId){
        return cemp.eliminaEmpleado(empId);
    }

    //Devuelve la Lista de Empleados
    public List<Empleado> traerEmpleado() {
        return cemp.traerEmpleado();
    }

    //Devuelve a un Empleado en Particular
    public Empleado traerEmpleadoEnParticular(int id) {
        return cemp.traerUnEmpleado(id);
    }   
    
}
