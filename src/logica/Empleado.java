package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    int empleado_id;
    
    @Basic
    String cargo;
    
    @OneToOne
    Usuario usuario;    

    public Empleado() {
    }

    public Empleado(int empleado_id, String cargo, Usuario usuario) {
        this.empleado_id = empleado_id;
        this.cargo = cargo;
        this.usuario = usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    

    @Override
    public boolean logueoEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean entradaCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
