package logica;

import javax.persistence.Basic;
import javax.persistence.Entity;

public abstract class Persona {
   
    String nombre;
    String apellido;
    
    public abstract boolean logueoEmpleado();
    public abstract boolean entradaCliente();
}
