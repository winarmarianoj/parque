package logica.controladora;

import java.util.List;
import logica.logger.Errors;
import logica.Empleado;
import logica.excepciones.EmpleadoException;
import logica.validador.Validar;
import persistencia.ControlPersisEmpleado;

public class ControlEmpleado {
    
    private final ControlPersisEmpleado cemp;
    private final Validar vemp;
    private final Errors errors;
    private final Empleado emp;

    public ControlEmpleado(Validar vemp, ControlPersisEmpleado cemp, Errors errors, Empleado emp) {
        this.cemp = cemp;
        this.vemp = vemp;
        this.errors = errors;
        this.emp = emp;
    }    
    
    //Crea Empleado
    public boolean creaEmpleado(Empleado emp){
        boolean res = false; 
        try{
            if(!searchEmpleado(emp)){
                if(vemp.validaEmpleado(emp)){
                    res = cemp.createEmpleado(emp);
                }
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
    
    private boolean searchEmpleado(Empleado emp){
        boolean res = false;
        List<Empleado> listEmpleado = traerEmpleado();
        for(Empleado element : listEmpleado){
            if(element.getNombre().equals(emp.getNombre())){
                res = true;
                break;
            }
        }
        return res;
    }

    public Empleado getEmp() {
        return emp;
    }   
    
}
