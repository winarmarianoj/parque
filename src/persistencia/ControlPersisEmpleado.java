package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Empleado;
import persistencia.JPA.EmpleadoJpaController;
import persistencia.exceptions.NonexistentEntityException;

public class ControlPersisEmpleado {
    EmpleadoJpaController cemp = new EmpleadoJpaController();

    public boolean createEmpleado(Empleado emp) {
        return cemp.create(emp);
    }

    public boolean modifEmp(Empleado emp) {
        boolean res = false;
        try {
            if(cemp.edit(emp)){res=true;}
        } catch (Exception ex) {
            Logger.getLogger(ControlPersisEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean eliminaEmpleado(int empId) {
        boolean res = false;
        try {
            if(cemp.destroy(empId)){res=true;}
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlPersisEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public List<Empleado> traerEmpleado() {
        return cemp.findEmpleadoEntities();
    }

    public Empleado traerUnEmpleado(int id) {
        return cemp.findEmpleado(id);
    }
    
}
