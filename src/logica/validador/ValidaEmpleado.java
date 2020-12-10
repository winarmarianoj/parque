package logica.validador;

import logica.Empleado;
import logica.excepciones.EmpleadoException;

public class ValidaEmpleado {
    public boolean validaEmpleado(Empleado emp) throws EmpleadoException{
        boolean res = validaNombre(emp.getNombre());
        res &= validaApellido(emp.getApellido());
        
        if(!res){throw new EmpleadoException();}
        return res;
    }

    private boolean validaNombre(String nombre) {
        return !nombre.isEmpty();
    }
    private boolean validaApellido(String apellido){
        return !apellido.isEmpty();
    }
}
